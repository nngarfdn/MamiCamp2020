fun main() {
    var i = 1

    while (i<16){
        println("$i")
        i += 1
    }

    val name = arrayOf(
        "Filip",
        "Mari",
        "Joe",
        "Ray",
        "Andrea",
        "Manda"
    )
    i = name.lastIndex

    do {
        if (i > name.lastIndex || i < 0) return
        println(name[i])
        i -=1
    } while (i > 0 && i < name.size)

}