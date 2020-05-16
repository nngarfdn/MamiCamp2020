fun main() {
    val myAge = 23

    println(if (myAge>= 18) "I'm an adult" else "I'm still underaged")

    if (myAge>=18){
        val country = "Croatia"

        if (country == "USA") {
            println("You're allowed to drive, but not to drink")
        }else if (country=="Croatia"){
            println("you're allowed to both drink and drive (not at the same time!)")
        }
    }

    val yearOfBirth = 1996

    val generationCobort = if (yearOfBirth > 1994 && yearOfBirth < 1988){
        "Generation X"
    } else if (yearOfBirth > 1979 && yearOfBirth < 1995) {
        "Millenial"
    } else {
        "Generation Z"
    }

    println(generationCobort)
}