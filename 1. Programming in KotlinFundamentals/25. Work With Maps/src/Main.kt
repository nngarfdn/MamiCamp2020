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
    // -------------------------------------------------------------

    videoGamesCollection["Strategy"] = mutableListOf("Heroes of Might & Magic 3")
    println(videoGamesCollection)

    videoGamesCollection["Strategy"]?.add("Civilisation VI")
    println(videoGamesCollection)

    val removedActionGames = videoGamesCollection.remove("Action")
    println(removedActionGames)
    println(videoGamesCollection)

//    authenticationHeaders["Authorization"] = "new api key"
    videoGamesCollection["Strategy"]?.add("Command & Conguer")
    videoGamesCollection["Shooter"] = mutableListOf("DOOM")

    for (key in videoGamesCollection.keys) {
        println(key)
    }

    for (value in videoGamesCollection.values){
        println(value)
    }

    for ((key, value) in videoGamesCollection) {
        println("Videogame in $key genre you own are: $value")

    }
}