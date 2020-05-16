
/**
 * Comment example
 * this is multiline comment
 * the function of this comment is for documentation
 * By Nanang Arifudin 2020
 * you can reference here [main] function
 * also, like the [argument]
 *
 * @param argument
 * */
fun main() {
    var myAge: Int = 23
    val name : String = "Filip"
    val lastName = "Babic"
    val weight = 63.5

    println(name)
    println("I am $myAge years old")

    myAge += 1
    println("I am $myAge years old")

    println("$name $lastName is $myAge years old and weight $weight kg")

    val fullName = "$lastName, $name"
    println(fullName)

    val ageFromSrting : Int = "35".toInt()
    println(ageFromSrting)

    val nameLength : Int = fullName.length
    println(nameLength)

    // This is a line comment
    /*
     * this is multiline
     * comment */
}