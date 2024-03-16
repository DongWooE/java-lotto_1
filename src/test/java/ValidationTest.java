import domain.Validation;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationTest {

    @Test
    void has_no_blank(){}

    @Test
    void check_number_duplication(){
        final String[] input = new String[] {"1","2"};
        assertThatThrownBy(() -> {
            Validation.validate(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void check_splitter_duplication(){
        final String[] input = new String[] {"1","+","-"};
        assertThatThrownBy(() -> {
            Validation.validate(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void check_first_splitter_duplication() {
        final String[] input = new String[] {"+", "1"};
        assertThatThrownBy(() -> {
            Validation.validate(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void check_last_splitter_duplication() {
        final String[] input = new String[] {"1", "+"};
        assertThatThrownBy(() -> {
            Validation.validate(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void check_valid_splitter() {
        final String[] input = new String[]{"1", "+", "2", "?", "5"};
        assertThatThrownBy(() -> {
            Validation.validate(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
