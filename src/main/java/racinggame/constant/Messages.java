package racinggame.constant;

import racinggame.model.RacingCar;

public class Messages {

    private Messages() {
    }

    public static final String READ_RACING_CARS = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String READ_ATTEMPT_COUNT = "시도할 회수는 몇회인가요?";
    public static final String RACING_CAR_CAN_NOT_BE_NULL = "RacingCar는 null일 수 없습니다.";
    public static final String EXECUTION_RESULT = String.format("%s%s", System.lineSeparator(), "실행 결과");

    // ERROR
    public static final String RACING_CAR_NAME_CAN_NOT_BE_BLANK = "[ERROR] 자동차 이름은 공백일 수 없습니다.";
    public static final String EXCEED_RACING_CAR_NAME_LENGTH = String.format(
            "[ERROR] 자동차 이름은 %d자 이하만 가능합니다.", RacingCar.MAX_NAME_LENGTH);
    public static final String ATTEMPT_COUNT_MUST_BE_POSITIVE = "[ERROR] 시도할 회수는 1이상 이어야합니다.";
    public static final String ATTEMPT_COUNT_IS_NOT_NUMBER = "[ERROR] 시도할 회수가 숫자가 아닙니다.";

    public static String getRacingGameResult(String winners) {
        return String.format("최종 우승자는 %s 입니다.", winners);
    }
}
