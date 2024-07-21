package lotto.model

private const val LOTTO_TICKET_PRICE = 1_000

class Lotto(money: Int) {
    val ticketNumber: Int = Money().isAccurateMoney(money) / LOTTO_TICKET_PRICE
    val lottoTicketBundle: List<LottoTicket> = LottoBundle.setLottoTicketBundle(ticketNumber)

    fun findMatch(lottoTicket: LottoTicket, match: LottoTicket, bonus: Int): Pair<Int, Boolean> {
        val ticket: List<Int> = lottoTicket.lottoTicket
        val countOfMatch = ticket.count { match.lottoTicket.contains(it) }
        val matchesBonus = ticket.contains(bonus)

        return Pair(countOfMatch, matchesBonus)
    }

    fun getRank(lottoTicketNumbers: LottoTicket, matchNumber: LottoTicket, bonusNumber: Int): Any {
        val (countOfMatch, matchBonus) = findMatch(lottoTicketNumbers, matchNumber, bonusNumber)

        return Rank.valueOf(countOfMatch, matchBonus)
    }
}