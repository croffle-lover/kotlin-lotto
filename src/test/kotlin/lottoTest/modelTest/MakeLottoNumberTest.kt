package lottoTest.modelTest

import lotto.model.Lotto
import lotto.model.MakeLottoNumber
import lotto.model.WinningNumber
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

private val NUMBER_RANGE = 1..45

class MakeLottoNumberTest {
    @Test
    fun `로또 번호와 보너스 번호의 범위는 1~45까지이다`() {
        //given
        val numberGenerator = MakeLottoNumber
        val lotto = Lotto(14_000)
        val match = WinningNumber().makeMatchNumber(numberGenerator).getNumbers()
        val bonus = WinningNumber().makeBonusNumber(numberGenerator)

        //when

        //then
        for (lottoTicket in lotto.lottoTicketList)
            assertThat(lottoTicket.getNumbers()).allMatch { it in NUMBER_RANGE }
        assertThat(match).allMatch { it in NUMBER_RANGE }
        assertThat(bonus).isIn( NUMBER_RANGE )
    }
}