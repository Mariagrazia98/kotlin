class Matrix(private val matrixAsString: String) {
    //Alternative solution
    /*private val matrix = matrixAsString.lines().map { it.trim().split("\\s+".toRegex()).map(String::toInt) }
    //lines splits this char sequence to a list of lines delimited by any of the following character sequences: CRLF, LF or CR.
    fun column(colNr: Int): List<Int> = matrix.map { it[colNr - 1] }
    fun row(rowNr: Int): List<Int> = matrix[rowNr - 1]*/


   fun row(rowNr: Int): List<Int> {
        return matrixAsString.split("\n")[rowNr-1].split(" ").map({it.toInt()})
    }
    fun column(colNr: Int): List<Int> {
        return matrixAsString.split("\n").map({it.split(" ").filter({it!=""}).elementAt(colNr-1)}).map({it.toInt()})

    }


}
