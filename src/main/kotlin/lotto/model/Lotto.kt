package lotto.model

private const val LOTTO_TICKET_PRICE = 1_000
private const val SHOULD_PURCHASE_AT_LEAST_ONE_TICKET = "로또는 한 장 이상 구매해야 합니다."
private const val IS_NOT_MONEY = "은 양의 정수가 아닙니다."
private const val IS_NOT_1_000_UNIT = "원은 1,000원 단위가 아닙니다."
private const val ZERO_AMOUNT = 0

class Lotto(money: Int) {
    val ticketNumber : Int
    val lottoTickets : MutableList<List<Int>> = mutableListOf()

    init {
        require(money != ZERO_AMOUNT) { SHOULD_PURCHASE_AT_LEAST_ONE_TICKET }
        require(money > ZERO_AMOUNT) { "$money" + IS_NOT_MONEY }
        require(money % LOTTO_TICKET_PRICE == ZERO_AMOUNT) { "$money" + IS_NOT_1_000_UNIT }

        ticketNumber = money / LOTTO_TICKET_PRICE

        setLottoTickets()
    }

    private fun setLottoTickets() {
        val ticket = LottoTicket()
        repeat(ticketNumber) {
            val lottoTicket = ticket.makeLottoTicket()
            lottoTickets.add(lottoTicket)
        }
    }

    fun getRank(lottoTicketNumber: List<Int>, matchNumber: List<Int>, bonusNumber: Int): Any {
        val countOfMatch = lottoTicketNumber.count{ matchNumber.contains(it) }
        val matchBonus = lottoTicketNumber.contains( bonusNumber )

        return Rank.valueOf(countOfMatch, matchBonus)
    }
}