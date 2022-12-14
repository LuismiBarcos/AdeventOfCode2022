package adventoofcode.day2.game.business

import adventoofcode.day2.game.contracts.Game
import adventoofcode.day2.model.OpponentOptions
import adventoofcode.day2.model.PlayerInstructions
import adventoofcode.day2.model.PlayerOptions
import adventoofcode.day2.model.PlayerResults

class GameImpl: Game {
    override fun getResult(opponentOption: OpponentOptions, playerOption: PlayerOptions): Int {
        return when(opponentOption){
            OpponentOptions.ROCK ->
                when(playerOption){
                    PlayerOptions.ROCK -> calculateResult(playerOption.getValue(), PlayerResults.DRAW.score)
                    PlayerOptions.PAPER -> calculateResult(playerOption.getValue(), PlayerResults.WIN.score)
                    PlayerOptions.SCISSORS -> calculateResult(playerOption.getValue(), PlayerResults.LOSE.score)
                }
            OpponentOptions.PAPER ->
                when(playerOption){
                    PlayerOptions.ROCK -> calculateResult(playerOption.getValue(), PlayerResults.LOSE.score)
                    PlayerOptions.PAPER -> calculateResult(playerOption.getValue(), PlayerResults.DRAW.score)
                    PlayerOptions.SCISSORS -> calculateResult(playerOption.getValue(), PlayerResults.WIN.score)
                }
            OpponentOptions.SCISSORS ->
                when(playerOption){
                    PlayerOptions.ROCK -> calculateResult(playerOption.getValue(), PlayerResults.WIN.score)
                    PlayerOptions.PAPER -> calculateResult(playerOption.getValue(), PlayerResults.LOSE.score)
                    PlayerOptions.SCISSORS -> calculateResult(playerOption.getValue(), PlayerResults.DRAW.score)
                }
        }
    }

    override fun getResultOfGame2(opponentOption: OpponentOptions, playerInstruction: PlayerInstructions): Int {
        return when(opponentOption){
            OpponentOptions.ROCK ->
                when(playerInstruction){
                    PlayerInstructions.WIN -> calculateResult(PlayerOptions.PAPER.getValue(), PlayerResults.WIN.score)
                    PlayerInstructions.DRAW -> calculateResult(PlayerOptions.ROCK.getValue(), PlayerResults.DRAW.score)
                    PlayerInstructions.LOSE -> calculateResult(PlayerOptions.SCISSORS.getValue(), PlayerResults.LOSE.score)
                }
            OpponentOptions.PAPER ->
                when(playerInstruction){
                    PlayerInstructions.WIN -> calculateResult(PlayerOptions.SCISSORS.getValue(), PlayerResults.WIN.score)
                    PlayerInstructions.DRAW -> calculateResult(PlayerOptions.PAPER.getValue(), PlayerResults.DRAW.score)
                    PlayerInstructions.LOSE -> calculateResult(PlayerOptions.ROCK.getValue(), PlayerResults.LOSE.score)
                }
            OpponentOptions.SCISSORS ->
                when(playerInstruction){
                    PlayerInstructions.WIN -> calculateResult(PlayerOptions.ROCK.getValue(), PlayerResults.WIN.score)
                    PlayerInstructions.DRAW -> calculateResult(PlayerOptions.SCISSORS.getValue(), PlayerResults.DRAW.score)
                    PlayerInstructions.LOSE -> calculateResult(PlayerOptions.PAPER.getValue(), PlayerResults.LOSE.score)
                }
        }
    }

    private fun calculateResult(value: Int, score: Int): Int = value + score

}