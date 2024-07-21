package lotto.model

import lotto.view.InputView
import lotto.view.ResultView

private const val LOTTO_TICKET_PRICE = 1_000

object Money {
    fun isAccurateMoney(money: Int): Int {
        if(money == 0) {
            ResultView.printMoneyError(money, "it's 0")
            isAccurateMoney(InputView.getMoney())
        }
        else if(money < 0) {
            ResultView.printMoneyError(money, "under 0")
            isAccurateMoney(InputView.getMoney())
        }
        else if(money % LOTTO_TICKET_PRICE != 0) {
            ResultView.printMoneyError(money, "not in thousand won units")
            isAccurateMoney(InputView.getMoney())
        }

        return money
    }

    fun getRateOfReturn(money: Int, winningMoney: Int): Double {
        val rate = winningMoney.toDouble() / money.toDouble()
        val rateOfReturn = ((rate + 0.005) * 100).toInt() / 100.0
        return rateOfReturn
    }
}