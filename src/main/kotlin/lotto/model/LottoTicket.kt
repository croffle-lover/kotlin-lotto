package lotto.model

private val NUMBER_AMOUNT = 6
private val NUMBER_RANGE = 1..45
class LottoTicket() {
    fun makeLottoTicket(): List<Int> {
        val lottoTicket = NUMBER_RANGE.shuffled().chunked(NUMBER_AMOUNT)[0]
        return lottoTicket.sorted()
    }
}