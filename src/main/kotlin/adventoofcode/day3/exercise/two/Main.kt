package adventoofcode.day3.exercise.two

import adventoofcode.day3.dependency.injector.DependencyInjector
import adventoofcode.day3.model.Alphabet
import adventoofcode.day3.resourcer.business.ResourcerImpl
import adventoofcode.day3.resourcer.contracts.Resourcer
import java.io.File

const val NUMBER_OF_LINES = 3

fun main() {
    // Inject dependencies
    DependencyInjector.addDependency(Resourcer::class, ResourcerImpl())

    val resourcer = DependencyInjector.getDependency<Resourcer>(Resourcer::class)
    val resourceURI = resourcer.getResourceURI("/day3/input.txt")


    val groupOfLines = mutableListOf<String>()
    var result = 0
    File(resourceURI).bufferedReader().forEachLine {
        groupOfLines.add(it)
        if(groupOfLines.size >= NUMBER_OF_LINES) {
            val firstLine = groupOfLines[0]
            val secondLine = groupOfLines[1]
            val thirdLine = groupOfLines[2]

            val repeatedLetter = firstLine.find { c ->
                secondLine.contains(c) && thirdLine.contains(c)
            }

            result += calculateLetterValue(Alphabet.fromLetter(repeatedLetter!!), repeatedLetter)
        }
    }
    println("Final result $result")
}

private fun calculateLetterValue(letter: Alphabet, originalChar: Char): Int =
    letter.getNaturalOrdinal() + if (originalChar.isUpperCase()) Alphabet.values().size else 0