package lottoTest.modelTest

import lotto.model.LottoTicket
import lotto.model.MakeLottoNumber
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

private val NUMBER_AMOUNT = 6

class LottoTicketTest {
    @Test
    fun `1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 무작위로 뽑는다`() {
        //given
        val randomGenerator = MakeLottoNumber
        val lotto = LottoTicket()
        val lottoTicket = lotto.makeLottoTicket(randomGenerator)

        //when
        lottoTicket.makeLottoTicket(randomGenerator)

        //then
        assertThat(lottoTicket.getNumbers().distinct().count()).isEqualTo(NUMBER_AMOUNT)
    }

    @Test
    fun `로또 번호는 오름차순으로 정렬하여 보여준다`() {
        //given
        val randomGenerator = MakeLottoNumber
        val lotto = LottoTicket()
        val lottoTicket = lotto.makeLottoTicket(randomGenerator)

        //when

        //then
        assertThat(lottoTicket.getNumbers()).isSorted()
    }
}