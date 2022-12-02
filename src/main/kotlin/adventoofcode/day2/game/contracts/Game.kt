package adventoofcode.day2.game.contracts

import adventoofcode.day2.model.OpponentOptions
import adventoofcode.day2.model.PlayerInstructions
import adventoofcode.day2.model.PlayerOptions

interface Game {
    fun getResult(opponentOption: OpponentOptions, playerOption: PlayerOptions): Int

    fun getResultOfGame2(opponentOption: OpponentOptions, playerInstruction: PlayerInstructions): Int
}