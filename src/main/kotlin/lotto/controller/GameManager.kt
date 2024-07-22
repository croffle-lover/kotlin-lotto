package lotto.controller

import lotto.model.*
import lotto.view.InputView
import lotto.view.ResultView

class GameManager {
    fun startGame() {
        val money = InputView.getMoney()
        val lotto = getLotto(money)
        val match = getMatchNumber(MakeLottoNumber)
        val bonus = getBonusNumber(MakeLottoNumber)
        getResult(lotto, match, bonus, money, RankInfo())
    }

    private fun getLotto(money: Int): Lotto {
        val lotto = Lotto(money)
        ResultView.printLottoTickets(lotto.ticketNumber, lotto.lottoTicketBundle)
        return lotto
    }

    private fun getMatchNumber(numberGenerator: MakeLottoNumber): LottoTicket {
        val winning = WinningNumber()

        val matchNumber = winning.makeMatchNumber(numberGenerator)
        ResultView.printMatchNumber(matchNumber)

        return matchNumber
    }

    private fun getBonusNumber(numberGenerator: MakeLottoNumber): Int {
        val winning = WinningNumber()

        val bonusNumber = winning.makeBonusNumber(numberGenerator)
        ResultView.printBonusNumber(bonusNumber)

        return bonusNumber
    }

    private fun getResult(lotto: Lotto, match: LottoTicket, bonus: Int, money: Int, rankInfo: RankInfo) {
        getWinResult(lotto, match, bonus, rankInfo)
        val rate = getRateResult(money, rankInfo)
        val rank = rankInfo.getRank()
        ResultView.printWinningResult(rank, rate)
    }

    private fun getWinResult(lotto: Lotto, match: LottoTicket, bonus: Int, rankInfo: RankInfo) {
        for (lottoTicket in lotto.lottoTicketBundle) {
            val (countOfMatch, bonusMatch) = lotto.findMatch(lottoTicket, match, bonus)
            val rank = Rank.valueOf(countOfMatch, bonusMatch)
            rankInfo.saveRank(rank)
        }
    }

    private fun getRateResult(money: Int, rankInfo: RankInfo): Double {
        val winningMoney = rankInfo.getWinningMoney()
        val rateOfReturn = Money.getRateOfReturn(money, winningMoney)

        return rateOfReturn
    }
}