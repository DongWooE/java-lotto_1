package lotto.domain;

import java.util.Collections;
import java.util.Iterator;

public class ManualLottoCount{
    private final Integer count;

    public ManualLottoCount(Integer count) {
        validateIfNotNull(count);
        this.count = count;
    }

    public void validateIfLargerThanWholeCount(Cash cash) {
        int amount = cash.getAmount();
        if (amount < this.count) {
            throw new IllegalArgumentException();
        }
    }

    private void validateIfNotNull(Integer count) {
        if (count == null) {
            throw new IllegalArgumentException();
        }
    }

    public int getLeftOvers(Cash cash) {
        return cash.minus(this.count);
    }

    public Integer getCount() {
        return count;
    }

    public boolean isLargerThan(Integer count) {
        return this.count > count;
    }
}
