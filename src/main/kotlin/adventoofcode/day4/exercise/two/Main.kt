package adventoofcode.day4.exercise.two

import adventoofcode.day4.dependency.injector.DependencyInjector
import adventoofcode.day4.resourcer.business.ResourcerImpl
import adventoofcode.day4.resourcer.contracts.Resourcer
import java.io.File
import kotlin.math.max
import kotlin.math.min

/**
 * @author Luis Miguel Barcos
 */

fun main() {
    // Inject dependencies
    DependencyInjector.addDependency(Resourcer::class, ResourcerImpl())

    val resourcer = DependencyInjector.getDependency<Resourcer>(Resourcer::class)

    val resourceURI = resourcer.getResourceURI("/day4/input.txt")

    var count = 0
    File(resourceURI).bufferedReader().forEachLine {
        val (leftPair, rightPair) = it
            .split(",")
            .map { string -> string.split("-") }
            .map { strings -> Pair(strings.first().toInt(), strings.last().toInt()) }

        val range = Pair(min(leftPair.first, rightPair.first), max(leftPair.second, rightPair.second))

        if(rangeIsAGivenPair(range, leftPair, rightPair) || existsOverlap(range, leftPair, rightPair)) {
            count++
        }
    }
    println("Final counter: $count")
}

private fun rangeIsAGivenPair(range: Pair<Int, Int>, pair1: Pair<Int, Int>, pair2: Pair<Int, Int>): Boolean =
    range == pair1 || range == pair2

private fun existsOverlap(range: Pair<Int, Int>, pair1: Pair<Int, Int>, pair2: Pair<Int, Int>): Boolean {
    val minCompanion = if(pair1.first == range.first) pair1.second else pair2.second
    val maxCompanion = if(pair1.second == range.second) pair1.first else pair2.first
    return minCompanion >= maxCompanion
}