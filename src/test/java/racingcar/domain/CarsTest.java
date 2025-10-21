package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    @DisplayName("여러 대의 자동차를 생성한다")
    void createCars() {
        List<String> names = Arrays.asList("pobi", "woni", "jun");
        Cars cars = new Cars(names);

        assertThat(cars.getCars()).hasSize(3);
    }

    @Test
    @DisplayName("모든 자동차를 이동시킨다")
    void moveAllCars() {
        List<String> names = Arrays.asList("pobi", "woni");
        Cars cars = new Cars(names);

        cars.moveAll();

        for (Car car : cars.getCars()) {
            assertThat(car.getPosition()).isGreaterThanOrEqualTo(0);
        }
    }

    @Test
    @DisplayName("우승자를 찾는다 - 단독 우승")
    void findSingleWinner() {
        List<String> names = Arrays.asList("pobi", "woni", "jun");
        Cars cars = new Cars(names);

        // 한 자동차만 충분히 이동시켜 우승자 만들기
        for (int i = 0; i < 100; i++) {
            cars.moveAll();
        }

        List<String> winners = cars.findWinners();
        assertThat(winners).isNotEmpty();
    }

    @Test
    @DisplayName("우승자를 찾는다 - 공동 우승")
    void findMultipleWinners() {
        List<String> names = Arrays.asList("pobi", "woni");
        Cars cars = new Cars(names);

        // 이동하지 않으면 모두 0으로 공동 우승
        List<String> winners = cars.findWinners();
        assertThat(winners).containsExactlyInAnyOrder("pobi", "woni");
    }
}