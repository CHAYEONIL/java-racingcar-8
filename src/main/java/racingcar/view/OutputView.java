package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {
    private static final String RESULT_HEADER = "\n실행 결과";
    private static final String POSITION_SYMBOL = "-";
    private static final String NAME_POSITION_FORMAT = "%s : %s";
    private static final String WINNER_FORMAT = "최종 우승자 : %s";
    private static final String WINNER_DELIMITER = ", ";

    public static void printResultHeader() {
        System.out.println(RESULT_HEADER);
    }

    public static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            printCarPosition(car);
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        String winnerNames = String.join(WINNER_DELIMITER, winners);
        System.out.println(String.format(WINNER_FORMAT, winnerNames));
    }

    private static void printCarPosition(Car car) {
        String position = POSITION_SYMBOL.repeat(car.getPosition());
        System.out.println(String.format(NAME_POSITION_FORMAT, car.getName(), position));
    }
}