package adventoofcode.day2.exercise.one

import adventoofcode.day2.dependency.injector.DependencyInjector
import adventoofcode.day2.exercise.Application
import adventoofcode.day2.game.business.GameImpl
import adventoofcode.day2.game.contracts.Game
import adventoofcode.day2.resourcer.business.ResourcerImpl
import adventoofcode.day2.resourcer.contracts.Resourcer

fun main() {
    //Inject dependencies
    DependencyInjector.addDependency(Resourcer::class, ResourcerImpl())
    DependencyInjector.addDependency(Game::class, GameImpl())

    Application().executeGame1()
}