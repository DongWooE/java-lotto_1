package lotto.domain;

import java.util.Arrays;

public class MatchCache {
    private final int[] counts;
    private int bonusCount;

    public MatchCache() {
        this(new int[6], 0);
    }

    public MatchCache(int[] counts, int bonusCount) {
        this.counts = counts;
        this.bonusCount = bonusCount;
    }

    public void save(int matchCount, boolean isBonus) {
        if (isBonusLotto(matchCount, isBonus)) {
            this.bonusCount++;
            return;
        }
        this.counts[matchCount - 1]++;
    }

    private boolean isBonusLotto(int matchCount, boolean isBonus) {
        return matchCount == 5 && isBonus;
    }

    @Override
    public String toString() {
        return String.format("\n3개 일치 (5000원)- %d개\n", this.counts[2]) +
                String.format("4개 일치 (50000원)- %d개\n", this.counts[3]) +
                String.format("5개 일치 (1500000원)- %d개\n", this.counts[4]) +
                String.format("6개 일치 (2000000000원) - %d개\n", this.counts[5]);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MatchCache)) return false;
        MatchCache that = (MatchCache) o;
        return Arrays.equals(counts, that.counts);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(counts);
    }

    public int[] getCounts() {
        return counts;
    }

    public int getBonusCount() {
        return bonusCount;
    }
}
