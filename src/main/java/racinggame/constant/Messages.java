package racinggame.constant;

import racinggame.model.RacingCar;

public class Messages {

    private Messages() {
    }

    public static final String READ_RACING_CARS = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String RACING_CAR_CAN_NOT_BE_NULL = "RacingCar는 null일 수 없습니다.";

    // ERROR
    public static final String RACING_CAR_NAME_CAN_NOT_BE_BLANK = "[ERROR] 자동차 이름은 공백일 수 없습니다.";
    public static final String EXCEED_RACING_CAR_NAME_LENGTH = String.format(
            "[ERROR] 자동차 이름은 %d자 이하만 가능합니다.", RacingCar.MAX_NAME_LENGTH);
}
