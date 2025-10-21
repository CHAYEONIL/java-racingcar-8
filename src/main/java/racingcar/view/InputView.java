package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.InputValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String CAR_NAMES_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ROUNDS_PROMPT = "시도할 횟수는 몇 회인가요?";
    private static final String DELIMITER = ",";

    public static List<String> readCarNames() {
        System.out.println(CAR_NAMES_PROMPT);
        String input = Console.readLine();
        List<String> names = parseNames(input);
        InputValidator.validateCarNames(names);
        return names;
    }

    public static int readRounds() {
        System.out.println(ROUNDS_PROMPT);
        String input = Console.readLine();
        return InputValidator.validateAndParseRounds(input);
    }

    private static List<String> parseNames(String input) {
        return Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}