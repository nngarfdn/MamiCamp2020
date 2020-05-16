fun main() {

    val matrixRow = 5
    val matrixColomn = 8

    val matrix = Array(matrixRow) {Array(matrixColomn){'.'} }

    matrix[3][6]

    loop@ for (row in 0 until matrixRow) {
        println("Searcing in row $row")

        for (column in 0 until matrixColomn) {
            if (matrix[row][column] == 'x'){
                println("Found x at $row:$column")
                break@loop
            }
        }
    }
}