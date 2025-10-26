package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자 입력을 담당하는 View 클래스
 * 경주에 참여하는 자동차 이름들과 시도 횟수를 입력받음
 */
public class InputView {
  /**
   * 자동차 목록을 입력받는 View
   * 사용자에게 자동차 이름 입력을 요청하고
   * 쉼표 기준으로 분리한 뒤 리스트로 반환
   *
   * @return 자동차 이름 리스트
   */
  public List<String> readCarNames() {
    System.out.println("경주에 참여하는 자동차들 이름을 입력하세요.(쉼표로 구분)");
    String input = Console.readLine();

    return Arrays.stream(input.split(","))
        .map(String::trim)
        .collect(Collectors.toList());
  }

  /**
   * 시도 횟수를 입력받는 View
   * 사용자에게 시도 횟수를 입력받아 정수로 변환하여 반환
   *
   * @return 시도 횟수
   */
  public String readTotalRounds() {
    System.out.println("시도할 횟수는 몇 회인가요?");
    return Console.readLine();
  }
}
