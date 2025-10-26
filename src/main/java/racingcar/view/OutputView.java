package racingcar.view;

import racingcar.model.Car;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 프로그램의 모든 콘솔 출력을 담당하는 View
 *
 */
public class OutputView {
  /**
   * 현재 차수의 각 자동차별 이동 거리를 출력
   * 출력 포맷: 이동 거리가 2라고 할 때 name : -- 의 형식
   * @param cars 현재 경주에 참여한 자동차 리스트
   */
  public void printRondResult(List<Car> cars) {
    for (Car car : cars) {
      String distanceString="-".repeat(car.getDistance());
      System.out.println(car.getName() + " : " + distanceString);
    }
    System.out.println();
  }

  /**
   * 최종 우승 자동차 이름 출력
   * 여러 대인 경우 쉼표로 구분하여 출력
   * @param winners 최종 우승한 자동차 리스트
   */
  public void printWinners(List<Car> winners) {
    String winnerNames=winners.stream()
        .map(Car::getName)
        .collect(Collectors.joining(", "));
    System.out.println("최종 우승자 : " + winnerNames);
  }
}
