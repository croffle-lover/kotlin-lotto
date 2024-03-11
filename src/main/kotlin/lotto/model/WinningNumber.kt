package lotto.model

class WinningNumber {
    fun makeMatchNumber(): List<Int> {
        val matchRange = 1..45
        val matchNumber = matchRange.shuffled().chunked(6)[0]
        return matchNumber
    }

    fun makeBonusNumber(): Int {
        val bonusRange = 1..45
        val bonusNumber = bonusRange.shuffled()[0]
        return bonusNumber
    }
}