package lotto.model

import lotto.model.RandomNumberGenerator.*

private val NUMBER_RANGE = 1..45

object MakeLottoNumber : NumberGenerator {
    override fun generateRandomNumber(): Int {
        return NUMBER_RANGE.shuffled().first()
    }
}