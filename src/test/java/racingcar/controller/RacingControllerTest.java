package racingcar.controller;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class RacingControllerTest {

  private RacingController racingController;

  @BeforeEach
  void setup() {
    racingController = new RacingController(null, null);
  }


  @Test
  @DisplayName("validateCarNames 테스트 - 모든 이름이 알맞는 경우")
  void validateCarNames_ValidNames() {
    List<String> validNames = List.of("andy", "lee");
    assertThatNoException().isThrownBy(() -> racingController.validateCarNames(validNames));
  }

  @Test
  @DisplayName("validateCarNames 테스트 - 자동차 이름이 5자 이상인 경우")
  void validateCarNames_NameTooLong() {
    List<String> invalidNames = List.of("gloveman");
    assertThatThrownBy(() -> racingController.validateCarNames(invalidNames))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("자동차 이름은 5자 이하여야 합니다.");
  }

  @Test
  @DisplayName("validateCarNames 테스트 - 자동차 이름을 공백으로 둔 경우")
  void validateCarNames_HasEmptyName() {
    List<String> invalidNames = List.of("andy", "");
    assertThatThrownBy(() -> racingController.validateCarNames(invalidNames))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("자동차 이름은 공백일 수 없습니다.");
  }

  @Test
  @DisplayName("validateCarNames 테스트 - 아무것도 입력하지 않은 경우")
  void validateCarNames_EmptyInput() {
    List<String> invalidNames = List.of("");
    assertThatThrownBy(() -> racingController.validateCarNames(invalidNames))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("자동차 이름은 공백일 수 없습니다.");
  }

  @Test
  @DisplayName("validateCarNames 테스트 - 중복된 이름이 있는 경우")
  void validateCarNames_DupicateNames() {
    List<String> invalidNames = List.of("andy", "andy");
    assertThatThrownBy(() -> racingController.validateCarNames(invalidNames))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("자동차 이름이 중복됩니다.");
  }

  @Test
  @DisplayName("validateCarNames 테스트 - 시도 횟수가 알맞게 입력된 경우")
  void validateTotalRounds_ValidANumber() {
    String validNumber = "10";
    assertThatNoException().isThrownBy(() -> racingController.validateTotalRounds(validNumber));
  }

  @Test
  @DisplayName("validateTotalRounds 테스트 - 입력값이 숫자가 아닌 경우")
  void validateTotalRounds_NotANumber() {
    String invalidNumber = "test";
    assertThatThrownBy(() -> racingController.validateTotalRounds(invalidNumber))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("입력값이 숫자가 아니거나 정수 범위를 벗어납니다.");
  }

  @Test
  @DisplayName("validateTotalRounds 테스트 - 입력값이 정수 범위를 벗어난 경우")
  void validateTotalRounds_OutOfRange() {
    String invalidNumber = "99999999999999";
    assertThatThrownBy(() -> racingController.validateTotalRounds(invalidNumber))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("입력값이 숫자가 아니거나 정수 범위를 벗어납니다.");
  }

  @Test
  @DisplayName("validateTotalRounds 테스트 - 입력값이 0 이하인 경우")
  void validateTotalRounds_ZeroOrLess() {
    String invalidNumber = "0";
    assertThatThrownBy(() -> racingController.validateTotalRounds(invalidNumber))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("라운드 횟수는 양수여야 합니다.");
  }
}
