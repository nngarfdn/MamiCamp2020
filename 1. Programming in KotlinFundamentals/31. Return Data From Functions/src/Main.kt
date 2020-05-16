fun main() {
    fun createRange(star:Int, end: Int, isHalfOpen:Boolean = false) =
         if (isHalfOpen) {
            star until end
        } else {
            star..end
        }

    fun createRange(star:Char, end: Char, isHalfOpen:Boolean = false) =
        if (isHalfOpen) {
            star until end
        } else {
            star..end
        }


    fun printRange(range : IntRange){
        for (number in range) print("$number ")
        println()
    }
    fun printRange(range : CharRange){
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

    val charRange = createRange('A','Z')
    printRange(charRange)

    fun parseCoordinates(input:String): Pair<Double, Double>  {
        val latituLongude = input.split(",")

        val latitude: Double = latituLongude[0].toDouble()
        val longtitude = latituLongude[1].toDouble()

        return latitude to longtitude


    }
    val (latitude, longtitude) = parseCoordinates("23.45,23.54")
    println("$latitude, $longtitude")

}