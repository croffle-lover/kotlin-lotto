package lotto.model

import lotto.view.InputView
import lotto.view.ResultView

private const val LOTTO_TICKET_PRICE = 1_000

class Money {
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
}