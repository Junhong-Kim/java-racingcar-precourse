package racinggame.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.constant.Messages;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RacingCarTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "abcde", "abcde", " abcde", "abcde ", " abcde "})
    @DisplayName("인스턴스 생성 성공 테스트")
    void racingCar_constructor_successTest(String name) {
        // given
        // when
        // then
        assertThat(new RacingCar(name)).isInstanceOf(RacingCar.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("자동차 이름 공백 테스트")
    void racingCar_blankName_test(String name) {
        // given
        // when
        // then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new RacingCar(name))
                .withMessage(Messages.RACING_CAR_NAME_CAN_NOT_BE_BLANK);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "abc de"})
    @DisplayName("자동차 이름 길이 초과 테스트")
    void racingCar_exceedName_test(String name) {
        // given
        // when
        // then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new RacingCar(name))
                .withMessageContaining(Messages.EXCEED_RACING_CAR_NAME_LENGTH);
    }

    @Test
    @DisplayName("isWinner true 테스트")
    void racingCar_isWinner_trueTest() {
        // given
        RacingCar racingCar = new RacingCar("test");
        int winnerPosition = 0;

        // when
        // then
        assertThat(racingCar.isWinner(winnerPosition)).isTrue();
    }

    @Test
    @DisplayName("isWinner false 테스트")
    void racingCar_isWinner_falseTest() {
        // given
        RacingCar racingCar = new RacingCar("test");
        int winnerPosition = 1;

        // when
        // then
        assertThat(racingCar.isWinner(winnerPosition)).isFalse();
    }
}
