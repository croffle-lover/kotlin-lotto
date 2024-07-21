package lotto.model

private const val LOTTO_TICKET_PRICE = 1_000

class Lotto(money: Int) {
    val ticketNumber: Int = Money().isAccurateMoney(money) / LOTTO_TICKET_PRICE
    val lottoTicketList: List<LottoTicket> = LottoBundle.setLottoTicketBundle(ticketNumber)

    fun findMatch(lottoTicket: LottoTicket, match: LottoTicket, bonus: Int): Pair<Int, Boolean> {
        val ticket: List<Int> = lottoTicket.getNumbers()
        val countOfMatch = ticket.count { match.getNumbers().contains(it) }
        val matchesBonus = ticket.contains(bonus)

        return Pair(countOfMatch, matchesBonus)
    }

    fun getRank(lottoTicketNumber: LottoTicket, matchNumber: LottoTicket, bonusNumber: Int): Any {
        val (countOfMatch, matchBonus) = findMatch(lottoTicketNumber, matchNumber, bonusNumber)

        return Rank.valueOf(countOfMatch, matchBonus)
    }
}