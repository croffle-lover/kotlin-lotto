package lotto.model

class WinningNumber {
    fun makeMatchNumber(): LottoTicket {
        val matchNumber = LottoTicket().makeLottoTicket()
        return matchNumber
    }

    fun makeBonusNumber(): Int {
        val bonusNumber = LottoNumber().getANumber()
        return bonusNumber
    }
}