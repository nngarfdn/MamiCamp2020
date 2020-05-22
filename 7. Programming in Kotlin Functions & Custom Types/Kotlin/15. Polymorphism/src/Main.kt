// 3-04 Polymorphism - Start

data class Grade(val courseName: String, val letter: Char)

open class Person(var firstName: String, var lastName: String) {
    fun fullName() = "$firstName $lastName"
}

open class Student(firstName: String, lastName: String,
                   var grades: MutableList<Grade> = mutableListOf<Grade>()
) : Person(firstName, lastName) {

    open var isEligible: Boolean = true

    open fun recordGrade(grade: Grade) {
        grades.add(grade)
    }
}

class BandMember(firstName: String, lastName: String): Student(firstName, lastName) {
    var minimumPracticeTime: Int = 2

    override var isEligible = true
        get() = grades.none { it.letter == 'F' }

    override fun recordGrade(grade: Grade) {
        super.recordGrade(grade)
        if (!isEligible) println("No more performing for $firstName! Study study study.")
    }
}

class StudentAthlete(firstName: String, lastName: String): Student(firstName, lastName) {
    override fun recordGrade(grade: Grade) {
        super.recordGrade(grade)
        isEligible = grades.filter { it.letter == 'F' }.size < 3
        if (!isEligible) println("$firstName can't play in the big game! Time to study.")
    }
}


fun main() {
    val jon = Person(firstName = "Jon", lastName = "Snon")
    val jane = Student(firstName = "Jane", lastName = "Snane")
    val victor = BandMember("Victor", "Wooten")
    val marty = StudentAthlete("Marty", "McWolf")

    val persons : Array<Person> = arrayOf(jon, jane, victor, marty)
    val students : Array<Student> = arrayOf(jane, victor, marty)

    persons.forEach { person ->
        println("${person.fullName()} is a person!")
        if (person is Student) println(person.grades)
    }

    val student = victor as Student
    val bassist = student as? BandMember

    fun afterClassActivity(student: Student) : String {
        return "Goes home !"
    }
    fun afterClassActivity(student: BandMember) : String {
        return "Practice for ${student.minimumPracticeTime} hours! "
    }

    println(afterClassActivity(victor ))
    println(afterClassActivity(victor as Student))


}