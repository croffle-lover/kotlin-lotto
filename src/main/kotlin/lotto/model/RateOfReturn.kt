package lotto.model

fun getRateOfReturn(money: Int, winningMoney: Int): Double {
    val rate = winningMoney.toDouble() / money.toDouble()
    val rateOfReturn = ((rate + 0.005) * 100).toInt() / 100.0
    return rateOfReturn
}