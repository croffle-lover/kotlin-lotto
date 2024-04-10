package lotto.model

class WinningNumber {
    fun makeMatchNumber(numberGenerator: NumberGenerator): LottoTicket {
        val matchNumber = LottoTicket().makeLottoTicket(numberGenerator)
        return matchNumber
    }

    fun makeBonusNumber(numberGenerator: NumberGenerator): Int {
        val bonusNumber = numberGenerator.generateRandomNumber()
        return bonusNumber
    }
}