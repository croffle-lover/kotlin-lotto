package lotto.model

private const val LOTTO_TICKET_PRICE = 1_000

class Lotto(money: Int) {
    val ticketNumber : Int
    init {
        require(money > 0) { "${money}은 양의 정수가 아닙니다." }
        require(money % LOTTO_TICKET_PRICE == 0) { "${money}원은 1,000원 단위가 아닙니다." }

        ticketNumber = money / LOTTO_TICKET_PRICE
    }

    fun getRank(lottoTicketNumber: List<Int>, matchNumber: List<Int>, bonusNumber: Int): Any {
        val countOfMatch = lottoTicketNumber.count{ matchNumber.contains(it) }
        val matchBonus = lottoTicketNumber.contains( bonusNumber )

        return Rank.valueOf(countOfMatch, matchBonus)
    }
}