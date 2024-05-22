package lottoTest.modelTest


import lotto.model.Rank
import lotto.model.Rank.Companion.getWinningMoney
import lotto.model.getRateOfReturn
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class RateOfReturnTest {
    @CsvSource("14_000,0.36", "16_000,0.31", "8_000,0.63")
    @ParameterizedTest
    fun `구입 금액에 따른 수익률을 구할 수 있다 수익률은 소수점 셋째 자리에서 반올림한다`(money: Int, expectedRateOfReturn: Double) {
        //given
        val winningMoney = getWinningMoney()

        //when
        val rateOfReturn = getRateOfReturn(money, winningMoney)

        //then
        assertThat(rateOfReturn).isEqualTo(expectedRateOfReturn)
    }

    companion object {
        @JvmStatic
        @BeforeAll
        fun setUp() {
            Rank.saveRank(Rank.FIFTH)
        }
    }
}