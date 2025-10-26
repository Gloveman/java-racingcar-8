package racingcar.model;

import java.util.List;

/**
 * 자동차 경주 게임의 전체 로직을 관리하는 model 클래스
 *  자동차 List와 랜덤 숫자 생성기를 맴버로 가짐
 */
public class RacingGame {
  /**
   *랜덤 숫자 생성 함수형 인터페이스
   */
  @FunctionalInterface
  public interface RandomGenerator{
    int generate();
  }

  private final List<Car> cars;
  private final RandomGenerator randomGenerator;

  /**
   * 자동차 리스트와 랜덤 생성 인스턴스를 입력받아 객체 생성
   * @param cars 경주에 참여하는 자동차 목록
   * @param randomGenerator 랜덤 숫자 생성기
   */
  public RacingGame(List<Car> cars, RandomGenerator randomGenerator) {
    this.cars = cars;
    this.randomGenerator = randomGenerator;
  }

  /**
   * 각 라운드 진행
   */
  public void playRound() {

  }

  /**
   * 우승 자동차 리스트 반환
   * @return 우승 자동차들 리스트
   */
  public List<Car> getWinners() {

  }

  /**
   * 자동차 리스트 반환
   * @return 경주에 참여한 모든 자동차 리스트
   */
  public List<Car> getCars() {
    return cars;
  }
}
