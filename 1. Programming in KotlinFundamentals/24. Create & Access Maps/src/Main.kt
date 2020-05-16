fun main() {
    val videoGamesCollection = mutableMapOf<String, MutableList<String>>()

    println(videoGamesCollection)

    videoGamesCollection.put("Action", mutableListOf(
        "Dark Souls", "PES"))

    println(videoGamesCollection)

    val actionGame = videoGamesCollection["Action"]
    println(actionGame)
    val strategyGame = videoGamesCollection["strategy"]
    println(strategyGame)

    val authenticationHeaders = mapOf(
        "API_KEY" to "your-api-key",
        "Authorization" to "auth token",
        "content/type" to "application/json"
    )

    println(authenticationHeaders)
}