package lottoTest.modelTest

import lotto.model.LottoNumber
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

private val NUMBER_RANGE = 1..45

class LottoNumberTest {
    @Test
    fun `로또 번호의 숫자 범위는 1~45까지이다`() {
        //given
        val lottoNumber = LottoNumber()

        //when
        val number = lottoNumber.getANumber()

        //then
        assertThat(number in NUMBER_RANGE)
    }
}