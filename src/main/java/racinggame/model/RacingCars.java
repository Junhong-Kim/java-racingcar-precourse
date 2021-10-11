package racinggame.model;

import racinggame.constant.Messages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingCars {

    private final List<RacingCar> racingCarList = new ArrayList<>();

    public List<RacingCar> getRacingCarList() {
        return racingCarList;
    }

    public void clearRacingCars() {
        if (!racingCarList.isEmpty()) {
            racingCarList.clear();
        }
    }

    public void racing() {
        for (RacingCar racingCar : racingCarList) {
            racingCar.play();
        }
    }

    public void addRacingCar(RacingCar racingCar) {
        if (racingCar == null) {
            throw new NullPointerException(Messages.RACING_CAR_CAN_NOT_BE_NULL);
        }
        racingCarList.add(racingCar);
    }

    public Winners getWinners() {
        Winners winners = new Winners(Collections.max(racingCarList).getPosition());
        for (RacingCar racingCar : racingCarList) {
            winners.addWinner(racingCar);
        }
        return winners;
    }
}
