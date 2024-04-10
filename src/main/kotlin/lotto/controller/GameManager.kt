package lotto.controller

import lotto.model.*
import lotto.view.InputView
import lotto.view.ResultView

class GameManager {
    private val output = ResultView()

    fun startGame() {
        val numberGenerator = MakeLottoNumber
        val money = InputView.getMoney()
        val lotto = getLotto(money)
        val match = getMatchNumber(numberGenerator)
        val bonus = getBonusNumber(numberGenerator)
        getResult(lotto, match, bonus, money)
    }

    private fun getLotto(money: Int): Lotto {
        val lotto = Lotto(money)
        output.printLottoTickets(lotto.ticketNumber, lotto.lottoTicketList)
        return lotto
    }

    private fun getMatchNumber(numberGenerator: MakeLottoNumber): LottoTicket {
        val winning = WinningNumber()

        val matchNumber = winning.makeMatchNumber(numberGenerator)
        output.printMatchNumber(matchNumber)

        return matchNumber
    }

    private fun getBonusNumber(numberGenerator: MakeLottoNumber): Int {
        val winning = WinningNumber()

        val bonusNumber = winning.makeBonusNumber(numberGenerator)
        output.printBonusNumber(bonusNumber)

        return bonusNumber
    }

    private fun getResult(lotto: Lotto, match: LottoTicket, bonus: Int, money: Int) {
        getWinResult(lotto, match, bonus)
        val rate = getRateResult(money)
        val rank = Rank.getRank()
        output.printWinningResult(rank, rate)
    }

    private fun getWinResult(lotto: Lotto, match: LottoTicket, bonus: Int) {
        for(lottoTicket in lotto.lottoTicketList) {
            val (countOfMatch, bonusMatch) = lotto.findMatch(lottoTicket, match, bonus)
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