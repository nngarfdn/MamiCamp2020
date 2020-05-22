import java.lang.Math.sqrt
import kotlin.math.roundToInt
import kotlin.properties.Delegates

class Circle (var radius : Double = 0.0) {
    val pi: Double by lazy {((4.0 * kotlin.math.atan(1.0/5.0)) - kotlin.math.atan(1.0/239.0)) * 4.0}
    val circumference: Double
    get() = pi * radius * 2
}

class Level(val id: Int,
            val boss: String) {
    companion object {
        var highestLevel = 0
    }
    var unlocked : Boolean by Delegates.observable(false) {
        _, old, new ->
        if (new && id> highestLevel){
            highestLevel = id
        }
    }
}

class Lightbulb {
    companion object{
        const val maxCurrent = 40
    }
    var current by Delegates.observable(0) {
        _,_ , new ->
        if (new > maxCurrent) {
            println("Current too high, failling back to previous setting ")
            false
        } else {
            true
        }
    }
}

class Lamp {
    lateinit var bulb : Lightbulb
}

fun main() {
    val circle = Circle(5.0)
    println(circle.circumference)

    val light = Lightbulb()
    light.current = 9000
    println(light.current)
    light.current = 40
    println(light.current)

    val fancyLamp = Lamp()
    fancyLamp.bulb = light
    println(fancyLamp.bulb.current)

    val level1 = Level(id = 1, boss = "Outside Cat")
    val level2 = Level(id = 2, boss = "Laser Pointer")
    val level3 = Level(id = 3, boss = "Mysterious Attic Sound")
    val level4 = Level(id = 4, boss = "Vacuum Cleaner")

    level1.unlocked = true
    println("Highest Level is ${Level.highestLevel}")

    level4.unlocked = true
    println("Highest Level is ${Level.highestLevel}")


}