package lotto.model

private val NUMBER_AMOUNT = 6
private val NUMBER_RANGE = 1..45

class WinningNumber {
    fun makeMatchNumber(): List<Int> {
        val matchNumber = NUMBER_RANGE.shuffled().chunked(NUMBER_AMOUNT)[0]
        return matchNumber
    }

    fun makeBonusNumber(): Int {
        val bonusNumber = NUMBER_RANGE.shuffled()[0]
        return bonusNumber
    }
}