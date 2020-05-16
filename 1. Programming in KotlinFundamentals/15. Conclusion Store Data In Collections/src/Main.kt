fun main() {

    val dayOfWeeks = arrayOf(
        "Monday",
        "Tuesday",
        "Wednesday",
        "Thursday",
        "Friday",
        "Saturday",
        "Sunday"
    )

    dayOfWeeks[4] = "frIDAy"

    val days = dayOfWeeks.toMutableList()
    days.add(5, "Friday")
    days.remove("Monday")

    println(days)

    println("Monday" in days)
}