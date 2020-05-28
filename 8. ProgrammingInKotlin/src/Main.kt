import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.math.sqrt
import kotlin.properties.Delegates

typealias operation = (Int, Int) -> Int

fun main() {
//    kotlinBasic()
//    pairAndTriple()
//    challengePairAndTriple()
//    boolean()
//    challengeBoolean()
//    scope()
//    -------------------------------
//    whileLoops()
//    challengeWhileLoop()
//     forLoop()
//    challengeForLoop()
//    whileExpression()
//    challengeWhenExpression()
//    -------------------------------
//    introdutionToFunction()
//    challengeIntrodutionToFunction()
//    moreFunction()
//    introductionToNullables()
//    challengeIntroductionToNullables()
//    arrays()
//    challengeArrays()
//    list()
//    challengeList()
//    maps()
//    challengeMaps()
//     mutablevsImmutable()
//    higherordervsLamdas()
//    lamdaSyntax()
//    challengeLamda()
//    generics()
//    challengeGenerics()
//    collectionMethod()
//    creation()
//    initializers()
//    challengeCreation()
//    inheritance()
//    dataClasses()
//    challengeDataClass()
//    openandSealedClasses()
//    singletons()
//    chalengeSingleton()
//    companion()
//    interfaces()
//    challengeInterfaces()
//    enum()
//    challengeEnum()
//    extension()
//    getterSetter()
//    visibility()
//    thisi()
//    lateInt()
//   challengeLateInit()
//    delegatedProperties()
    challengeProperties()

}

data class Course2(var classname: String) {
    val courseDescription: String by lazy {
        "Course ${classname} tought by $teacherName"
    }

    private lateinit var teacherName : String

    var room: String by Delegates.observable("No Room") { property, oldValue, newValue ->
        println("New value is $newValue")
    }

    fun setTeacher(teacher: String) {
        teacherName = teacher
    }

}

fun challengeProperties() {
    val course = Course2("Math")
    course.setTeacher("Ms Price")
    course.room = "Library"
    println("Course description ${course.courseDescription}")
    println("Course is ${course}")
}

data class Course1(val map: Map<String, Any?>) {
    val room: String by map
    val teacher: String by map
}

fun delegatedProperties() {
    val course = Course1(mapOf("room" to "room 1", "teacher" to "Ms Price"))
    println(course)
}

class Course(var className: String) {
    lateinit var teacherName: String

    fun setTeacher(teacher: String) {
        teacherName = teacher
    }
}

fun challengeLateInit() {
    val cource = Course("Math")
    cource.setTeacher("Ms Price")

    println(cource.teacherName)
}

class Person5(var firstName: String, var lastName: String) {
    lateinit var fullName: String

    init {
        fullName = firstName + " " + lastName
    }

    fun printFulllName() {
        if (!this::fullName.isInitialized) {
            fullName = firstName + " " + lastName
        }
        println(fullName)
    }
}

fun lateInt() {

}

class Person4 {
    var firstName = ""
    var child = Child()

    fun setFirst(firstName: String) {
        this.firstName = firstName
    }

    inner class Child {
        var firstName = ""

        fun printParentAge() {
            println("Child ${this@Child.firstName} with parent ${this@Person4.firstName}")
        }
    }
}


fun thisi() {
    val person = Person4()
    person.firstName = "Sam"
    person.child.firstName = " Suzy"
    person.child.printParentAge()

    println("Hello there ${"Sammy".lastChar()}")
}

open class Person0 {
    internal val firstName: String = "Sam"

}
//class Student3  {
//    fun printStudentData() {
//    }
//}

fun visibility() {

}

class Prson3(var firstName: String? = null, var lastName: String?) {
    val fullName: String
        get() {
            return firstName + " " + lastName
        }
    var otherName: String = ""
        private set
}

var itemList: ArrayList<String> = ArrayList<String>()
    set(value) {
        field = value
    }

fun getterSetter() {
    val persin = Prson3("Sam", "Smith")
    println("Person : ${persin.firstName} ${persin.lastName}")
}

class MovieList(val genre: String) {

    val movies = ArrayList<String>()
    fun print() {
        println("Movie List : $genre")
        for (movie in movies) {
            print(movie + " ")
        }
        println("")
    }
}

val MovieList.movieSize: Int
    get() = movies.size

fun String.lastChar(): Char = this.get(this.length - 1)
fun extension() {
    println("The last character is ${"My Text".lastChar()}")
}

enum class Animal1 {
    CAT, DOG, RAT, BIRD, HAMSTER;
}

enum class Cage {
    SMALL, MEDIUM, LARGE
}

fun addAnimalToCage(animal: Animal1, cage: Cage) {
    println("The $animal is in the $cage cage")
}

fun challengeEnum() {
    addAnimalToCage(Animal1.BIRD, Cage.LARGE)
    addAnimalToCage(Animal1.CAT, Cage.MEDIUM)
}

enum class Direction {
    NORT, SOUNTH, WEST, EAST
}

enum class Colour(val r: Int, g: Int, b: Int) {
    RED(255, 0, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0)
}

fun drive(direction: Direction) {
    when (direction) {
        Direction.NORT -> println("Driving Nort")
        Direction.SOUNTH -> println("Driving South")
        Direction.WEST -> println("Driving West")
        Direction.EAST -> println("Driving East")
    }
}

fun enum() {
    drive(Direction.NORT)
    drive(Direction.WEST)

    println(Direction.NORT.ordinal)

}

interface Shape {
    var width: Int
    var height: Int
    fun draw()
}

class Circle(override var width: Int, override var height: Int) : Shape {
    override fun draw() {
        println("Drawing a Circle")
    }
}

class Line(override var width: Int, override var height: Int) : Shape {
    override fun draw() {
        println("Drawing a Line")
    }
}

fun printShape(shape: Shape) {
    shape.draw()
}


fun challengeInterfaces() {
    val circle = Circle(10, 10)
    val line = Line(10, 10)

    printShape(circle)
    printShape(line)

}

interface Animal {
    fun eat()
    val numLegs: Int
}

class Dog : Animal {
    override val numLegs: Int = 4
    override fun eat() {
        println("Dog eating Loudly")
    }
}

class Cat : Animal {
    override val numLegs: Int = 4
    override fun eat() {
        println("Cat eating softly")
    }

    fun meow() {
        println("Mew meow")
    }
}


fun interfaces() {
    val dog = Dog()
    val cat = Cat()

    dog.eat()
    cat.eat()
    cat.meow()
}

class Student1 private constructor() {
    var firstName: String? = null
    var lastName: String? = null

    companion object {
        fun loadStudent(jsonText: String): Student1 {
            val student = Student1()
            student.firstName = "FirstName"
            student.lastName = "LastName"
            return student
        }
    }
}

fun companion() {
    val student1 = Student1.loadStudent("Json Text")

}

data class Student(val firstName: String, val lastName: String)
object StudentRegistry {
    val allStudent = mutableListOf<Student>()
    fun addStudent(student: Student) {
        allStudent.add(student)
    }

    fun removeStudent(student: Student) {
        allStudent.add(student)
    }
}

fun chalengeSingleton() {
    val steve = Student("Steve", "Miller")
    val john = Student("John", "Smith")
    StudentRegistry.addStudent(steve)
    StudentRegistry.addStudent(john)

    StudentRegistry.allStudent.forEach {
        println(it.firstName)
    }

}

object MySingleton {
    fun doMyStuff(data: String) {
        println("This is my data $data")
    }

    val myConstant = " This is my Constant"
}

fun singletons() {
    MySingleton.doMyStuff("Hello there" + MySingleton.myConstant)
}

sealed class Expression

data class Num(val number: Double) : Expression()
data class Sum(val e1: Expression, val e2: Expression) : Expression()
object NotANumber : Expression()

fun eval(expr: Expression): Double = when (expr) {
    is Num -> expr.number
    is Sum -> eval(expr.e1) + eval(expr.e2)
    NotANumber -> Double.NaN
}

fun openandSealedClasses() {
    val num1 = Num(5.5)
    val num2 = Num(10.0)
    println("The sum of 5.5 and 10.0 is ${eval(Sum(num1, num2))}")
}

fun challengeDataClass() {
    data class Student(val firstName: String,
                       val lastName: String,
                       val grade: Char)

    data class Student2(val firstName: String,
                        val lastName: String,
                        val grade: Char = 'A')

    var sam = Student("Sam", "Gamgee", 'A')
    println(sam)

    sam = sam.copy(grade = 'B')
    println(sam)

    val fred = Student2("freed", "smith")
    println(fred)

}

fun dataClasses() {
    data class PodCast(val title: String, val description: String,
                       val url: String)

    val podcast = PodCast("Android Central", "The premiere",
            "http://sample.com")
    val podcast2 = podcast.copy(title = "Developer Stage")

    val (title, description, url) = podcast2
    println("title = $title, url = $url")


}

fun inheritance() {
    class Grade(var letter: Char, var points: Double, var credits: Double)
    open class Person(var firstName: String, lastName: String)
    open class Student(firstName: String, lastName: String,
                       var grades: ArrayList<Grade> = ArrayList()) : Person(firstName, lastName) {
        open fun recordGrade(grade: Grade) {
            grades.add(grade)
        }
    }

    val john = Person("Jony", "Applessed")
    val jane = Student("Jane", "Applessed")

    println(john.firstName)
    println(jane.firstName)

    val history = Grade('B', 9.0, 3.0)
    jane.recordGrade(history)

    open class BandMember(firstName: String, lastName: String) : Student(firstName, lastName) {
        open var minimumPractice = 2
    }

    class OboePlayer(firstName: String, lastName: String) : BandMember(firstName, lastName) {
        override var minimumPractice: Int
            get() {
                return super.minimumPractice * 2
            }
            set(value) {
                super.minimumPractice = value / 2
            }
    }

    fun phonebookName(person: Person): String {
        return "${person.firstName}"
    }

    val person = Person("Johny", "Applessed")
    val oboePlayer = OboePlayer("Jane", "Aplessed")

    println(phonebookName(person))
    println(phonebookName(oboePlayer))

    var hallMonitor = Student("Jill", "Bannanapeal")
    hallMonitor = oboePlayer

    (oboePlayer as BandMember).minimumPractice = 4

    (hallMonitor as? BandMember)?.let {
        println("""This hall monitor is a band member and practices at least
            ${hallMonitor.minimumPractice} hours per week.
        """.trimMargin())
    }

    fun afterClassActivity(student: Student): String {
        return "Goes home !"
    }

    fun afterClassActivity(student: BandMember): String {
        return "Goes to practice!"
    }

    println(afterClassActivity(oboePlayer))
    println(afterClassActivity(oboePlayer as Student))

    class StudentAthelete(firstName: String, lastName: String) : Student(firstName, lastName) {
        var failedClasses = ArrayList<Grade>()
        override fun recordGrade(grade: Grade) {
            super.recordGrade(grade)

            if (grade.letter == 'F') {
                failedClasses.add(grade)
            }
        }

        var isEligible: Boolean = true
            get() {
                return failedClasses.size < 3
            }
    }
}

fun challengeCreation() {
    class MoviewList(val genre: String) {
        private val movies = ArrayList<String>()

        fun addMovie(movie: String) {
            movies.add(movie)
        }

        fun print() {
            println("Moview List : $genre")
            for (movie in movies) {
                print(movie + " ")
            }
            println()
        }
    }

    class MovieGoer {
        private var movieList = HashMap<String, MoviewList>()
//        fun addList(list: MoviewList) {
//            movieList[list.genre] = list
//        }

        fun addGenre(genre: String) {
            movieList[genre] = MoviewList(genre)
        }

        fun moviewListFor(genre: String): MoviewList? {
            return movieList[genre]
        }

        fun addMovie(genre: String, movie: String) {
            if (!movieList.containsKey(genre)) {
                addGenre(genre)
            }
            movieList[genre]?.addMovie(movie)
        }
    }

    val jane = MovieGoer()
    val john = MovieGoer()
//    val actionList = MoviewList("Action")
//
//    jane.addList(actionList)
//    john.addList(actionList)

    jane.addMovie("Action", "Rambo")
    jane.addMovie("Action", "Terminator")
    john.addMovie("Action", "Die Hard")

    jane.moviewListFor("Action")?.print()
    john.moviewListFor("Action")?.print()


}

fun initializers() {
    class Person2(var firstName: String, lastName: String) {
        var fullName: String

        init {
            fullName = firstName + " " + lastName
        }
    }

    val person = Person2("Sam", "Gangngee")
    println(person.fullName)
}

class Person1(
        var firstName: String,
        var lastName: String = "Gamgee") {
}

fun creation() {
    val person = Person1("Sam")
    val person2 = Person1("Sam", "Gamgee")

    println("Person1 == ${person.firstName} ${person.lastName}")
    println("Person2 = ${person2.firstName} ${person2.lastName}")

}

fun collectionMethod() {
    val values = listOf(24, 5, 10, 4)
    println(values.filter { it > 5 })

    val names = listOf("Sam", "Fred", "Samuel", "Alice")
    println(names.first { it.length > 5 })

    val cities = listOf("Los Angeles", "San Fransisco", "New York", "San Fransisco")
    println(cities.any { it == "San Antonio" })
    println(cities.any { it.length > 6 })
}

fun challengeGenerics() {

    fun <T> printItem(item: T) {
        println("My Item is $item")
    }

    printItem(1)
    printItem("Hello")

    fun <T> printList(list: List<T>) {
        for (item in list) {
            println("List item : $item")
        }
    }

    printList(listOf("Sam", "Fred", "Suzzy"))
}

interface Repository<T> {
    fun addItem(item: T)
    fun deleteItem(item: T)
}

class Person(val name: String) {}

class PersonRepository : Repository<Person> {
    override fun addItem(item: Person) {
        TODO("Not yet implemented")
    }

    override fun deleteItem(item: Person) {
        TODO("Not yet implemented")
    }

}

fun <T> printItem(item: T) {
    println(item)
}

fun <MyItem> printItem2(item: MyItem) {
    println(item)
}


fun generics() {

    printItem("test")

    val names = ArrayList<String>()
    val myNumbers = ArrayList<Number>()
    myNumbers.add(1)
    myNumbers.add(2.5)
    println(myNumbers)

}

fun challengeLamda() {
    val values = listOf(24, 5, 10, 4)
    println(values.filter { it > 5 }.sum())

    data class Person(val name: String, val age: Int)

    val sam = Person("Sam", 30)

    val (nama, age) = sam
    println("$nama is $age years old")

    val names = mapOf<String, Int>("John" to 34, "Fred" to 24, "Sam" to 30, "Suzzy" to 29)
    for ((name, age) in names) {
        println("$name is $age years old")

    }

}

fun lamdaSyntax() {
    fun handleIntefer(myInt: Int, operation: (Int) -> Unit) {
        operation(myInt)
    }

    handleIntefer(5, { println("My Result is ${it * 10}") })
    handleIntefer(5, { _ -> println("My Result is ${10}") })

    fun printResult(myInt: Int) {
        println("My Int is $myInt")
    }
    handleIntefer(4, ::printResult)

}

fun higherordervsLamdas() {
    val ints = listOf(2, 3, 20, 50)
    println(ints.filter { it > 10 })

    fun List<Int>.filter(operator: (Int) -> Boolean) {

    }

    val myStringList = listOf("Sam", "Suzzy", "Jesse", "Ray", "kevin")
    val updatedList = myStringList.filter { it.length > 3 }.sortedBy { it }
    println(updatedList)


}

fun mutablevsImmutable() {
    var name = ArrayList<String>()
    name.add("Sam")
    name.add("Freed")

    fun printNames(names: List<String>) {
        println(names)

    }
    printNames(name)
    println(name)


}

fun challengeMaps() {
    val kevin = mutableMapOf("name" to "Kevin",
            "profession" to "Tutorial Writer",
            "country" to "Usa",
            "state" to "CA",
            "city" to "petaluma")

    println(kevin)

    kevin["city"] = "Albuquerque"
    kevin["state"] = "New Mexico"

    println(kevin)

    fun printLocation(person: Map<String, String>) {
        val state = if (person.containsKey("state")) person["state"] else ""
        val city = if (person.containsKey("city")) person["city"] else ""
        println("Person lives in $city, $state")
    }

    printLocation(kevin)

}

fun maps() {
    var namesAndScores = mapOf("Anna" to 2, "Brian" to 2, "Craig" to 8, "Dona" to 6)
    println(namesAndScores)
    println(namesAndScores["Anna"])
    println(namesAndScores["Greg"])
    println(namesAndScores.isEmpty())
    println(namesAndScores.count())

    var bobData = mutableMapOf("name" to "Bob",
            "profession" to "Card Player",
            "city" to "OakLand",
            "country" to "USA")

    bobData["profession"] = "Mailman"
    println(bobData)
    bobData.remove("city")
    println(bobData)

    for ((player, score) in namesAndScores) {
        println("$player - $score")
    }

    for (player in namesAndScores.keys) {
        println(("$player, ${namesAndScores[player]}"))
    }

}

fun challengeList() {
    var states = mutableListOf<String>("CA", "VA", "Wa", "LA")
    states.add("OH")
    println(states)

    fun printStates(states: List<String>) {
        for (i in 0..states.size - 1) {
            if (i != 3) {
                println("$i ${states[i]}")
            }
        }
    }
    printStates(states)
}

fun list() {
    val names = listOf("Anna", "Brian", "Craig", "Donna")
    println(names)

    val teamNames = mutableListOf<String>()
    teamNames.addAll(names)
    println(teamNames)
    teamNames.add("Sam")
    teamNames.add("Jan")

    println(teamNames)
    println(names[0])

    println(names.indexOf("Brian"))
    teamNames.remove("Craig")
    println(teamNames)

    for (name in teamNames) {
        println("team Member: $name")
    }

}

fun challengeArrays() {
    var players = arrayOf("Alice", "Bob", "Dan", "Eli", "Frank")

    println("Index of Dan = ${players.indexOf("Dan")}")

    players = arrayOf("Anna", "Brian", "Craig", "Dan", "Donna", "Eli", "Franklin")
    val scores = arrayOf(2, 2, 8, 6, 1, 2, 1)

    var index = 0
    for (player in players) {
        println("${index + 1}. $player - ${scores[index]} ")
        index++
    }
    players.forEachIndexed { index, player ->
        println("${index + 1}. $player - ${scores[index]}")
    }

}

fun arrays() {
    val evenNumbers = arrayOf(2, 4, 6, 8)

    val evenNumbers2: Array<Int> = arrayOf(2, 4, 6, 8)
    val intNumbers = intArrayOf(2, 4, 6, 8)

    val players = arrayOf("Alice", "Bob", "Cindy", "Dan")

    if (players.size < 2) {
        println("we need at least two players")
    } else {
        println("Let's Start")
    }
    println(players.isEmpty())
    println(players.first())

    val firstPlayer = players[0]
    println("First player is $firstPlayer")

    val upComingPlayers = players.sliceArray(0..2)
    for (player in upComingPlayers) {
        println(player)
    }

    fun isEliminated(player: String): Boolean {
        return !players.contains(player)
    }

    println(isEliminated("Bob"))
    println(isEliminated("Fred"))

    players[2] = "Sammy"
    for (player in players) {
        println(player)
    }

    fun sumOfAllItema(array: Array<Int>): Int {
        var sum = 0
        for (number in array) {
            sum += number
        }
        return sum
    }

    println(sumOfAllItema(arrayOf(2, 5, 7, 8)))
    val prices = arrayOf(1, 5, 20, 50)
    val removeFirst = prices.drop(1)
    println(removeFirst)
    println(prices.drop(2))

}

fun challengeIntroductionToNullables() {
    var myFaforiteSong: String? = "Bingung Iksan Skuter"

    fun printFavoriteSong(favorite: String?) {
        println("Your favorite song is $favorite")
    }
    printFavoriteSong(myFaforiteSong)
    myFaforiteSong = null
    printFavoriteSong(myFaforiteSong)

}

fun introductionToNullables() {
    var nickname: String? = null

    fun printNickname(nickname: String?) {
        println("My nickname is $nickname")
    }
    printNickname(nickname)
    nickname = "Kev"
    printNickname(nickname)

}

fun moreFunction() {
    fun printMultipleOf(multiplier: Int, addValue: Int) {}
    fun printMultipleOf(multiplier: Int, addValue: Int, thirdvalue: Int) {}
    fun printMultipleOf(multiplier: Int, addValue: Int, thirdValue: Int, fortValue: Int) {}

    fun getValue(): Int {
        return 31
    }

    fun getValueString(): String {
        return " Kevin Moore"
    }

    fun add(a: Int, b: Int): Int {
        return a + b
    }

    var function: (Int, Int) -> Int = ::add
    println(function(4, 2))

    fun substract(a: Int, b: Int): Int {
        return a - b
    }

    function = ::substract
    println(function(4, 2))

    fun printResult(function: (Int, Int) -> Int, a: Int, b: Int) {
        val result = function(a, b)
        println(result)
    }

    printResult(::add, 4, 2)

    fun printresult2(function: operation, a: Int, b: Int) {}
    fun noReturn(): Unit {

    }

}

fun challengeIntrodutionToFunction() {
    fun printFullName(firstName: String, lastName: String) {
        println(firstName + " " + lastName)
    }
    printFullName(firstName = "KEvin", lastName = "Moore")
    printFullName("Kevin", "More")

    fun calculateFullName(firstName: String, lastName: String): String {
        return firstName + " " + lastName
    }
    println(calculateFullName("Kevin", "Moore"))

    fun calculateFullNameWithLength(firstName: String, lastName: String): Pair<String, Int> {
        val fullName = firstName + " " + lastName
        return Pair(fullName, fullName.length)
    }

    println(calculateFullName("Kevin", "Moore"))


}

fun introdutionToFunction() {
    fun printlMyAge() {
        println("My Name is Nanang Arifudin")
    }
    printlMyAge()

    fun printMultipleOfFive(value: Int) {
        println("${value} * 5 = ${value * 5} ")
    }
    printMultipleOfFive(10)
    fun printMultipleOf(multiplier: Int, addValue: Int) {
        println("$multiplier * $addValue = ${multiplier * addValue}")
    }
    printMultipleOf(4, 2)
    fun printMultipleOf2(multiplier: Int, addValue: Int = 1) {
        println("$multiplier * $addValue = ${multiplier * addValue}")
    }
    printMultipleOf2(4)
    fun multiply(number: Int, multiplier: Int): Int {
        return number * multiplier
    }
    println(multiply(4, 2))

    fun funmultiplyandDivide(number: Int, factor: Int): Pair<Int, Int> {
        return Pair(number * factor, number / factor)
    }

    println("Multiple & Divide ${funmultiplyandDivide(4, 2)}")


}

fun challengeWhenExpression() {
    val myAge = 40
    when (myAge) {
        in 0..2 -> println("Infant")
        in 3..12 -> println("child")
        in 13..19 -> println("Teenager")
        in 20..39 -> println("Adult")
        in 40..60 -> println("Middle aged")
        in 61..110 -> println("Elderly")
        else -> println("Invalid age")
    }

    val pair = Pair("Kevin", 40)
    when (pair.second) {
        in 0..2 -> println("${pair.first} Infant")
        in 3..12 -> println("${pair.first} child")
        in 13..19 -> println("${pair.first} Teenager")
        in 20..39 -> println("${pair.first} Adult")
        in 40..60 -> println("${pair.first} Middle aged")
        in 61..110 -> println("${pair.first} Elderly")
        else -> println("Invalid age")
    }
    val personAge = when (myAge) {
        in 0..2 -> "Infant"
        in 3..12 -> "child"
        in 13..19 -> "Teenager"
        in 20..39 -> "Adult"
        in 40..60 -> "Middle aged"
        in 61..110 -> "Elderly"
        else -> "Invalid age"
    }
    println(personAge)
}

fun whileExpression() {
    val number = 10
    when (number) {
        0 -> println("Zero")
        10 -> println("It's ten!")
        else -> println("Non Zero")
    }

    val string = "Dog"
    when (string) {
        "Cat", "Dog" -> println("Animal is a house cat")
        else -> println("Animal is not a house pet")
    }

    when (number) {
        in 1..9 -> println("Beetwen 1 and 9")
        in 10..20 -> println("Beetwen 10 and 20")
        else -> println("Some other number")
    }

    when {
        number % 2 == 0 -> println("Event")
        else -> println("Odd")
    }

    val testValue = 10
    val result = when {
        testValue < 10 -> "Less than 10"
        testValue > 10 -> "Greather than 10"
        else -> "is equal to 10"
    }
    println(result)

}

fun challengeForLoop() {
    val range = 1..10
    for (i in range) {
        val square = i * i
        println("$square")
    }

    for (i in range) {
        val squareRoot = sqrt(i.toDouble())
        println("$squareRoot")
    }
    var sum = 0
    for (row in 0..8) {
        if (row % 2 == 1) {
            for (column in 0..8) {
                sum += row * column
            }
        }
    }
    println("$sum")
}

fun forLoop() {
    val range = 0..5

    val count = 10
    var sum = 0
    for (i in 1..count) {
        sum += i
    }
    println("sum = $sum")

    for (i in 0..count) {
        println("Hodor!")
    }

    for (i in 1..count) {
        if (i % 2 == 1) {
            println("$i is an odd number")
        }
    }
    for (i in 1..count) {
        println("Hello")
        if (i == 3) {
            continue
        }
        println("GoodBye")
    }
    for (row in 1..3) {
        for (colomn in 1..3) {
            print("$colomn")
        }
        println()
    }

    outer@ for (row in 1..3) {
        for (colomn in 1..3) {
            if (row == 2 && colomn == 2) {
                println()
                continue@outer
            }
            print("$colomn")
        }
        println()
    }
}

fun challengeWhileLoop() {
    var counter = 0
    while (counter < 10) {
        println("Counter is $counter")
        counter += 1
    }

    var count = 0
    var roll = 0
    var random = Random()

    do {
        roll = random.nextInt(6)
        count += 1
        println("After $count roll(s), roll is $roll")
    } while (roll != 0)

}

fun whileLoops() {
    var i = 1
    while (i < 10) {
        print(i)
        i += 1
    }
    println("--------")

    i = 1
    do {
        print(i)
        i += 1
    } while (i < 10)
    println("------")

    i = 1
    do {
        print(i)
        if (i == 5) {
            break
        }
        i += 1
    } while (i < 10)
    println("After do")
}

fun scope() {
    var hoursWorked = 45
    var price = 0.0
    if (hoursWorked > 40) {
        val hoursOvers40 = hoursWorked - 40
        price += hoursOvers40 * 50
        hoursWorked -= hoursOvers40
    }
    price += hoursWorked * 25
    println(price)
    println()
}

fun challengeBoolean() {
    val myAge = 30
    val isTeenager = myAge >= 13 && myAge <= 19
    println("isTeenagers ${isTeenager}")

    val theirAge = 30
    val bothTeenagers = theirAge >= 13 && theirAge <= 19 && isTeenager
    println("bothTeenagers = $bothTeenagers")

    val student = "Joe Blogss"
    val author = "Kevin Moore"
    val authorIsStudent = student == author
    println("authorIsStudent $authorIsStudent")

    val studentBeforeAuthor = student < author
    println("StudentbeforeAuthor $studentBeforeAuthor")

    if (myAge >= 13 && myAge <= 19) {
        println("Teenager")
    } else {
        println("Not a teenager")
    }

    val answer = if (myAge >= 13 && myAge <= 19) "Teenager" else "Not"
    println(answer)

}

fun boolean() {
    val yes1 = true
    val no1 = false

    val yes2 = true
    val no2 = false
    println("yes1 = yes2 ${yes1 == yes2} no1==no2 ${no1 == no2}")

    val doesOneEqualTwo = (1 == 2)
    println("Does 1 equal 2 ${doesOneEqualTwo}")

    val doesOneNotEqualTwo = (1 != 2)
    println("Does 1 equal 2 ${doesOneNotEqualTwo}")

    val longName = "Samantha".length > 5

    println("Longname = ${longName}")

    val and = true && true
    println("and $and")
    val or = true || true
    println("or $or")

    val guess = "dog"
    val dogEqualCat = guess == "cat"
    println("dogEqualCat ${dogEqualCat}")

    val a = 5
    val b = 10

    val min: Int
    if (a < 5) {
        min = a
    } else {
        min = b
    }
    println("min = $min")

}

fun challengePairAndTriple() {
    val date = Pair(8, 16)
    println("date = $date")
    val (month, day) = date
    println("month = $month day = $day")
    val dayOfMonth = Triple(8, 12, 2018)
    println("day of month = $dayOfMonth ")

}

fun pairAndTriple() {
    val coordinates = Pair(2, 3)
    val (x, y) = coordinates
    println("x = $x y= $y")
    println("x = ${coordinates.first} y= ${coordinates.second}")

    val coordinatesDouble = Pair(2.1, 3.5)
    println("x= ${coordinatesDouble.first} y= ${coordinatesDouble.second}")

    val coordinatedMixed = Pair(2.1, 3)
    println("x= ${coordinatedMixed.first} y= ${coordinatedMixed.second}")

    val x1 = coordinates.first
    val y1 = coordinates.second
    println("x1 = ${x1} y1= ${y1}")

    val coordinates3D = Triple(2, 3, 1)
    val (x3, y3, z3) = coordinates3D
    println("x3 = ${x3} y3= ${y3} z3= ${z3}")

    val (x4, y4, _) = coordinates3D
    println("x4 = $x4 y4= $y4")


}

fun kotlinBasic() {
    val temperature = 37.5
    val count: Int = 5
    var name = "Sam"
    name = "Fred"

    fun calculateTemperature(celcius: Double): Double {
        return 9 / 5 * celcius + 32
    }

    println("Temp = ${calculateTemperature(20.0)}")
    println("Temp = ${calculateTemperature(50.0)}")

    val intValue = "32".toInt()
    println("inValue =  $intValue")

    val intString = 32.toString()
    println("intString = $intString")

    val fahrenheit = 32
    when (fahrenheit) {
        in 0..30 -> println("really good")
        in 31..40 -> println("Getting colder")
        in 41..50 -> println("Kind of cold")
        in 51..60 -> println("Nippy")
        in 71..80 -> println("Just right")
    }

    var nullableName: String? = null
    var lengt = nullableName?.length ?: -1
    println(lengt)
    nullableName = "Sam"
    lengt = nullableName?.length ?: -1
    println(lengt)

}
