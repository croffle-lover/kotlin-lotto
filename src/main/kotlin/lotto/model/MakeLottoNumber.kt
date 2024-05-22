package lotto.model

private val NUMBER_RANGE = 1..45

fun interface NumberGenerator {
    fun generateRandomNumber(): Int
}

object MakeLottoNumber : NumberGenerator {
    override fun generateRandomNumber(): Int {
        return NUMBER_RANGE.shuffled().first()
    }
}