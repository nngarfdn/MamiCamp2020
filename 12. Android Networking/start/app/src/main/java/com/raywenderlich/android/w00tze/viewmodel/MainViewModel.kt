package com.raywenderlich.android.w00tze.viewmodel

import android.app.Application
import android.net.Uri
import androidx.lifecycle.AndroidViewModel
import com.raywenderlich.android.w00tze.BuildConfig
import com.raywenderlich.android.w00tze.app.Injection
import com.raywenderlich.android.w00tze.model.AccesToken
import com.raywenderlich.android.w00tze.model.AuthenticationPrefs
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val authApi = Injection.provideAuthApi()

    fun isAuthenticated() = AuthenticationPrefs.isAuthenticated()

    fun getAccesToken(uri: Uri, callback: () -> Unit) {

        val accesCode = uri.getQueryParameter("code")

        authApi.getAccesToken(BuildConfig.CLIENT_ID, BuildConfig.CLIENT_SECRET, accesCode!!).enqueue(object : Callback<AccesToken> {
            override fun onResponse(call: Call<AccesToken>, response: Response<AccesToken>) {
                val accesToken = response?.body()?.accesToken
                val tokenType = response?.body()?.tokenType
                if (accesToken != null && tokenType != null) {
                    AuthenticationPrefs.saveAuthToken(accesToken)
                    AuthenticationPrefs.saveTokenType(tokenType)
                    callback()
                }
            }
            override fun onFailure(call: Call<AccesToken>, t: Throwable) {
                println("ERROR GETTING TOKEN")
            }
        })
    }

    fun logout() {
        AuthenticationPrefs.saveAuthToken("")
        AuthenticationPrefs.clearUsername()
    }
}