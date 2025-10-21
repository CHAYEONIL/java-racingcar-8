package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @Test
    @DisplayName("게임을 지정한 횟수만큼 진행한다")
    void playGame() {
        List<String> names = Arrays.asList("pobi", "woni");
        Cars cars = new Cars(names);
        int rounds = 5;
        RacingGame game = new RacingGame(cars, rounds);

        List<List<Car>> history = game.play();

        assertThat(history).hasSize(rounds);
    }

    @Test
    @DisplayName("게임 종료 후 우승자를 반환한다")
    void getWinnersAfterGame() {
        List<String> names = Arrays.asList("pobi", "woni", "jun");
        Cars cars = new Cars(names);
        RacingGame game = new RacingGame(cars, 10);

        game.play();
        List<String> winners = game.getWinners();

        assertThat(winners).isNotEmpty();
    }

    @Test
    @DisplayName("각 라운드마다 자동차 상태가 기록된다")
    void recordCarStatesEachRound() {
        List<String> names = Arrays.asList("pobi");
        Cars cars = new Cars(names);
        RacingGame game = new RacingGame(cars, 3);

        List<List<Car>> history = game.play();

        assertThat(history).hasSize(3);
        for (List<Car> round : history) {
            assertThat(round).hasSize(1);
        }
    }
}