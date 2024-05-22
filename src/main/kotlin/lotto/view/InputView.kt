package lotto.view

private const val PURCHASE_MONEY_PLEASE = "구입금액을 입력해 주세요."

object InputView {
    fun getMoney(): Int {
        println(PURCHASE_MONEY_PLEASE)
        val money = readlnOrNull() ?: "0"
        return money.toInt()
    }
}