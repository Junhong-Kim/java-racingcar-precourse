package racinggame.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.constant.Messages;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

class RacingCarNameTest {

    @Test
    @DisplayName("자동차 이름 null 체크 테스트")
    void racingCarName_nullTest() {
        // given
        // when
        // then
        assertThatNullPointerException()
                .isThrownBy(() -> new RacingCarName(null))
                .withMessage(Messages.RACING_CAR_NAME_CAN_NOT_BE_NULL);
    }

    @Test
    @DisplayName("자동차 이름 공백 테스트")
    void racingCarName_blankTest() {
        // given
        // when
        // then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new RacingCarName(""))
                .withMessage(Messages.RACING_CAR_NAME_CAN_NOT_BE_BLANK);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "abc de"})
    @DisplayName("자동차 이름 길이 초과 테스트")
    void racingCarName_exceedTest(String name) {
        // given
        // when
        // then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new RacingCarName(name))
                .withMessageContaining(Messages.EXCEED_RACING_CAR_NAME_LENGTH);
    }
}
