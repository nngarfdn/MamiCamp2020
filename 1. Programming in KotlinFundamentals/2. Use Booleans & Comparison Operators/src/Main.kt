fun main() {
    val isProgramingAwesome = true

    println("Is programming ? $isProgramingAwesome")

    val myAge = 23

    val isLegalDrivingAge : Boolean = myAge >= 18
    println(isLegalDrivingAge)

    val ageTim = 27
    val isTimOlder : Boolean = ageTim > myAge
    println(isTimOlder)

    val yearsOfBirth = 1996

    val isBornInTwentiethCentury: Boolean = yearsOfBirth < 2000
    println(isBornInTwentiethCentury)

    val strangeName = "Tim"
    val myName = "Filip"

    val isSameName : Boolean = strangeName == myName
    println(isSameName)

    val areNamesDifferent: Boolean = myName != strangeName
    println(areNamesDifferent)

    println(!areNamesDifferent)

    val firstObject = Any()
    val scondObject = Any()

    println(firstObject === scondObject)
    println(firstObject !== scondObject)

    val isEmpty : Boolean = myName.isEmpty()
    println(isEmpty)
}