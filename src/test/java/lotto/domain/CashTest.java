package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CashTest {

    @Test
    @DisplayName("1000보다 작으면 예외(999 => IllegalArgumentException)")
    void less_than_1000() {
        assertThatThrownBy(() -> {
            new Cash(999).getAmount();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("1000으로 나눈 몫을 반환(14000 => 14, 20123 => 20)")
    @CsvSource(value = {"14000:14", "20123:20"}, delimiter = ':')
    void more_than_1000(int money, int count) {
        int result = new Cash(money).getAmount();
        assertThat(result).isEqualTo(count);
    }

    @Test
    @DisplayName("남은 횟수 구하기(14000,10 => 4)")
    void minus() {
        int minus = new Cash(14000).minus(10);
        assertThat(minus).isEqualTo(4);
    }

    @Test
    @DisplayName("남은 횟수가 전체 횟수보다 크다면 예외(14000,15 => IllegalArgumentException)")
    void check_exception_minus() {
        assertThatThrownBy(() -> {
            new Cash(14000).minus(15);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
