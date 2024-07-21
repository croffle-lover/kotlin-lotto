package lotto.model

import lotto.model.RandomNumberGenerator.*

private val NUMBER_AMOUNT = 6

class LottoTicket(numberGenerator: NumberGenerator) {
    private val _lottoTicket: List<Int>

    init {
        val lottoTicketNumbers = mutableListOf<Int>()
        repeat(NUMBER_AMOUNT) {
            var number = numberGenerator.generateRandomNumber()
            while (number in lottoTicketNumbers) {
                number = numberGenerator.generateRandomNumber()
            }
            lottoTicketNumbers.add(number)
        }
        _lottoTicket = lottoTicketNumbers.sorted()
    }

    val lottoTicket: List<Int>
        get() = _lottoTicket
}
