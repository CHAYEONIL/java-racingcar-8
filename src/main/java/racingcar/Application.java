package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> carNames = InputView.readCarNames();
        int rounds = InputView.readRounds();

        Cars cars = new Cars(carNames);
        RacingGame game = new RacingGame(cars, rounds);

        OutputView.printResultHeader();
        List<List<Car>> history = game.play();
        printGameHistory(history);

        List<String> winners = game.getWinners();
        OutputView.printWinners(winners);
    }

    private static void printGameHistory(List<List<Car>> history) {
        for (List<Car> round : history) {
            OutputView.printRoundResult(round);
        }
    }
}