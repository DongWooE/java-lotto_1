import domain.Calculate;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculateTest {

    @ParameterizedTest
    @CsvSource(value = {"1:2:3", "2:4:6"}, delimiter = ':')
    void plus(int firstInput, int secondInput, int resultInput){
        int result = Calculate.plus(firstInput, secondInput);
        assertThat(result).isEqualTo(resultInput);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2:-1", "2:4:-2"}, delimiter = ':')
    void minus(int firstInput, int secondInput, int resultInput) {
        // when
        int result = Calculate.minus(firstInput, secondInput);
        // then
        assertThat(result).isEqualTo(resultInput);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2:2", "2:4:8"}, delimiter = ':')
    void multiple(int firstInput, int secondInput, int resultInput) {
        // when
        int result = Calculate.multiple(firstInput, secondInput);
        // then
        assertThat(result).isEqualTo(resultInput);
    }

    @ParameterizedTest
    @CsvSource(value = {"4:2:2", "32:4:8"}, delimiter = ':')
    void divide(int firstInput, int secondInput, int resultInput) {
        // when
        int result = Calculate.divide(firstInput, secondInput);
        // then
        assertThat(result).isEqualTo(resultInput);
    }
}
