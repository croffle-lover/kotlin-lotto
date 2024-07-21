package lotto.view

import lotto.model.*

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

private const val SHOULD_PURCHASE_AT_LEAST_ONE_TICKET = "로또는 한 장 이상 구매해야 합니다."
private const val IS_NOT_MONEY = "은 양의 정수가 아닙니다."
private const val IS_NOT_1_000_UNIT = "원은 1,000원 단위가 아닙니다."

object ResultView {
    fun printLottoTickets(ticketNumber: Int, lottoTickets: List<LottoTicket>) {
        println("$ticketNumber" + PURCHASED_LOTTO_THIS_MUCH)
        lottoTickets.forEach { lottoTicket ->
            val ticket = lottoTicket.lottoTicket.joinToString(separator = ", ", prefix = "[", postfix = "]")
            println(ticket)
        }
    }

    fun printMatchNumber(matchNumber: LottoTicket) {
        println(LAST_MATCH_NUMBER_PLEASE)
        val matchNumbers = matchNumber.lottoTicket.joinToString(", ")
        println(matchNumbers)
    }

    fun printBonusNumber(bonusNumber: Int) {
        println(BONUS_NUMBER_PLEASE)
        println(bonusNumber)
    }

    fun printWinningResult(rank: Map<Rank, Int>, money: Double) {
        val result = StringBuilder()

        result.appendLine(WINNING_RESULT)
            .appendLine(DIVIDE_LINE)
            .appendLine("$THREE_MATCH${rank.getValue(Rank.FIFTH)}$MATCH_UNIT")
            .appendLine("$FOUR_MATCH${rank.getValue(Rank.FOURTH)}$MATCH_UNIT")
            .appendLine("$FIVE_MATCH${rank.getValue(Rank.THIRD)}$MATCH_UNIT")
            .appendLine("$FIVE_AND_BONUS_MATCH${rank.getValue(Rank.SECOND)}$MATCH_UNIT")
            .appendLine("$SIX_MATCH${rank.getValue(Rank.FIRST)}$MATCH_UNIT")
            .appendLine("$RATE_OF_RETURN$money$IS_THIS")

        println(result.toString())
    }

    fun printMoneyError(money: Int, msg: String) {
        when (msg) {
            "it's 0" -> println(SHOULD_PURCHASE_AT_LEAST_ONE_TICKET)
            "under 0" -> println("$money" + IS_NOT_MONEY)
            "not in thousand won units" -> println("$money" + IS_NOT_1_000_UNIT)
        }
    }
}