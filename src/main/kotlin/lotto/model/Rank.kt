package lotto.model

enum class Rank(val countOfMatch: Int, val winningMoney: Int, val matchBonus:Boolean, var matchAmount: Int) {
    FIRST(6, 2_000_000_000, false, 0),
    SECOND(5, 30_000_000, true, 0),
    THIRD(5, 1_500_000, false, 0),
    FOURTH(4, 50_000, false, 0),
    FIFTH(3, 5_000, false, 0),
    MISS(0, 0, false, 0);

    companion object {
        fun valueOf(countOfMatch: Int, matchBonus: Boolean): Rank {
            return values().find {
                 it.countOfMatch == countOfMatch && it.matchBonus == matchBonus
            }?: MISS
        }
    }
}