fun main() {

//    val country1 = "russia"
//    val country2 = "USA"
//    val country3 = "Polandia"

    val visitedCountry = arrayOf(
        "Russia",
        "USA" ,
        "Poland",
        "Indonesia"
    )

    println(visitedCountry)
    println(visitedCountry.size)

    println(visitedCountry[2])
//    println(visitedCountry[32])
//    println(visitedCountry[-1])
    visitedCountry + "Belgia"
    println(visitedCountry.size)

    visitedCountry[1] = "thailand"
    println(visitedCountry[1])

    val sizeArray = Array(10){""}
    val emptyArray = emptyArray<String>()

    val arrayOfInts = intArrayOf(2,3,4,5,6,7)
    println(arrayOfInts)

    val intArray = IntArray(10)
    println(intArray)

    println(visitedCountry.lastIndex)
    println(visitedCountry.last())
    println(visitedCountry.first())

    val currentCountry = "Indonesia"
    println(visitedCountry.contains(currentCountry))

    val hasVisitedIndonesia = currentCountry in visitedCountry
    val hasVisitedMalaysia = currentCountry in visitedCountry
    println(hasVisitedIndonesia)
    println(hasVisitedMalaysia)

}