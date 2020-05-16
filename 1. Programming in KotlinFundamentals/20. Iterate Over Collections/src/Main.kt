fun main() {
    val dayOfWeek = listOf(
        "Monday",
        "Tuesday",
        "Wednesday",
        "Thursday",
        "Friday",
        "Saturday",
        "Sunday"
    )

    for (day in dayOfWeek){
        if (day.equals("Monday")){
            continue
        }
        println("Working!")

        if (day.equals("Saturday")) {
            println("Get ready for the weekend")
            break
        }
    }

    val matrix = MutableList(5){ MutableList(5){""} }

    for (row in 0..matrix.lastIndex){
        for (colomn in 0..matrix.lastIndex){
            matrix[row][colomn]= "$row:$colomn"
        }
    }

    println(matrix)
    println("----")

    for (row in matrix) {
        println(row)
    }

    val matrixLagi = matrix[2][4]
    println(matrixLagi)

    row@ for (row in 0..5) {
        column@ for (column in 0..5) {
            if (column==2 && row == 2) {
                break@row
            }
            print("x\t")
        }
        println()
    }
}

