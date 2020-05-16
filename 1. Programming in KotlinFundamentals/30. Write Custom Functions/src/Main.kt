fun main() {

    fun createRange(star:Int, end: Int, isHalfOpen:Boolean = false) : IntRange {
        return if (isHalfOpen) {
            return star until end
        } else {
            star..end
        }
    }

    fun printRange(range : IntRange){
        for (number in range) print("$number ")
        println()
    }

    val closerange = createRange(1,10)
    for (number in closerange) print("$number ")
    println()

    val halfopen = createRange(1,10,true)
    print(halfopen)

    val usingNamedArgument = createRange(star = 1, isHalfOpen = true, end = 10)
    println(usingNamedArgument)

    printRange(createRange(3,5,isHalfOpen = true))

}