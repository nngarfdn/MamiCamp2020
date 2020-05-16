fun main() {

    val range = 10..20
    for (number in range) {
        print("$number ")
    }
    println()
    for (number in range step 3) {
        print("$number ")
    }
    println()
    val reversed = 30 downTo 15

    for (number in reversed step 2) {
        print("$number ")
    }

}