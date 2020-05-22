fun main() {
    var counter = 0
    val incrementCounter = {
        counter += 1
    }

    incrementCounter()
    incrementCounter()
    incrementCounter()
    incrementCounter()
    incrementCounter()
    println(counter)

    fun countingLamnda() : () -> Int {
        var counter =0
        val incrementCounter: () -> Int = {
            counter += 1
            counter
        }
        return incrementCounter
    }

    val counter1  = countingLamnda()
    val counter2 = countingLamnda()

    println(counter1())
    println(counter1())

    println(counter2())
    println(counter2())
    println(counter2())
    println(counter2())

}