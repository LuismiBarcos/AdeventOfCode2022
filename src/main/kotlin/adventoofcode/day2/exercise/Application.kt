package adventoofcode.day2.exercise

import adventoofcode.day2.dependency.injector.DependencyInjector
import adventoofcode.day2.game.contracts.Game
import adventoofcode.day2.model.OpponentOptions
import adventoofcode.day2.model.PlayerInstructions
import adventoofcode.day2.model.PlayerOptions
import adventoofcode.day2.resourcer.contracts.Resourcer
import java.io.File

class Application(
    private val resourcer: Resourcer = DependencyInjector.getDependency(Resourcer::class),
    private val game: Game = DependencyInjector.getDependency(Game::class),
    private var score: Int = 0) {

    fun executeGame1() {
        getInputStream().bufferedReader().forEachLine {
            // Destructuring declaration
            val (opponent, player) = it.split("\\s".toRegex())

            val opponentOption = OpponentOptions.fromLetter(opponent)
            val playerOption = PlayerOptions.fromLetter(player)

            score += game.getResult(opponentOption, playerOption)
        }

        println("Final score $score")
    }

    fun executeGame2() {
        getInputStream().bufferedReader().forEachLine {
            // Destructuring declaration
            val (opponent, player) = it.split("\\s".toRegex())

            val opponentOption = OpponentOptions.fromLetter(opponent)
            val playerInstruction = PlayerInstructions.fromLetter(player)

            score += game.getResultOfGame2(opponentOption, playerInstruction)
        }

        println("Final score $score")
    }

    private fun getInputStream() = File(resourcer.getResourceURI("/day2/input.txt")).inputStream()
}