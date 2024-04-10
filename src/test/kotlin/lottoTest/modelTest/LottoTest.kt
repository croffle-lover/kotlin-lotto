package lottoTest.modelTest

import lotto.model.Lotto
import lotto.model.LottoTicket
import lotto.model.Rank
import lotto.model.WinningNumber
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

private const val SHOULD_PURCHASE_AT_LEAST_ONE_TICKET = "로또는 한 장 이상 구매해야 합니다."
private const val IS_NOT_MONEY = "은 양의 정수가 아닙니다."
private const val IS_NOT_1_000_UNIT = "원은 1,000원 단위가 아닙니다."

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
        assertThat(error.message).isEqualTo("$wrong_money"+ IS_NOT_1_000_UNIT)
    }

    @ValueSource(ints = [-14_000, -500])
    @ParameterizedTest
    fun `로또 구입 금액은 양의 정수이어야 한다`(wrong_money: Int) {
        //given

        //when
        val error: IllegalArgumentException = assertThrows { Lotto(wrong_money) }

        //then
        assertThat(error.message).isEqualTo("$wrong_money"+ IS_NOT_MONEY)
    }

    @Test
    fun `로또는 한 장 이상 구매해야 한다`() {
        //given
        val empty_money = 0

        //when
        val error: IllegalArgumentException = assertThrows { Lotto(empty_money) }

        //then
        assertThat(error.message).isEqualTo(SHOULD_PURCHASE_AT_LEAST_ONE_TICKET)
    }

    @Test
    fun `발행한 로또들의 번호를 저장한다`() {
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

    @Test
    fun `사용자가 구매한 로또 번호와 당첨 번호, 보너스 번호를 비교하여 당첨 여부를 확인한다`() {
        //given
        val lottoTicket = LottoTicket()
        val winning = WinningNumber()
        val lotto = Lotto(1_000)
        val lottoTicketNumber = lottoTicket.makeLottoTicket()
        val matchNumber = winning.makeMatchNumber()
        val bonusNumber = winning.makeBonusNumber()

        //when
        val won = lotto.getRank(lottoTicketNumber, matchNumber, bonusNumber)

        //then
        val rankValues = Rank.values()
        assertThat(won).isIn(*rankValues)
    }
}