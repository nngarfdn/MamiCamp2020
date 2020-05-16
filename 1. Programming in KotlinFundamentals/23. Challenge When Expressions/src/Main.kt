fun main() {
    val year = 1984

    val century = when (year){
        in 2000..2020 -> "21st century"
        in 1900..1990 -> "20th century"
        in 1800..1890 -> "19th century"
        else -> "That was looong ago!"
    }

    println(century)
}