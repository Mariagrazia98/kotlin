data class MinesweeperBoard(val inputBoard: List<String>) {
    // TODO: Implement proper constructor

    fun withNumbers(): List<String> {
        val matrix = inputBoard.map({ it.toList() })
        val result : MutableList<String> = mutableListOf()
        var line:String = "";
        for ((indexX, row) in matrix.withIndex()) {
            line="";
            for ((indexY, item) in row.withIndex()) {
                if(item == '*'){
                    line+="*"
                }
                else {
                    var tmp = controllaPosizione(matrix, indexX, indexY);
                    if (tmp > 0) {
                        line+=tmp.toString()

                    } else {
                        line+=" "
                    }
                }
            }
            result.add(line)
        }
        return result
        /* Alternative solution 1 */
        /* return matrix.mapIndexed({indexX, row->
            row.mapIndexed{indexY, cell->
                if (cell == ' ')  controllaPosizione(matrix, indexX,indexY) else cell //TODO: manage return
            }.joinToString("")
        })*/

    }


    fun controllaPosizione(matrix: List<List<Char>>, x: Int, y: Int): Int {
        val position = listOf(
            (x - 1 to y - 1),
            (x - 1 to y),
            (x - 1 to y + 1),
            (x to y - 1),
            (x to y + 1),
            (x + 1 to y - 1),
            (x + 1 to y),
            (x + 1 to y + 1)
        )
        val validPositions =
            position.filter({ it.first >= 0 && it.second >= 0 && it.first < matrix.size && it.second < matrix[0].size })

        return validPositions.fold(0, { total, item ->
            if (matrix[item.first][item.second] == '*')
                total + 1
            else
                total
        })
    }
}