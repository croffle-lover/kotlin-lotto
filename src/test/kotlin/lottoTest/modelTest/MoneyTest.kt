package lottoTest.modelTest

import lotto.model.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

private const val SHOULD_PURCHASE_AT_LEAST_ONE_TICKET = "로또는 한 장 이상 구매해야 합니다."
private const val IS_NOT_MONEY = "은 양의 정수가 아닙니다."
private const val IS_NOT_1_000_UNIT = "원은 1,000원 단위가 아닙니다."

class MoneyTest {
    @Test
    fun `로또는 한 장 이상 구매해야 한다`() {
        //given
        val empty_money = 0

        //when
        val error: IllegalArgumentException = assertThrows { Lotto(empty_money) }

        //then
        assertThat(error.message).isEqualTo(SHOULD_PURCHASE_AT_LEAST_ONE_TICKET)
    }

    @ValueSource(ints = [-14_000, -500])
    @ParameterizedTest
    fun `로또 구입 금액은 양의 정수이어야 한다`(wrong_money: Int) {
        //given

        //when
        val error: IllegalArgumentException = assertThrows { Lotto(wrong_money) }

        //then
        assertThat(error.message).isEqualTo("$wrong_money" + IS_NOT_MONEY)
    }

    @ValueSource(ints = [14_500, 500])
    @ParameterizedTest
    fun `로또 구입 금액은 거스름돈 없이 1,000원 단위로 받는다`(wrong_money: Int) {
        //given

        //when
        val error: IllegalArgumentException = assertThrows { Lotto(wrong_money) }

        //then
        assertThat(error.message).isEqualTo("$wrong_money" + IS_NOT_1_000_UNIT)
    }
}