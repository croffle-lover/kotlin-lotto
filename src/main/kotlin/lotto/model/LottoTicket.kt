package lotto.model

private val NUMBER_AMOUNT = 6

class LottoTicket() {
    private lateinit var lottoTicket: List<Int>

    fun makeLottoTicket(): LottoTicket {
        val lottoTicketNumber = mutableListOf<Int>()
        repeat(NUMBER_AMOUNT) {
            var number = LottoNumber().getANumber()
            while(number in lottoTicketNumber){
                number = LottoNumber().getANumber()
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