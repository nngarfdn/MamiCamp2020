fun main() {
    val visitedCountries = arrayOf(
        "Russia","USA", "Poland",
        "The Netherlands", "Romania", "Greece",
        "Germany", "Spain" , "Portugal",
        "Serbia", "Hungary", "Austria"
    )

    val range = 1..10
    println(range)

    val exclusiveRange = 0 until 10
    println(exclusiveRange)

    for (i in range step 2) {
        print(i)
    }
    println("")

    for (i in 10 downTo 0){
        print(i)
    }
    println()

    for (countryIndex in 0..visitedCountries.size -1) {
        print("${visitedCountries[countryIndex]} ")
    }

    println()

    for (country in visitedCountries){
        print("$country ")
    }
}