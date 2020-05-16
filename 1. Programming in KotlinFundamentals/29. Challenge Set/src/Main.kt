fun main() {
    val items = listOf(
        "Bugdroid Toy","USB Adapter", "Mac Dongle","Mac Dongle", "Charging Cable",
        "Tissue", "Pen","Pen", "Pen", "car Keys"
        )

    val uniqueItems = items.toMutableSet()
    println(uniqueItems)

    println(uniqueItems.remove("car Keys"))
    println(uniqueItems.remove("Charging Cable"))

    for (item in uniqueItems) {
        println(item)
    }
}