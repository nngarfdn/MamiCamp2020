
interface Shape {
    val area : Double
}

val Double.squared
get() = this * this

class Square(val side : Double) : Shape {
    override val area: Double
        get() = side.squared
}

class Triangle (val base: Double, val height : Double) : Shape {
    override val area: Double
        get() = 0.5 * base * height
}

class Circle(val radius : Double) : Shape {
    override val area: Double
        get() = kotlin.math.PI * radius.squared
}

fun main() {
    val square = Square(4.0)
    val triangle = Triangle(3.0, 5.0)
    val circle = Circle(2.0)

    val shapes = arrayOf(square, triangle, circle)
    val areas = shapes.map {it.area}

    println(areas)

}