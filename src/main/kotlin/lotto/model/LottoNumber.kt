package lotto.model
private val NUMBER_RANGE = 1..45

class LottoNumber() {
    fun getANumber(): Int {
        val number = NUMBER_RANGE.shuffled().first()
        return number
    }
}