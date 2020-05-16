fun main() {

    val pets = mapOf("Teemo" to "Gray house cat",
    "Cupka" to "Black hamster",
    "Jura" to "Golden Retriver dog")

    for ((name , breed) in pets) {
        println("The pet $name is a $breed")
    }
}