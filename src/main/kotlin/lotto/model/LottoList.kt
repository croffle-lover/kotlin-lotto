package lotto.model

object LottoList {
    fun setLottoTicketList(ticketNumber: Int, lottoTicketList: MutableList<LottoTicket>) {
        val numberGenerator = MakeLottoNumber
        repeat(ticketNumber) {
            val ticket = LottoTicket()
                ticket.makeLottoTicket(numberGenerator)
            lottoTicketList.add(ticket)
        }
    }
}