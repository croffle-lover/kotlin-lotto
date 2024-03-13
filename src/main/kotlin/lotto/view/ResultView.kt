package lotto.view

import lotto.model.Rank

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

class ResultView {
    fun printLottoTickets(ticketNumber: Int, lottoTickets: MutableList<List<Int>>) {
        println("$ticketNumber" + PURCHASED_LOTTO_THIS_MUCH)
        for (lotto in lottoTickets) {
            val ticket = lotto.joinToString(", ", "[", "]")
            println(ticket)
        }
    }

    fun printMatchNumber(matchNumber: List<Int>) {
        println(LAST_MATCH_NUMBER_PLEASE)
        val matchNumbers = matchNumber.joinToString(", ")
        println(matchNumbers)
    }

    fun printBonusNumber(bonusNumber: Int) {
        println(BONUS_NUMBER_PLEASE)
        println(bonusNumber)
    }

    fun printWinningResult(values: Array<Rank>, money: Double) {
        println(WINNING_RESULT)
        println(DIVIDE_LINE)

        println(THREE_MATCH+"${values[4].matchAmount}"+ MATCH_UNIT)
        println(FOUR_MATCH+"${values[3].matchAmount}"+ MATCH_UNIT)
        println(FIVE_MATCH+"${values[2].matchAmount}"+ MATCH_UNIT)
        println(FIVE_AND_BONUS_MATCH+"${values[1].matchAmount}"+ MATCH_UNIT)
        println(SIX_MATCH+"${values[0].matchAmount}"+ MATCH_UNIT)

        println(RATE_OF_RETURN+"$money"+ IS_THIS)
    }
}