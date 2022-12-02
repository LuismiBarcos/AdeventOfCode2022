package adventoofcode.day1.exercise.one

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
    val inputStream: InputStream = File(resourcer.getResourceURI("/day1/input.txt")).inputStream()

    var calories = 0
    var maxCalories = 0

    inputStream.bufferedReader().forEachLine {
        val validLine = LineValidators.validateLine(it).getOrThrow()
        if(validLine.isEmpty()) {
            if(calories >= maxCalories) {
                maxCalories = calories
            }
            calories = 0
        } else {
            calories += validLine.toInt()
        }
    }

    print("MaxCalories $maxCalories")
}