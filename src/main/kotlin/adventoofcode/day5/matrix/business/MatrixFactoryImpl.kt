package adventoofcode.day5.matrix.business

import adventoofcode.day5.matrix.contracts.Matrix
import adventoofcode.day5.matrix.contracts.MatrixFactory

class MatrixFactoryImpl: MatrixFactory {
    override fun getMatrix(): Matrix = MatrixImpl()
}