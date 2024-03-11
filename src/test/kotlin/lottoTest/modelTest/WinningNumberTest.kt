package lottoTest.modelTest

import lotto.model.WinningNumber
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinningNumberTest {
    @Test
    fun `당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다`() {
        //given
        val winning = WinningNumber()
        val matchNumber = winning.makeMatchNumber()
        val matchBonus = winning.makeBonusNumber()

        //when
        matchNumber.toSet()

        //then
        assertThat(matchNumber.count()).isEqualTo(6)
        assertThat(matchBonus).isNotIn(matchNumber)
    }
}