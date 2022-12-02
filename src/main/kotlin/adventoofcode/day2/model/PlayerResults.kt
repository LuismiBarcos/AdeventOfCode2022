package adventoofcode.day2.model

enum class OpponentOptions(private val letter: String, private val value: Int) {
    ROCK("A", 1),
    PAPER("B", 2),
    SCISSORS("C", 3);

    fun getLetter(): String = letter

    fun getValue(): Int = value

    companion object {
        private val map = OpponentOptions.values().associateBy { it.getLetter() }
        fun fromLetter(letter: String) = map[letter]!!
    }
}
enum class PlayerOptions(private val letter: String, private val  value: Int) {
    ROCK("X", 1),
    PAPER("Y",2),
    SCISSORS("Z", 3);

    fun getLetter(): String = letter

    fun getValue(): Int = value

    companion object {
        private val map = PlayerOptions.values().associateBy { it.getLetter() }
        fun fromLetter(letter: String) = map[letter]!!
    }
}

enum class PlayerResults(val score: Int) {
    WIN(6),
    DRAW(3),
    LOSE(0);
}

