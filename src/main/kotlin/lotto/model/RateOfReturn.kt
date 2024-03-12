package lotto.model

import kotlin.math.floor

class RateOfReturn {
    fun getRateOfReturn(money: Int, winningMoney: Int): Double {
        val rate = winningMoney.toDouble() / money.toDouble()
        return floor(rate * 100) / 100
    }
}