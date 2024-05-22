package lottoTest.modelTest

import lotto.model.Rank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class RankTest {
    @BeforeEach
    fun setup() {
        Rank.getRank().clear()
    }

    @Test
    fun `일치하는 번호의 갯수에 따라 어느 유형으로 당첨됐거나 당첨되지 않았는지 알려준다`() {
        //given
        val countOfMatch1 = 6
        val countOfMatch5 = 5
        val matchBonus = true
        val countOfMatchElse = 2

        //when
        val rank1 = Rank.valueOf(countOfMatch1, !matchBonus)
        val rank2 = Rank.valueOf(countOfMatch5, matchBonus)
        val rank3 = Rank.valueOf(countOfMatch5, !matchBonus)
        val rankElse = Rank.valueOf(countOfMatchElse, !matchBonus)

        //then
        assertAll(
            { assertThat(rank1).isEqualTo(Rank.FIRST) },
            { assertThat(rank2).isEqualTo(Rank.SECOND) },
            { assertThat(rank3).isEqualTo(Rank.THIRD) },
            { assertThat(rankElse).isEqualTo(Rank.MISS) }
        )
    }

    @Test
    fun `당첨 유형마다 몇 개의 로또가 당첨됐는지 저장한다`() {
        //given
        val rank = Rank.getRank()
        val firstRank = Rank.FIRST

        //when
        Rank.saveRank(firstRank)

        //then
        assertThat(rank.getValue(Rank.FIRST)).isEqualTo(1)
    }

    @Test
    fun `총 수익을 구할 수 있다`() {
        //given

        //when
        repeat(3) { Rank.saveRank(Rank.FIFTH) }
        Rank.saveRank(Rank.SECOND)

        //then
        assertThat(Rank.getWinningMoney()).isEqualTo(30_015_000)
    }
}