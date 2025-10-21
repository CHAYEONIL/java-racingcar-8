package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final Cars cars;
    private final int rounds;

    public RacingGame(Cars cars, int rounds) {
        this.cars = cars;
        this.rounds = rounds;
    }

    public List<List<Car>> play() {
        List<List<Car>> history = new ArrayList<>();

        for (int i = 0; i < rounds; i++) {
            cars.moveAll();
            history.add(copyCarStates());
        }

        return history;
    }

    public List<String> getWinners() {
        return cars.findWinners();
    }

    private List<Car> copyCarStates() {
        return new ArrayList<>(cars.getCars());
    }
}