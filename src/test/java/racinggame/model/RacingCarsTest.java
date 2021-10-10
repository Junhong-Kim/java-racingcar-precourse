package racinggame.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.constant.Messages;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

class RacingCarsTest {

    private RacingCars racingCars;

    @BeforeEach
    void setUp() {
        racingCars = new RacingCars();
    }

    @Test
    @DisplayName("addRacingCar 테스트")
    void addRacingCar_Test() {
        // given
        RacingCar racingCar = new RacingCar("test");

        // when
        racingCars.addRacingCar(racingCar);

        // then
        assertThat(racingCars.getRacingCarList().size()).isOne();
    }

    @Test
    @DisplayName("addRacingCar null 체크 테스트")
    void addRacingCar_nullTest() {
        // given
        // when
        // then
        assertThatNullPointerException()
                .isThrownBy(() -> racingCars.addRacingCar(null))
                .withMessage(Messages.RACING_CAR_CAN_NOT_BE_NULL);
    }

    @Test
    @DisplayName("clearRacingCars 테스트")
    void clearRacingCars_test() {
        // given
        RacingCar racingCar = new RacingCar("test");

        // when
        racingCars.addRacingCar(racingCar);
        racingCars.clearRacingCars();

        // then
        assertThat(racingCars.getRacingCarList().size()).isZero();
    }
}
