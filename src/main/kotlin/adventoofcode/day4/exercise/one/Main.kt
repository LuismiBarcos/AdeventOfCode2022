package adventoofcode.day4.exercise.one

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
    File(resourceURI).bufferedReader().forEachLine{
        val (leftPair, rightPair) = it
            .split(",")
            .map { string -> string.split("-") }
            .map { strings -> Pair(strings.first().toInt(), strings.last().toInt()) }

        val range = Pair(min(leftPair.first, rightPair.first), max(leftPair.second, rightPair.second))

        if(range == leftPair || range == rightPair) {
            count++
        }
    }
    println("Final counter: $count")
}
