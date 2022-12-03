package adventoofcode.day3.exercise.two

import adventoofcode.day3.calculator.business.LetterCalculatorImpl
import adventoofcode.day3.calculator.contracts.LetterCalculator
import adventoofcode.day3.dependency.injector.DependencyInjector
import adventoofcode.day3.model.Alphabet
import adventoofcode.day3.resourcer.business.ResourcerImpl
import adventoofcode.day3.resourcer.contracts.Resourcer
import java.io.File

const val NUMBER_OF_LINES = 3

fun main() {
    // Inject dependencies
    DependencyInjector.addDependency(Resourcer::class, ResourcerImpl())
    DependencyInjector.addDependency(LetterCalculator::class, LetterCalculatorImpl())

    val resourcer = DependencyInjector.getDependency<Resourcer>(Resourcer::class)
    val letterCalculator = DependencyInjector.getDependency<LetterCalculator>(LetterCalculator::class)

    val resourceURI = resourcer.getResourceURI("/day3/input.txt")

    val groupOfLines = mutableListOf<String>()
    var result = 0
    File(resourceURI).bufferedReader().forEachLine {
        groupOfLines.add(it)
        if(groupOfLines.size >= NUMBER_OF_LINES) {
            val repeatedLetter =
                groupOfLines
                    .first()
                    .find { char -> //find first matching
                        groupOfLines
                            .drop(1)
                            .map { line -> line.contains(char) }
                            .all { b -> b } //all lines should contain the char
                    }

            result += letterCalculator.calculateLetterValue(Alphabet.fromLetter(repeatedLetter!!), repeatedLetter)
            groupOfLines.removeAll(groupOfLines)
        }
    }
    println("Final result $result")
}