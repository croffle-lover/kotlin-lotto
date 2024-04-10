package lotto.model

private val NUMBER_AMOUNT = 6

class LottoTicket() {
    private lateinit var lottoTicket: List<Int>

    fun makeLottoTicket(numberGenerator: NumberGenerator): LottoTicket {
        val lottoTicketNumber = mutableListOf<Int>()
        repeat(NUMBER_AMOUNT) {
            var number = numberGenerator.generateRandomNumber()
            while(number in lottoTicketNumber){
                number = numberGenerator.generateRandomNumber()
            }
            lottoTicketNumber.add(number)
        }
        lottoTicket = lottoTicketNumber.sorted()

        return this
    }

    fun getNumbers(): List<Int> {
        return lottoTicket
    }
}