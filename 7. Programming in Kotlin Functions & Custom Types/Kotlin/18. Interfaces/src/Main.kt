
interface Vehicle {
    fun accelerate()
    fun stop()
}

class Unicycle: Vehicle {
    var peddling = false
    override fun accelerate() {
        peddling = true
        println("weeeee")
    }

    override fun stop() {
        peddling = false
        println("Nooooooo")
    }
}

enum class Direction {
    LEFT, RIGHT
}

interface  TurningVehicle  : Vehicle{
    fun turn(direction: Direction = Direction.RIGHT)
    fun description() : String
}

interface Spacey {
    val tribblesCount : Int
}

interface SpaceVehicle : Vehicle, Spacey {
    val name : String
    get() =  "SpaceVehicle"
    override fun accelerate() {
        println("Proceed to Hyperspace!")
    }

    override fun stop() {
        println("Whoaaaa, slow down!")
    }
}

class  LightFreugher : SpaceVehicle {
    override val tribblesCount: Int = 0
    var hyperdriveBusted : Boolean = false
    override fun stop() {
        hyperdriveBusted = true
        println("Hyperdrive Failure.. again")
    }
}

class Starshiip : SpaceVehicle {
    override val tribblesCount: Int
        get() = Int.MAX_VALUE

    override val name: String
        get() = "Starship!"
    override fun accelerate() {
        println("Warp factor 9, please")
    }

    override fun stop() {

    }
}

fun main() {
    val unicycle = Unicycle()
    unicycle.accelerate()
    unicycle.stop()
 
    val falcon = LightFreugher()
    falcon.accelerate()
    falcon.stop()

    val enterprise = Starshiip()
    enterprise.accelerate()
    enterprise.stop()
}