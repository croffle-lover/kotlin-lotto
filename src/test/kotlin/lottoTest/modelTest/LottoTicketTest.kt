package lottoTest.modelTest

import io.kotest.data.forAll
import lotto.model.LottoTicket
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class LottoTicketTest {
    @Test
    fun `1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 무작위로 뽑는다`() {
        //given
        val lotto = LottoTicket()
        val lottoTicket = lotto.makeLottoTicket()

        //when
        lottoTicket.toSet()

        //then
        assertThat(lottoTicket.count()).isEqualTo(6)
    }

    @Test
    fun `로또 번호의 숫자 범위는 1~45까지이다`() {
        //given
        val lotto = LottoTicket()
        val lottoTicket = lotto.makeLottoTicket()

        //when

        //then
        assertThat(lottoTicket).allMatch{ it in 1..45 }
    }
}