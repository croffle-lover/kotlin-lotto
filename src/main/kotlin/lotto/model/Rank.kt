package lotto.model

enum class Rank(val countOfMatch: Int, val winningMoney: Int, val matchesBonus:Boolean) {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    MISS(0, 0, false);

    companion object {
        private val rankMap = mutableMapOf<Rank, Int>().withDefault { 0 }

        fun valueOf(countOfMatch: Int, matchesBonus: Boolean): Rank {
            return values().find {
                it.countOfMatch == countOfMatch && it.matchesBonus == matchesBonus
            } ?: MISS
        }

        fun saveRank(rank: Rank) {
            rankMap[rank] = rankMap.getValue(rank) + 1
        }

        fun getWinningMoney(): Int {
            return values().sumOf { it.winningMoney * rankMap.getValue(it) }
        }

        fun getRank(): MutableMap<Rank, Int> {
            return rankMap
        }
    }
}
