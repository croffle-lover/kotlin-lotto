package lotto.model

private const val LOTTO_TICKET_PRICE = 1_000

class Lotto(money: Int) {
    val ticketNumber = money / LOTTO_TICKET_PRICE
}