package adventoofcode.day1.line.validators

import adventoofcode.day1.validator.or
import adventoofcode.day1.validator.orElseFail
import adventoofcode.day1.validator.validate

object LineValidators {
    val validateLine =
        validate(String::isEmpty)
            .or(::isANumber)
            .orElseFail(Exception("Please, enter a proper input"))
}

private fun isANumber(string: String): Boolean = string.all { Character.isDigit(it) }