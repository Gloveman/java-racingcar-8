package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.List;

import racingcar.model.Car;
import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;


/**
 * 프로그램의 전체 흐름을 조율하는 Controller 클래스
 * View로부터 입력을 받아 Model을 생성 및 조율하며
 * Model의 결과를 View에 전달하여 결과를 출력
 */
public class RacingController {
  private final InputView inputView;
  private final OutputView outputView;

  /**
   * View 인스턴스들을 입력받아 controller 생성
   *
   * @param inputView  사용자 입력 담당 View
   * @param outputView 결과 출력 담당 View
   */
  public RacingController(InputView inputView, OutputView outputView) {
    this.inputView = inputView;
    this.outputView = outputView;
  }

  /**
   * 자동차 경주 게임의 전체 흐름 실행
   * 입력 -> 게임 생성 -> 실행 -> 결과 출력을 순차적으로 수행
   */
  public void run() {
    RacingGame game = createNewGame();
    int totalRounds = getTotalRounds();

    runRounds(game, totalRounds);
    outputView.printWinners(game.getWinners());
  }

  private RacingGame createNewGame() {
    List<Car> cars = createCarsFromInput();
    return new RacingGame(cars, () -> Randoms.pickNumberInRange(0, 9));
  }

  private List<Car> createCarsFromInput() {
    List<String> carNames = inputView.readCarNames();
    validateCarNames(carNames);

    return carNames.stream()
        .map(Car::new)
        .toList();

  }

  void validateCarNames(List<String> carNames) {
    HashSet<String> uniqueNames = new HashSet<>();
    for (String carName : carNames) {
      if (carName.length() > 5) {
        throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
      }
      if (carName.isEmpty()) {
        throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
      }
      if (!uniqueNames.add(carName)) {
        //set에 이미 동일 원소가 존재하면 false를 반환하는 것을 이용
        throw new IllegalArgumentException("자동차 이름이 중복됩니다.");
      }
    }
  }

  private int getTotalRounds() {
    String totalRounds = inputView.readTotalRounds();
    validateTotalRounds(totalRounds);
    return Integer.parseInt(totalRounds);
  }

  void validateTotalRounds(String totalRounds) {
    int totalRoundsNumber;
    try {
      totalRoundsNumber = Integer.parseInt(totalRounds);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("입력값이 숫자가 아니거나 정수 범위를 벗어납니다.");
    }
    if (totalRoundsNumber < 1) {
      throw new IllegalArgumentException("라운드 횟수는 양수여야 합니다.");
    }
  }

  private void runRounds(RacingGame game, int totalRounds) {
    for (int round = 1; round <= totalRounds; round++) {
      game.playRound();
      outputView.printRondResult(game.getCars());
    }
  }

}
