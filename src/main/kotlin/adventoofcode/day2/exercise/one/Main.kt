package adventoofcode.day2.exercise.one

import adventoofcode.day2.dependency.injector.DependencyInjector
import adventoofcode.day2.game.business.GameImpl
import adventoofcode.day2.game.contracts.Game
import adventoofcode.day2.model.OpponentOptions
import adventoofcode.day2.model.PlayerOptions
import adventoofcode.day2.resourcer.business.ResourcerImpl
import adventoofcode.day2.resourcer.contracts.Resourcer
import java.io.File
import java.io.InputStream

fun main() {
    //Inject dependencies
    DependencyInjector.addDependency(Resourcer::class, ResourcerImpl())
    DependencyInjector.addDependency(Game::class, GameImpl())

    //Dependencies
    val resourcer = DependencyInjector.getDependency<Resourcer>(Resourcer::class)
    val game = DependencyInjector.getDependency<Game>(Game::class)

    val inputStream: InputStream = File(resourcer.getResourceURI("/day2/input.txt")).inputStream()

    var score = 0
    inputStream.bufferedReader().forEachLine {
        println("Line $it")
        // Destructuring declaration
        val (opponent, player) = it.split("\\s".toRegex())

        val opponentOption = OpponentOptions.fromLetter(opponent)
        val playerOption = PlayerOptions.fromLetter(player)

        score += game.getResult(opponentOption, playerOption)
    }

    println("Final score $score")
}