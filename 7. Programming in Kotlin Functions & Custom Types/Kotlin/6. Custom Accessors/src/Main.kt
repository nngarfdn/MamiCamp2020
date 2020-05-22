import kotlin.math.roundToInt
import kotlin.math.sqrt

class Person(val firstName: String, val lastName : String){
    val fullName = "$firstName $lastName"
}

class TV (var width : Double, var heigth : Double) {
    var diagonal : Int
    get() {
        val result = sqrt(width * width + heigth * heigth)
        return result.roundToInt()
    }
    set(value) {
        val ratioWidth =16.0
        val ratioHeight = 9.0
        val ratioDiagonal = sqrt(ratioWidth *ratioWidth + ratioHeight * ratioHeight )
        heigth = value.toDouble() * ratioHeight / ratioDiagonal
        width = heigth * ratioWidth / ratioHeight
    }
}

fun main() {
    val grace = Person("Grace", "Hopper")
    println(grace.fullName)

    val tv = TV(width = 95.87, heigth = 53.93)
    println(tv.diagonal)

    tv.width = tv.heigth
    println(tv.diagonal)

    tv.diagonal = 65
    println("${tv.diagonal}")
}