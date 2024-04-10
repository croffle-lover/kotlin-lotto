package lotto.model

private const val LOTTO_TICKET_PRICE = 1_000
private const val SHOULD_PURCHASE_AT_LEAST_ONE_TICKET = "로또는 한 장 이상 구매해야 합니다."
private const val IS_NOT_MONEY = "은 양의 정수가 아닙니다."
private const val IS_NOT_1_000_UNIT = "원은 1,000원 단위가 아닙니다."
private const val ZERO_AMOUNT = 0

class Lotto(money: Int) {
    val ticketNumber: Int
    var lottoTicketList = mutableListOf<LottoTicket>()

    init {
        require(money != ZERO_AMOUNT) { SHOULD_PURCHASE_AT_LEAST_ONE_TICKET }
        require(money > ZERO_AMOUNT) { "$money" + IS_NOT_MONEY }
        require(money % LOTTO_TICKET_PRICE == ZERO_AMOUNT) { "$money" + IS_NOT_1_000_UNIT }

        ticketNumber = money / LOTTO_TICKET_PRICE

        LottoList.setLottoTicketList(ticketNumber, lottoTicketList)
    }

    fun findMatch(lottoTicket: LottoTicket, match: LottoTicket, bonus: Int): Pair<Int, Boolean> {
        val ticket: List<Int> = lottoTicket.getNumbers()
        val countOfMatch = ticket.count{ match.getNumbers().contains(it) }
        val matchBonus = ticket.contains( bonus )

        return Pair(countOfMatch, matchBonus)
    }

    fun getRank(lottoTicketNumber: LottoTicket, matchNumber: LottoTicket, bonusNumber: Int): Any {
        val (countOfMatch, matchBonus) = findMatch(lottoTicketNumber, matchNumber, bonusNumber)

        return Rank.valueOf(countOfMatch, matchBonus)
    }
}