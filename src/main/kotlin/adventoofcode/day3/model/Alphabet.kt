package adventoofcode.day3.model

enum class Alphabet {
    A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z;

    companion object {
        private val map = Alphabet.values().associateBy { it.name }
        fun fromLetter(letter: Char) = map[letter.uppercase()]!!
    }

    fun getNaturalOrdinal(): Int = this.ordinal + 1
}