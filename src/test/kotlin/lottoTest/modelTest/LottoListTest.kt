package lottoTest.modelTest

import lotto.model.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class LottoListTest {

    @Test
    fun `구입한 로또들의 번호들을 가진다`() {
        //given
        val money = 2_000
        val lotto = Lotto(money)

        //when

        //then
        assertAll(
            { assertThat(lotto.lottoTicketList[0].getNumbers().size).isEqualTo(6) },
            { assertThat(lotto.lottoTicketList[1].getNumbers().size).isEqualTo(6) }
        )
    }
}