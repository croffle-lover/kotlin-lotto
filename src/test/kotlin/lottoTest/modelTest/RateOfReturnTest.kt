package lottoTest.modelTest

import lotto.model.Rank
import lotto.model.RateOfReturn
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RateOfReturnTest {
    @Test
    fun `구입 금액에 따른 수익률을 구할 수 있다 수익률은 소수점 셋째 자리에서 반올림한다`() {
        //given
        val money = 14_000
        Rank.saveRank(Rank.FIFTH)
        val winningMoney = Rank.getWinningMoney()
        val rate = RateOfReturn()

        //when
        val rateOfReturn = rate.getRateOfReturn(money, winningMoney)

        //then
        assertThat(rateOfReturn).isEqualTo(0.35)
    }
}