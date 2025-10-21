package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    @Test
    @DisplayName("자동차 이름이 5자를 초과하면 예외 발생")
    void validateNameLength() {
        List<String> names = Arrays.asList("pobi", "crong", "honux123");

        assertThatThrownBy(() -> InputValidator.validateCarNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5자 이하");
    }

    @Test
    @DisplayName("자동차 이름이 빈 값이면 예외 발생")
    void validateEmptyName() {
        List<String> names = Arrays.asList("pobi", "", "jun");

        assertThatThrownBy(() -> InputValidator.validateCarNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백");
    }

    @Test
    @DisplayName("자동차 이름이 공백만 있으면 예외 발생")
    void validateBlankName() {
        List<String> names = Arrays.asList("pobi", "   ", "jun");

        assertThatThrownBy(() -> InputValidator.validateCarNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백");
    }

    @Test
    @DisplayName("자동차 이름에 중복이 있으면 예외 발생")
    void validateDuplicateName() {
        List<String> names = Arrays.asList("pobi", "woni", "pobi");

        assertThatThrownBy(() -> InputValidator.validateCarNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복");
    }

    @Test
    @DisplayName("올바른 자동차 이름은 예외가 발생하지 않는다")
    void validateValidNames() {
        List<String> names = Arrays.asList("pobi", "woni", "jun");

        InputValidator.validateCarNames(names);
    }

    @Test
    @DisplayName("시도 횟수가 양수이면 정상 반환")
    void validatePositiveRounds() {
        int rounds = InputValidator.validateAndParseRounds("5");

        assertThat(rounds).isEqualTo(5);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-10"})
    @DisplayName("시도 횟수가 0 이하면 예외 발생")
    void validateNonPositiveRounds(String input) {
        assertThatThrownBy(() -> InputValidator.validateAndParseRounds(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("양수");
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "12.5", "", "  "})
    @DisplayName("시도 횟수가 숫자가 아니면 예외 발생")
    void validateNonNumericRounds(String input) {
        assertThatThrownBy(() -> InputValidator.validateAndParseRounds(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자");
    }
}