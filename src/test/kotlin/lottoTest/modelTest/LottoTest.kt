package lottoTest.modelTest

import lotto.model.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    fun `로또 구입 금액에 해당하는 로또 수량 및 로또를 발급해야 한다 로또 1장의 가격은 1,000원이다`() {
        //given
        val money = 14_000

        //when
        val lottoTickets = Lotto(money)

        //then
        assertThat(lottoTickets.ticketNumber).isEqualTo(14)
    }
}