package lottoTest.modelTest

import lotto.model.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

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

    @ValueSource(ints = [14_500, 500])
    @ParameterizedTest
    fun `로또 구입 금액은 거스름돈 없이 1,000원 단위로 받는다`(wrong_money: Int) {
        //given

        //when
        val error: IllegalArgumentException = assertThrows { Lotto(wrong_money) }

        //then
        assertThat(error.message).isEqualTo("${wrong_money}원은 1,000원 단위가 아닙니다.")
    }

    @ValueSource(ints = [-14_000, -500])
    @ParameterizedTest
    fun `로또 구입 금액은 양의 정수이어야 한다`(wrong_money: Int) {
        //given

        //when
        val error: IllegalArgumentException = assertThrows { Lotto(wrong_money) }

        //then
        assertThat(error.message).isEqualTo("${wrong_money}은 양의 정수가 아닙니다.")
    }
}