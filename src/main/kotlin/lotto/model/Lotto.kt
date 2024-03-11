package lotto.model

private const val LOTTO_TICKET_PRICE = 1_000

class Lotto(money: Int) {
    init {
        require(money % LOTTO_TICKET_PRICE == 0) { "${money}원은 1,000원 단위가 아닙니다." }
    }
    val ticketNumber = money / LOTTO_TICKET_PRICE
}