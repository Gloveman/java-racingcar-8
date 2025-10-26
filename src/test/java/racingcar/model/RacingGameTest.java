package racingcar.model;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

  private Car andy;
  private Car lee;
  private List<Car> cars;

  @BeforeEach
  void setup() {
    andy = new Car("andy");
    lee = new Car("lee");
    cars = List.of(andy, lee);
  }

  @Test
  @DisplayName("Randomgenerator가 4 이상을 반환하면 차들이 전진")
  void playRound_forward() {
    RacingGame.RandomGenerator fakeRandomGenerator = () -> 5; //항상 5만 반환하는 가짜 랜덤 생성기
    RacingGame game = new RacingGame(cars, fakeRandomGenerator);

    game.playRound();

    assertThat(andy.getDistance()).isEqualTo(1);
    assertThat(lee.getDistance()).isEqualTo(1);
  }

  @Test
  @DisplayName("Randomgenerator가 4 미만을 반환하면 차들이 전진하지 않음")
  void playRound_stop() {
    RacingGame.RandomGenerator fakeRandomGenerator = () -> 3; //항상 3만 반환하는 가짜 랜덤 생성기
    RacingGame game = new RacingGame(cars, fakeRandomGenerator);

    game.playRound();

    assertThat(andy.getDistance()).isZero();
    assertThat(lee.getDistance()).isZero();
  }

  @Test
  @DisplayName("단독 우승자 상황에서 getWinners가 해당 우승자를 반환")
  void getWinners_SingleWinner() {
    //우승자가 andy이 되도록 설정
    andy.move(5);
    andy.move(5);
    lee.move(4);

    RacingGame game = new RacingGame(cars, () -> 9);

    List<Car> winners = game.getWinners();

    assertThat(winners).hasSize(1);
    assertThat(winners).containsExactly(andy);
  }

  @Test
  @DisplayName("공동 우승자 상황에서 getWinners가 모든 우승자를 반환")
  void getWinners_MultipleWinner() {
    //공동 우승이 되도록 설정
    andy.move(5);
    lee.move(4);

    RacingGame game = new RacingGame(cars, () -> 9);

    List<Car> winners = game.getWinners();

    assertThat(winners).hasSize(2);
    assertThat(winners).containsExactlyInAnyOrder(andy, lee);
  }

  @Test
  @DisplayName("getCars가 인스턴스 생성 시 전달된 리스트를 제대로 반환")
  void getCarsTest() {
    RacingGame game = new RacingGame(cars, () -> 9);

    List<Car> returnedCars = game.getCars();

    assertThat(returnedCars).isSameAs(cars);
  }
}
