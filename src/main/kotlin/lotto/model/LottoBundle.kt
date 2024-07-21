package lotto.model

object LottoBundle {
    fun setLottoTicketBundle(ticketNumber: Int): List<LottoTicket> {
        val lottoTicketBundle: MutableList<LottoTicket> = mutableListOf()
        val numberGenerator = MakeLottoNumber
        repeat(ticketNumber) {
            val ticket = LottoTicket(numberGenerator)
            lottoTicketBundle.add(ticket)
        }
        return lottoTicketBundle
    }
}