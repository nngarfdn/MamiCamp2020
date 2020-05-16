fun main() {
    val birthday = Triple(11,12,1996)
    val person = Pair("Filip Babic",24)

    val nameUsingOrdering = person.first
    val birthdayUsingOrdering = person.second

    val (name, bday) = person
    val (day, month, _) = birthday

    val yearBirth = birthday.third
    println("$name was born on $day/$month, year unknown")

}