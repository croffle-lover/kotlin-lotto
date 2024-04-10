package lotto.model

object LottoList {
    fun setLottoTicketList(ticketNumber: Int, lottoTicketList: MutableList<LottoTicket>) {
        repeat(ticketNumber) {
            val ticket = LottoTicket()
                ticket.makeLottoTicket()
            lottoTicketList.add(ticket)
        }
    }
}