package racingcar.model;

/**
 *경주에 참여하는 자동차의 상태와 로직을 관리하는 model 클래스
 * 자동차 이름과 현재 이동 거리를 맴버로 가짐
 */
public class Car {
  private final String name;
  private int distance;

  /**
   *자동차 이름을 받아 객체 생성
   * 초기 이동 거리는 0으로 설정
   *
   * @param name 자동차 이름
   */
  public Car(String name) {
    this.name = name;
    this.distance = 0;
  }

  /**
   * 자동차 이름 반환
   *
   * @return 자동차 이름
   */
  public String getName() {
    return name;
  }

  /**
   * 현재 이동 거리 반환
   *
   * @return 현재 이동 거리
   */
  public int getDistance() {
    return distance;
  }

  /**
   * 0~9 사이의 랜덤값을 받아 이동 여부를 결정
   * 숫자가 4 이상인 경우에만 1칸 전진
   *
   * @param randomNumber RandomGenerator로 생성된 랜덤값
   */
  void move(int randomNumber) {

  }
}
