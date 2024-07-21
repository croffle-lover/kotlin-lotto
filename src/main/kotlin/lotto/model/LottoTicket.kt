package lotto.model

private val NUMBER_AMOUNT = 6

class LottoTicket {
    private lateinit var lottoTicket: List<Int>

    fun makeLottoTicket(numberGenerator: NumberGenerator): LottoTicket {
        val lottoTicketNumbers = mutableListOf<Int>()
        repeat(NUMBER_AMOUNT) {
            var number = numberGenerator.generateRandomNumber()
            while (number in lottoTicketNumbers) {
                number = numberGenerator.generateRandomNumber()
            }
            lottoTicketNumbers.add(number)
        }
        lottoTicket = lottoTicketNumbers.sorted()

        return this
    }

    fun getNumbers(): List<Int> {
        return lottoTicket
    }
}