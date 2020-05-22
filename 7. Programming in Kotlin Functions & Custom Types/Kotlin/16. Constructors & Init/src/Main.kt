import javax.swing.text.html.MinimalHTMLWriter

// 3-05 Constructors & Init - Starter

data class Grade(val courseName: String, val letter: Char)

open class Student(var firstName: String, var lastName: String,
                   var grades: MutableList<Grade> = mutableListOf<Grade>()) {
    open fun recordGrade(grade: Grade) {
        grades.add(grade)
    }
}

class BandMember(firstName: String, lastName: String): Student(firstName, lastName) {


    var minimumPracticeTime: Int = 2
    val isEligible
        get() = grades.none { it.letter == 'F' }

    constructor(firstName: String, lastName: String, minimalPracticeTime : Int): this(firstName,lastName){
        this.minimumPracticeTime = minimumPracticeTime
    }

    constructor(tranfer : BandMember) : this(tranfer.firstName, tranfer.lastName, tranfer.minimumPracticeTime){
        grades = tranfer.grades
        if(!isEligible) minimumPracticeTime += 1
        println("(transfer cronstructor) Practice for $minimumPracticeTime hours!")
    }

    init {
        if(!isEligible) minimumPracticeTime += 1
        println("(init) Practice for $minimumPracticeTime hours!")
    }
    init {
        if(!isEligible) minimumPracticeTime += 1
        println("(init2) Practice for $minimumPracticeTime hours!")
    }



}


fun main() {
    val bill = BandMember("Nill", "S. Preston, Esq")

    bill.recordGrade(Grade("Motivational Speaking", 'A'))
    bill.recordGrade(Grade("Guitar 101" , 'F'))

    val tranferredBill = BandMember(bill)
    println(tranferredBill.grades)
    val ted = BandMember("TeD", "Thedore Loga", 7)
}