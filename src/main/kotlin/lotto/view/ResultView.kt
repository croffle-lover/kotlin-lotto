package lotto.view

import lotto.model.Rank
import lotto.model.LottoTicket

private const val PURCHASED_LOTTO_THIS_MUCH = "개를 구매했습니다."
private const val LAST_MATCH_NUMBER_PLEASE = "지난 주 당첨 번호를 입력해 주세요."
private const val BONUS_NUMBER_PLEASE = "보너스 볼을 입력해 주세요."
private const val WINNING_RESULT = "당첨 통계"
private const val DIVIDE_LINE = "---------"

private const val THREE_MATCH = "3개 일치 (5000원)- "
private const val FOUR_MATCH = "4개 일치 (50000원)- "
private const val FIVE_MATCH = "5개 일치 (1500000원)- "
private const val FIVE_AND_BONUS_MATCH = "5개 일치, 보너스 볼 일치(30000000원) - "
private const val SIX_MATCH = "6개 일치 (2000000000원)- "
private const val MATCH_UNIT = "개"

private const val RATE_OF_RETURN = "총 수익률은 "
private const val IS_THIS = "입니다."

object ResultView {
    fun printLottoTickets(ticketNumber: Int, lottoTickets: List<LottoTicket>) {
        println("$ticketNumber" + PURCHASED_LOTTO_THIS_MUCH)
        lottoTickets.forEach { lottoTicket ->
            val lotto = lottoTicket.getNumbers()
            val ticket = lotto.joinToString(separator = ", ", prefix = "[", postfix = "]")
            println(ticket)
        }
    }

    fun printMatchNumber(matchNumber: LottoTicket) {
        println(LAST_MATCH_NUMBER_PLEASE)
        val matchNumbers = matchNumber.getNumbers().joinToString(", ")
        println(matchNumbers)
    }

    fun printBonusNumber(bonusNumber: Int) {
        println(BONUS_NUMBER_PLEASE)
        println(bonusNumber)
    }

    fun printWinningResult(rank: MutableMap<Rank, Int>, money: Double) {
        println(WINNING_RESULT)
        println(DIVIDE_LINE)

        println(THREE_MATCH + "${rank.getValue(Rank.FIFTH)}" + MATCH_UNIT)
        println(FOUR_MATCH + "${rank.getValue(Rank.FOURTH)}" + MATCH_UNIT)
        println(FIVE_MATCH + "${rank.getValue(Rank.THIRD)}" + MATCH_UNIT)
        println(FIVE_AND_BONUS_MATCH + "${rank.getValue(Rank.SECOND)}" + MATCH_UNIT)
        println(SIX_MATCH + "${rank.getValue(Rank.FIRST)}" + MATCH_UNIT)

        println(RATE_OF_RETURN + "$money" + IS_THIS)
    }
}