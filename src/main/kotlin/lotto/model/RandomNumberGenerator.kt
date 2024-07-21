package lotto.model

class RandomNumberGenerator {
    fun interface NumberGenerator {
        fun generateRandomNumber(): Int
    }
}