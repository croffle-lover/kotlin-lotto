package lotto.controller

import lotto.model.Lotto
import lotto.model.Rank
import lotto.model.RateOfReturn
import lotto.model.WinningNumber
import lotto.view.InputView
import lotto.view.ResultView

class GameManager {
    private val input = InputView()
    private val output = ResultView()

    fun startGame() {
        val money = input.getMoney()
        val lotto = getLotto(money)
        val match = getMatchNumber()
        val bonus = getBonusNumber()
        getResult(lotto, match, bonus, money)
    }

    private fun getLotto(money: Int): Lotto {
        val lotto = Lotto(money)
        output.printLottoTickets(lotto.ticketNumber, lotto.lottoTickets)
        return lotto
    }

    private fun getMatchNumber(): List<Int> {
        val winning = WinningNumber()

        val matchNumber = winning.makeMatchNumber()
        output.printMatchNumber(matchNumber)

        return matchNumber
    }

    private fun getBonusNumber(): Int {
        val winning = WinningNumber()

        val bonusNumber = winning.makeBonusNumber()
        output.printBonusNumber(bonusNumber)

        return bonusNumber
    }

    private fun getResult(lotto: Lotto, match: List<Int>, bonus: Int, money: Int) {
        getWinResult(lotto, match, bonus)
        val rate = getRateResult(money)
        output.printWinningResult(Rank.values(), rate)
    }

    private fun getWinResult(lotto: Lotto, match: List<Int>, bonus: Int) {
        for(lottoTicket in lotto.lottoTickets) {
            val countOfMatch = lottoTicket.count { match.contains(it) }
            val bonusMatch = lottoTicket.contains(bonus)
            val rank = Rank.valueOf(countOfMatch, bonusMatch)
            Rank.saveRank(rank)
        }
    }

    private fun getRateResult(money: Int): Double {
        val winningMoney = Rank.getWinningMoney()
        val rate = RateOfReturn()
        val rateOfReturn = rate.getRateOfReturn(money, winningMoney)

        return rateOfReturn
    }
}