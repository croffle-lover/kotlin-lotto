package lottoTest.modelTest

import lotto.model.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

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

    @Test
    fun `사용자가 구매한 로또 번호와 당첨 번호, 보너스 번호를 비교하여 당첨 여부를 확인한다`() {
        //given
        val randomGenerator = MakeLottoNumber
        val lottoTicket = LottoTicket()
        val winning = WinningNumber()
        val lotto = Lotto(1_000)
        val lottoTicketNumber = lottoTicket.makeLottoTicket(randomGenerator)
        val matchNumber = winning.makeMatchNumber(randomGenerator)
        val bonusNumber = winning.makeBonusNumber(randomGenerator)

        //when
        val won = lotto.getRank(lottoTicketNumber, matchNumber, bonusNumber)

        //then
        val rankValues = Rank.values()
        assertThat(won).isIn(*rankValues)
    }
}