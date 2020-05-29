package com.example.listmaker

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.text.InputType
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.content_main.view.*
import kotlinx.android.synthetic.main.fragment_todo_list.*
import kotlinx.android.synthetic.main.fragment_todo_list.view.*
import kotlinx.android.synthetic.main.fragment_todo_list.view.fab

class TodoListFragment : Fragment(), ToDoListAdapter.TodoListClickListener {


    private lateinit var todoListRecyclerView: RecyclerView
    private lateinit var listDataManager: ListDataManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_todo_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.let {
            listDataManager = ViewModelProviders.of(this).get(ListDataManager::class.java)
        }
        val lists = listDataManager.readLists()
        todoListRecyclerView = view.lists_recyclerview
        todoListRecyclerView.layoutManager = LinearLayoutManager(activity)
        todoListRecyclerView.adapter = ToDoListAdapter(lists, this)


        fab.setOnClickListener { _ ->
            showCreateTodoListDialog()
        }

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)


    }


    interface OnFragmentInteractionListener {
        fun onTodoListClicked(list: TaskList)
    }

    companion object {
        fun newInstance(): TodoListFragment {
            return TodoListFragment()
        }
    }

    override fun listItemClicked(list: TaskList) {
        showTaskListItems(list)

    }

    fun addList(list: TaskList) {
        listDataManager.saveList(list)
        val todoAdapter = todoListRecyclerView.adapter as ToDoListAdapter
        todoAdapter.addList(list)
    }

    fun saveList(list: TaskList) {
        listDataManager.saveList(list)
        updateList()
    }

    private fun updateList() {
        val lists = listDataManager.readLists()
        todoListRecyclerView.adapter = ToDoListAdapter(lists, this)
    }

    private fun showCreateTodoListDialog() {
        activity?.let {
            val dialogTitle = getString(R.string.dialog_title)
            val positiveButtonTitle = getString(R.string.create)
            val myDialog = AlertDialog.Builder(it)
            val todoTitleEditText = EditText(it)
            todoTitleEditText.inputType =
                InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_CAP_WORDS

            myDialog.setTitle((dialogTitle))
            myDialog.setView(todoTitleEditText)

            myDialog.setPositiveButton(positiveButtonTitle) { dialog, _ ->
                val list = TaskList(todoTitleEditText.text.toString())
                addList(list)
                dialog.dismiss()
                showTaskListItems(list)
            }
            myDialog.create().show()
        }
    }

    private fun showTaskListItems(list: TaskList) {
      view?.let {
          val action = TodoListFragmentDirections.actionTodoListFragmentToTaskDetailFragment(list.name)
            it.findNavController().navigate(action)
        }
    }


}
