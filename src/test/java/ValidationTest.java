import domain.Validation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationTest {

    @Test
    void has_no_blank(){}

    @Test
    void check_number_duplication(){
        final String[] input = new String[] {"1","2"};
        assertThatThrownBy(() -> {
            Validation.process(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void check_splitter_duplication(){
        final String[] input = new String[] {"+","-"};
        assertThatThrownBy(() -> {
            Validation.process(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void check_first_splitter_duplication() {
        final String[] input = new String[] {"+", "1"};
        assertThatThrownBy(() -> {
            Validation.checkSpliterPosition(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void check_last_splitter_duplication() {
        final String[] input = new String[] {"1", "+"};
        assertThatThrownBy(() -> {
            Validation.checkSpliterPosition(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
