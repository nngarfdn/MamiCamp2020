fun main() {



class VideoGame(
    private val genre:String,
    private val name: String,
    private var difficulity: String
) {
    fun getData() = "$name is a $genre game, and its difficulity is $difficulity"

    fun changeDifficulity(difficulity: String) {
        this.difficulity = difficulity
    }
}

    val darkSouls = VideoGame("Dark Fantasy RPG", "Dark Soul", "Pretty Hard")
    val devinityOriginalSin = VideoGame("Turn Based Strategy Game & rPG", " Divinity original game 2", "Medium")

    println(darkSouls.getData())
    println(devinityOriginalSin.getData())

    darkSouls.changeDifficulity("Hard")
    println(darkSouls.getData())

}