package lotto.model

private val NUMBER_RANGE = 1..45

class WinningNumber {
    fun makeMatchNumber(): LottoTicket {
        val matchNumber = LottoTicket().makeLottoTicket()
        return matchNumber
    }

    fun makeBonusNumber(): Int {
        val bonusNumber = NUMBER_RANGE.shuffled()[0]
        return bonusNumber
    }
}