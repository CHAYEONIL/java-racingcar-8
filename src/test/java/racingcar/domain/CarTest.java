package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("자동차 생성 시 이름과 초기 위치(0)를 가진다")
    void createCar() {
        Car car = new Car("pobi");

        assertThat(car.getName()).isEqualTo("pobi");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @RepeatedTest(10)
    @DisplayName("자동차는 전진하거나 정지한다")
    void moveCar() {
        Car car = new Car("pobi");
        int initialPosition = car.getPosition();

        car.move();

        assertThat(car.getPosition()).isIn(initialPosition, initialPosition + 1);
    }

    @Test
    @DisplayName("여러 번 이동 시도 시 위치가 변경된다")
    void moveMultipleTimes() {
        Car car = new Car("pobi");
        int initialPosition = car.getPosition();

        for (int i = 0; i < 10; i++) {
            car.move();
        }

        assertThat(car.getPosition()).isGreaterThanOrEqualTo(initialPosition);
    }
}