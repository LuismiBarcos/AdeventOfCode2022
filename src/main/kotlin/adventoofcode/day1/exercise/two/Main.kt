package adventoofcode.day1.exercise.two

import adventoofcode.day1.dependency.injector.DependencyInjector
import adventoofcode.day1.line.validators.LineValidators
import adventoofcode.day1.resourcer.business.ResourcerImpl
import adventoofcode.day1.resourcer.contracts.Resourcer
import java.io.File
import java.io.InputStream

fun main() {
    //Inject dependencies
    DependencyInjector.addDependency(Resourcer::class, ResourcerImpl())

    val resourcer = DependencyInjector.getDependency<Resourcer>(Resourcer::class)
    val inputStream: InputStream = File(resourcer.getResourceURI("/input/input.txt")).inputStream()

    val maxCalories = intArrayOf(0, 0, 0)
    var calories = 0

    inputStream.bufferedReader().forEachLine {
        val validLine = LineValidators.validateLine(it).getOrThrow()
        if(validLine.isEmpty()) {
            checkMaxCalories(maxCalories, calories)
            calories = 0
        } else {
            calories += it.toInt()
        }
    }
    println("Sum ${maxCalories.sum()}")
}

fun checkMaxCalories(maxCalories: IntArray, calories: Int) {
    val min = maxCalories.min()
    if(calories > min) {
        maxCalories[maxCalories.indexOf(min)] = calories
    }
}