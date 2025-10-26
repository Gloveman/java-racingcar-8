package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

  @Test
  @DisplayName("자동차 인스턴스 생성 시 이름과 초기 거리가 올바르게 설정된다")
  void constructor_Test() {
    String carName = "Andy";

    Car car = new Car(carName);

    assertThat(car.getName()).isEqualTo(carName);
    assertThat(car.getDistance()).isZero();
  }

  @Test
  @DisplayName("move 메서드에서 randomnumber가 4 이상일때 전진한다")
  void move_Forward_Test() {
    Car car = new Car("Andy");

    car.move(4);
    car.move(8);

    assertThat(car.getDistance()).isEqualTo(2);
  }

  @Test
  @DisplayName("move 메서드에서 randomnumber가 4 미만일때 움직이지 않는다")
  void move_Stop_Test() {
    Car car = new Car("Andy");

    car.move(3);
    car.move(2);
    car.move(1);
    car.move(0);

    assertThat(car.getDistance()).isZero();
  }
}
