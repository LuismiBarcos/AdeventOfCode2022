package adventoofcode.day3.calculator.business

import adventoofcode.day3.calculator.contracts.LetterCalculator
import adventoofcode.day3.model.Alphabet

class LetterCalculatorImpl: LetterCalculator {
    override fun calculateLetterValue(letter: Alphabet, originalChar: Char): Int =
        letter.getNaturalOrdinal() + if (originalChar.isUpperCase()) Alphabet.values().size else 0
}