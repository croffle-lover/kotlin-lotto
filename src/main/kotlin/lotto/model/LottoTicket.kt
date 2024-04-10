package lotto.model

private val NUMBER_AMOUNT = 6
private val NUMBER_RANGE = 1..45
class LottoTicket() {
    private lateinit var lottoTicket: List<Int>

    fun makeLottoTicket(): LottoTicket {
        val lottoTicketNumber = NUMBER_RANGE.shuffled().chunked(NUMBER_AMOUNT)[0]
        lottoTicket = lottoTicketNumber.sorted()

        return this
    }

    fun getNumbers(): List<Int> {
        return lottoTicket
    }
}