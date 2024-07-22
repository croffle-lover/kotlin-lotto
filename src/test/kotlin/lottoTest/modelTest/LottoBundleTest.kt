package lottoTest.modelTest

import lotto.model.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class LottoBundleTest {

    @Test
    fun `구입한 로또들의 번호들을 가진다`() {
        //given
        val money = 2_000
        val lotto = Lotto(money)

        //when

        //then
        assertAll(
            { assertThat(lotto.lottoTicketBundle[0].lottoTicket.size).isEqualTo(6) },
            { assertThat(lotto.lottoTicketBundle[1].lottoTicket.size).isEqualTo(6) }
        )
    }
}