fun main() {
    val games = arrayOf(
        "Dungeons & dragons",
    "Magic: The Gathering",
    "Doom",
    "Dark Souls",
    "Divinity 2: Original Sin")

    games[2] = "DOOM: Eternal"
    println(games[1])

    val gameList = games.toMutableList()
    gameList.addAll(listOf(
        "Sekiro: Shadow Die Twice", "The Legend of Zelds: Breath of the Wild"
    ))

    gameList.remove("Dark Souls")
    println(gameList)

    println("Dark Souls" in gameList)
}