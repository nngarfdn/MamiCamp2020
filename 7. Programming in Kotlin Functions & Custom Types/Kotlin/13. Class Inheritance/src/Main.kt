data class Grade(val courseName: String, val letter: Char, val credits: Double)

open class Person(var firstName: String, var lastName: String) {
    fun fullName() = "$firstName $lastName"
}

open class Student(firstName: String, lastName: String,
              var grades: MutableList<Grade> = mutableListOf<Grade>())
    : Person(firstName, lastName){

    fun recordGrade(grade: Grade) {
        grades.add(grade)
    }
}

class BandMember (firstName: String, lastName: String): Student(firstName, lastName) {
    var minimumPraticeTime : Int = 2

}

class StudentAthelete (firstName: String, lastName: String) : Student(firstName, lastName) {
    var isEligible : Boolean = true
}

fun main() {
    val jon = Person("Jon", "Snon")
    val jane = Student("Jane", "Snane")
    val victor = BandMember("Victor", "Wooten")
    val marty = StudentAthelete("Marty", "McWolf")


    println(jon.fullName())
    println(jane.fullName())
    println("${victor.fullName()} practice for ${victor.minimumPraticeTime} hours !")
    println("Can ${marty.fullName()} play in the big game ${marty.isEligible}")

    val robotics = Grade("Robotics", 'B', 3.0)
    jane.recordGrade(robotics)
    println(jane.grades)

}