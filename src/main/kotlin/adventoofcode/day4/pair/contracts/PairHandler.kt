package adventoofcode.day4.pair.contracts

/**
 * @author Luis Miguel Barcos
 */
interface PairHandler {
    fun getPairs(string: String): List<Pair<Int, Int>>

    fun getRange(pair1: Pair<Int, Int>, pair2: Pair<Int, Int>): Pair<Int, Int>

    fun rangeIsAGivenPair(range: Pair<Int, Int>, pair1: Pair<Int, Int>, pair2: Pair<Int, Int>): Boolean

    fun existsOverlap(range: Pair<Int, Int>, pair1: Pair<Int, Int>, pair2: Pair<Int, Int>): Boolean
}