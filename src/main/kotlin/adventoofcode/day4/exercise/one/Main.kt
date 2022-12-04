package adventoofcode.day4.exercise.one

import adventoofcode.day4.dependency.injector.DependencyInjector
import adventoofcode.day4.pair.business.PairHandlerImpl
import adventoofcode.day4.pair.contracts.PairHandler
import adventoofcode.day4.resourcer.business.ResourcerImpl
import adventoofcode.day4.resourcer.contracts.Resourcer
import java.io.File

/**
 * @author Luis Miguel Barcos
 */

fun main() {
    // Inject dependencies
    DependencyInjector.addDependency(Resourcer::class, ResourcerImpl())
    DependencyInjector.addDependency(PairHandler::class, PairHandlerImpl())

    val resourcer = DependencyInjector.getDependency<Resourcer>(Resourcer::class)
    val pairHandler = DependencyInjector.getDependency<PairHandler>(PairHandler::class)

    val resourceURI = resourcer.getResourceURI("/day4/input.txt")

    var count = 0
    File(resourceURI).bufferedReader().forEachLine{
        val (leftPair, rightPair) = pairHandler.getPairs(it)
        val range = pairHandler.getRange(leftPair, rightPair)

        if (pairHandler.rangeIsAGivenPair(range, leftPair, rightPair)) {
            count++
        }
    }
    println("Final counter: $count")
}
