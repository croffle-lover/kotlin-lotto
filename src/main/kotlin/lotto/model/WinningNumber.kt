package lotto.model

class WinningNumber {
    fun makeMatchNumber(): List<Int> {
        val matchNumber = (0..100).shuffled().chunked(6)[0]
        return matchNumber
    }

    fun makeBonusNumber(): Int {
        val bonusNumber = (0..100).shuffled()[0]
        return bonusNumber
    }
}