import kotlin.properties.Delegates

class IceCream {
    var name : String = "Vanilla"
    val ingdients : ArrayList<String> by lazy {
        arrayListOf<String>()
    }
}

class SpaceCar(
    val make : String,
    val color :String,
    val battery : Spacebattery = Spacebattery()
)

class Spacebattery {
    var lowCharge = true
    var level : Double by Delegates.observable(0.0) {
        _,_, new ->
        lowCharge = new < 0.1
    }
}

fun main() {
    var spaceIceCream = IceCream()

    spaceIceCream.name = "Commets & Cream"

    spaceIceCream.ingdients.add("Crushed Halley's Comet Pieces")
    spaceIceCream.ingdients.add("Milky Way Cream")

    val spacTrk = SpaceCar("Tesla", "Space Metal")

    spacTrk.battery.level = 1.0
    println(spacTrk.battery.lowCharge)

    spacTrk.battery.level  = 0.05
    println(spacTrk.battery.lowCharge)

}