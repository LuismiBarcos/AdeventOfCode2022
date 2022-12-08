package adventoofcode.day5.exercise.two

import adventoofcode.day5.dependency.injector.DependencyInjector
import adventoofcode.day5.matrix.business.MatrixFactoryImpl
import adventoofcode.day5.matrix.contracts.MatrixFactory
import adventoofcode.day5.resourcer.business.ResourcerImpl
import adventoofcode.day5.resourcer.contracts.Resourcer
import java.io.File
import java.lang.IllegalArgumentException

/**
 * @author Luis Miguel Barcos
 */

fun main() {
    // Inject dependencies
    DependencyInjector.addDependency(Resourcer::class, ResourcerImpl())
    DependencyInjector.addDependency(MatrixFactory::class, MatrixFactoryImpl())

    val resourcer = DependencyInjector.getDependency<Resourcer>(Resourcer::class)
    val matrixFactory = DependencyInjector.getDependency<MatrixFactory>(MatrixFactory::class)

    val resourceURI = resourcer.getResourceURI("/day5/input.txt")

    val matrix = matrixFactory.getMatrix()
    File(resourceURI).bufferedReader().forEachLine{ line ->
        if(!line.startsWith("move")) {
            line
                .toList()
                .chunked(4)
                .mapIndexed { index, chars ->
                    chars.firstOrNull { char ->
                        char.isLetter()
                    }?.let {
                        matrix.update(index, it)
                    }
                }
        } else if(line.startsWith("move")) {
            val (movesCount, sourceColumn, endColumn) =
                Regex("move (\\d+) from (\\d+) to (\\d+)")
                    .find(line)?.groupValues
                    ?.filterIndexed { index, _ -> index != 0 } //Group value 0 is the entire match
                    ?.map { it.toInt() }?: throw IllegalArgumentException()

            matrix.moveKeepingOrder(movesCount, sourceColumn, endColumn)
        }
    }
    println(matrix.getTopOfEachStack())
}