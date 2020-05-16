class Person(name: String,
             lastName : String?,
             age : Int
) {
    var name: String  = name
    var lastName : String? = lastName
    var age : Int = age
}

class Empty

fun main() {
    val filip = Person("Filip","Arifudin",19)

    println(filip)
    println("${filip.name}, ${filip.name}, ${filip.lastName}")

    val filipClone = filip

    filip.age = 24
    println(filip.age)
    println(filipClone.age)

    val filipTwo = Person("Filip", "Arifudin", 24)
    println(filip == filipClone)
}