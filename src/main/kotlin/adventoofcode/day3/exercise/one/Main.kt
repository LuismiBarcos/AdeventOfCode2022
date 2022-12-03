package adventoofcode.day3.exercise.one

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

    val resourcer = DependencyInjector.getDependency<Resourcer>(Resourcer::class)
    val resourceURI = resourcer.getResourceURI("/day3/input.txt")

    var result = 0

    File(resourceURI).bufferedReader().forEachLine {
        val middle = it.length / 2
        val (firstPart, secondPart) = arrayListOf(it.subSequence(0, middle), it.subSequence(middle, it.length))

        val charChecked = hashSetOf<Char>()
        secondPart.forEach { char ->
            if(charChecked.notContains(char) && firstPart.contains(char)) {
                result += calculateLetterValue(Alphabet.fromLetter(char), char)
            }
            charChecked.add(char)
        }
    }
    println("Final result $result")
}

private fun HashSet<Char>.notContains(any: Char): Boolean = !this.contains(any)

private fun calculateLetterValue(letter: Alphabet, originalChar: Char): Int =
    letter.getNaturalOrdinal() + if (originalChar.isUpperCase()) Alphabet.values().size else 0