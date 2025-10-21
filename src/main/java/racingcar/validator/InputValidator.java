package racingcar.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String INVALID_NAME_LENGTH_MESSAGE = "자동차 이름은 5자 이하여야 합니다.";
    private static final String EMPTY_NAME_MESSAGE = "자동차 이름은 공백일 수 없습니다.";
    private static final String DUPLICATE_NAME_MESSAGE = "자동차 이름은 중복될 수 없습니다.";
    private static final String INVALID_ROUNDS_FORMAT_MESSAGE = "시도 횟수는 숫자여야 합니다.";
    private static final String INVALID_ROUNDS_VALUE_MESSAGE = "시도 횟수는 양수여야 합니다.";

    public static void validateCarNames(List<String> names) {
        validateNotEmpty(names);
        validateNameLength(names);
        validateNoDuplicate(names);
    }

    public static int validateAndParseRounds(String input) {
        int rounds = parseRounds(input);
        validatePositive(rounds);
        return rounds;
    }

    private static void validateNotEmpty(List<String> names) {
        for (String name : names) {
            validateSingleNameNotEmpty(name);
        }
    }

    private static void validateSingleNameNotEmpty(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException(EMPTY_NAME_MESSAGE);
        }
    }

    private static void validateNameLength(List<String> names) {
        for (String name : names) {
            validateSingleNameLength(name);
        }
    }

    private static void validateSingleNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH_MESSAGE);
        }
    }

    private static void validateNoDuplicate(List<String> names) {
        Set<String> uniqueNames = new HashSet<>(names);
        if (uniqueNames.size() != names.size()) {
            throw new IllegalArgumentException(DUPLICATE_NAME_MESSAGE);
        }
    }

    private static int parseRounds(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_ROUNDS_FORMAT_MESSAGE);
        }
    }

    private static void validatePositive(int rounds) {
        if (rounds <= 0) {
            throw new IllegalArgumentException(INVALID_ROUNDS_VALUE_MESSAGE);
        }
    }
}