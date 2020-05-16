fun main() {
    val visitedCountry = arrayOf(
        "Russia" ,"USA", "Poland",
        "The Netherlands", "Romania", "Greece",
        "Germany" , "Spain", "Portugal",
        "Serbia", "Hungary", "Austria"
    )

    var i = 0
    while (i< visitedCountry.size){
        println("Country at index $i is ${visitedCountry[1]}")
        i += 1
    }

    i=0

    do{
        println("Country at index $i is ${visitedCountry[1]}")
        i += 1
    } while (i< visitedCountry.size)
}