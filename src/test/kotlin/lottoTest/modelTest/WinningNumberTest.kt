package lottoTest.modelTest

import lotto.model.MakeLottoNumber
import lotto.model.WinningNumber
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

private val NUMBER_AMOUNT = 6

class WinningNumberTest {
    @Test
    fun `당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다`() {
        //given
        val randomGenerator = MakeLottoNumber
        val winning = WinningNumber()
        val matchNumber = winning.makeMatchNumber(randomGenerator)
        val matchBonus = winning.makeBonusNumber(randomGenerator)

        //when

        //then
        assertThat(matchNumber.lottoTicket.distinct().count()).isEqualTo(NUMBER_AMOUNT)
        assertThat(matchBonus).isNotIn(matchNumber)
    }
}