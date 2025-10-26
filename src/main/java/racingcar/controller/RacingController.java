package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;

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
   * @param inputView 사용자 입력 담당 View
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

  }

  private RacingGame createNewGame() {

  }

  private List<Car> createCarsFromInput() {

  }

  private void ValidateCarNames(List<String> carNames) {

  }

  private int getValidTotalRounds() {

  }

  private void ValidateTotalRounds(int totalRounds) {

  }
  private void runRounds(RacingGame game, int totalRounds) {

  }

}
