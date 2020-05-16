fun main() {


data class VideoGame(
     val genre:String,
     val name: String,
     var difficulity: String
)

    val darkSouls = VideoGame("Dark Fantasy RPG", "Dark Soul", "Pretty Hard")
    val devinityOriginalSin = VideoGame("Turn Based Strategy Game & rPG", " Divinity original game 2", "Medium")

    println(darkSouls)
    println(devinityOriginalSin)

    val darksouls2 = darkSouls.copy(name = "Dark Souls 2")

    println(darkSouls == darksouls2)
    println(darkSouls === darksouls2)
    println(darksouls2)

    val (genre, name, difficulity) = darkSouls
    println("$name, $genre, $difficulity")

}