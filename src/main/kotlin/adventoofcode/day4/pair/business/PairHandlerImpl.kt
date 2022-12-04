package adventoofcode.day4.pair.business

import adventoofcode.day4.pair.contracts.PairHandler
import kotlin.math.max
import kotlin.math.min

/**
 * @author Luis Miguel Barcos
 */
class PairHandlerImpl: PairHandler {
    override fun getPairs(string: String): List<Pair<Int, Int>> =
        string
        .split(",")
        .map { s -> s.split("-") }
        .map { pairInStrings -> Pair(pairInStrings.first().toInt(), pairInStrings.last().toInt()) }

    override fun getRange(pair1: Pair<Int, Int>, pair2: Pair<Int, Int>): Pair<Int, Int> =
        Pair(min(pair1.first, pair2.first), max(pair1.second, pair2.second))

    override fun rangeIsAGivenPair(range: Pair<Int, Int>, pair1: Pair<Int, Int>, pair2: Pair<Int, Int>): Boolean =
        range == pair1 || range == pair2

    override fun existsOverlap(range: Pair<Int, Int>, pair1: Pair<Int, Int>, pair2: Pair<Int, Int>): Boolean {
        val minCompanion = if(pair1.first == range.first) pair1.second else pair2.second
        val maxCompanion = if(pair1.second == range.second) pair1.first else pair2.first
        return minCompanion >= maxCompanion
    }
}