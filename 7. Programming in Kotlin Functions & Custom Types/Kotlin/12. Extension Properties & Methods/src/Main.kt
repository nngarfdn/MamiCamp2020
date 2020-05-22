import kotlin.math.PI
import kotlin.math.roundToInt
import kotlin.math.sqrt

// 2-08 Extension Properties & Methods - Starter

//---🛑❌⚠️❌🐻❌☢️❌🤡❌🚫❌🚬❌🛑---

class Circle(var radius: Double = 0.0) {
    val circumference: Double
        get() = PI * radius * 2
}

//---🛑❌⚠️❌🐻❌☢️❌🤡❌🚫❌🚬❌🛑---


// Add Circle Extension Property

val Circle.diameter : Double
    get() =  2.0 * radius




//---🛑❌⚠️❌🐻❌☢️❌🤡❌🚫❌🚬❌🛑---

class SimpleDate(var month: String) {
    fun monthsUntilJingleBells(): Int {
        return months.indexOf("December") - months.indexOf(month)
    }

    companion object {
        val months = arrayOf(
            "January", "February", "March",
            "April", "May", "June",
            "July", "August", "September",
            "October", "November", "December"
        )
    }
}
//---🛑❌⚠️❌🐻❌☢️❌🤡❌🚫❌🚬❌🛑---


// Add SimpleDate Extension Method
fun SimpleDate.monthsUntilHalloweenDecorations() : Int {
    val currentMonth = SimpleDate.months.indexOf(month)
    val hallowenStart = SimpleDate.months.indexOf("September")
    val hallowenEnd = SimpleDate.months.indexOf("September")

    return if (currentMonth in 0..hallowenStart) {
        hallowenStart - currentMonth
    } else if (currentMonth in hallowenStart..hallowenEnd){
        0
    } else {
        hallowenStart + (12 - currentMonth)
    }

}



//---🛑❌⚠️❌🐻❌☢️❌🤡❌🚫❌🚬❌🛑---
class TVMath {
    companion object {
        fun getDiagonal(width: Double, height: Double): Int {
            val result = sqrt(width * width + height * height)
            return result.roundToInt()
        }

        fun getWidthAndHeight(diagonal: Int, ratioWidth: Double, ratioHeight: Double): Pair<Double, Double> {
            val ratioDiagonal = sqrt(ratioWidth * ratioWidth + ratioHeight * ratioHeight)
            val height = diagonal * ratioHeight / ratioDiagonal
            val width = height * ratioWidth / ratioHeight

            return Pair(width, height)
        }
    }
}
//---🛑❌⚠️❌🐻❌☢️❌🤡❌🚫❌🚬❌🛑---


fun TVMath.Companion.idealViewingDistance (diagonal : Int, is4k:Boolean) : Double {
    return if (is4k) diagonal * 1.25 else diagonal * 2.0
}



fun main() {
    val distance = TVMath.idealViewingDistance(diagonal = 65, is4k = true)
    println("$distance inchis")

    val date = SimpleDate("August")
    println("${date.monthsUntilHalloweenDecorations()} month(s) until spooky decoration!")

    val unitCircle = Circle(1.0)
    println("Diameter: ${unitCircle.diameter}")

}