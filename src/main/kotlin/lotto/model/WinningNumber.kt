package lotto.model

class WinningNumber {
    fun makeMatchNumber(numberGenerator: NumberGenerator): LottoTicket {
        val matchNumber = LottoTicket(numberGenerator)
        return matchNumber
    }

    fun makeBonusNumber(numberGenerator: NumberGenerator): Int =
        numberGenerator.generateRandomNumber()
}