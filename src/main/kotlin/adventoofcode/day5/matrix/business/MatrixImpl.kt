package adventoofcode.day5.matrix.business

import adventoofcode.day5.matrix.contracts.Matrix

class MatrixImpl: Matrix {
    private val matrix = mutableMapOf<Int, ArrayDeque<Char>>()

    override fun update(column: Int, char: Char) {
        matrix[column + 1] = matrix[column + 1].run {
            if (this.isNullOrEmpty()) ArrayDeque(listOf()) else this
        }
        matrix[column + 1]?.addFirst(char)
    }

    override fun move(totalMoves: Int, sourceColumn: Int, endColumn: Int) {
        for (i in 0 until totalMoves) {
            val char = matrix[sourceColumn]?.removeLast() ?: throw IllegalAccessError()
            matrix[endColumn]?.addLast(char)
        }
    }

    override fun moveKeepingOrder(totalMoves: Int, sourceColumn: Int, endColumn: Int) {
        val charsToMove = mutableListOf<Char>()
        for (i in 0 until totalMoves) {
            charsToMove.add(matrix[sourceColumn]?.removeLast() ?: throw IllegalAccessError())
        }
        charsToMove.reversed().forEach {
            matrix[endColumn]?.addLast(it)
        }
    }

    override fun getTopOfEachStack(): String = matrix.keys
        .sorted()
        .map {
            matrix[it]?.last()
        }.joinToString("")
}