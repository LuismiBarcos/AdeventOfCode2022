package adventoofcode.day5.matrix.contracts

interface Matrix {
    fun update(column: Int, char: Char)

    fun move(totalMoves: Int, sourceColumn: Int, endColumn: Int)

    fun getTopOfEachStack(): String
}