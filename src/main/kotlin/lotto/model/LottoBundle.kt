package lotto.model

object LottoBundle {
    fun setLottoTicketBundle(ticketNumber: Int): List<LottoTicket> {
        val lottoTicketList: MutableList<LottoTicket> = mutableListOf()
        val numberGenerator = MakeLottoNumber
        repeat(ticketNumber) {
            val ticket = LottoTicket().makeLottoTicket(numberGenerator)
            lottoTicketList.add(ticket)
        }
        return lottoTicketList
    }
}