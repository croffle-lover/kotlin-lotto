package lotto.model

class LottoTicket() {
    fun makeLottoTicket(): List<Int> {
        val lottoRange = 1..100
        val lottoTicket = lottoRange.shuffled().chunked(6)[0]
        return lottoTicket
    }
}