

fun main() {
    //methodOne()
    fun operateOnNumbers(a: Int, b: Int, operation : (Int, Int) -> Int) : Int {
        return operation(a,b)
    }

    val addLambda = {a: Int, b : Int ->
        a+b
    }

    operateOnNumbers(4,2, operation = { a, b ->
    a + b
    })

    fun addFunction (a : Int,b:Int)  = a+b
    operateOnNumbers(4,2, operation = Int::plus)

}

private fun methodOne() {
    fun printRange() {
        for (number in 1..5) print("$number \t")
        println()
    }

    printRange()

    fun printRange(range: IntRange) {
        for (number in range) print("$number \t")
        println()
    }

    printRange(6..10)

    fun createRange(start: Int, end: Int, isHalfOpen: Boolean): IntRange {
        return if (isHalfOpen) {
            start until end
        } else {
            start..end
        }
    }

    val halfOpenRange = createRange(11, 15, true)
    printRange(halfOpenRange)

    val namedArgument = createRange(isHalfOpen = true, start = 100, end = 115)
    printRange(namedArgument)

    fun createRange(start: Char, end: Char, isHalfOpen: Boolean = false): CharRange =
        if (isHalfOpen) start until end else start..end

    fun printRange(range: CharRange) {
        for (char in range) print("$char \t")
        println()
    }

    val closedRabge = createRange('A', 'G')
    print(closedRabge)
}