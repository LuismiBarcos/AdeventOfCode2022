package adventoofcode.day3.calculator.contracts

import adventoofcode.day3.model.Alphabet

interface LetterCalculator {
    fun calculateLetterValue(letter: Alphabet, originalChar: Char): Int
}