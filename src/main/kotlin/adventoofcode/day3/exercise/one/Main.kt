package adventoofcode.day3.exercise.one

import adventoofcode.day3.calculator.business.LetterCalculatorImpl
import adventoofcode.day3.calculator.contracts.LetterCalculator
import adventoofcode.day3.dependency.injector.DependencyInjector
import adventoofcode.day3.model.Alphabet
import adventoofcode.day3.resourcer.business.ResourcerImpl
import adventoofcode.day3.resourcer.contracts.Resourcer
import java.io.File

/**
 * @author Luis Miguel Barcos
 */
fun main() {
    // Inject dependencies
    DependencyInjector.addDependency(Resourcer::class, ResourcerImpl())
    DependencyInjector.addDependency(LetterCalculator::class, LetterCalculatorImpl())

    val letterCalculator = DependencyInjector.getDependency<LetterCalculator>(LetterCalculator::class)
    val resourcer = DependencyInjector.getDependency<Resourcer>(Resourcer::class)

    val resourceURI = resourcer.getResourceURI("/day3/input.txt")

    var result = 0
    File(resourceURI).bufferedReader().forEachLine {
        val middle = it.length / 2
        val (firstPart, secondPart) = arrayListOf(it.subSequence(0, middle), it.subSequence(middle, it.length))

        val repeatedChar = secondPart.find { char -> firstPart.contains(char) } // find first matching

        result += letterCalculator.calculateLetterValue(Alphabet.fromLetter(repeatedChar!!), repeatedChar)
    }
    println("Final result $result")
}