package lotto.model

import kotlin.math.round

class RateOfReturn {
    fun getRateOfReturn(money: Int, winningMoney: Int): Double {
        val rate = winningMoney.toDouble() / money.toDouble()
        return round(rate * 100) / 100
    }
}