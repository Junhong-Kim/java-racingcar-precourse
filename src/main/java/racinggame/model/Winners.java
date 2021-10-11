package racinggame.model;

import racinggame.constant.Messages;

import java.util.ArrayList;
import java.util.List;

public class Winners {

    private final List<RacingCar> winnerList = new ArrayList<>();

    private final int winnerPosition;

    public Winners(int winnerPosition) {
        this.winnerPosition = winnerPosition;
    }

    public void addWinner(RacingCar racingCar) {
        if (racingCar.isWinner(winnerPosition)) {
            winnerList.add(racingCar);
        }
    }

    @Override
    public String toString() {
        List<String> winnerNameList = new ArrayList<>();
        for (RacingCar racingCar : winnerList) {
            winnerNameList.add(racingCar.getRacingCarName().getName());
        }
        return Messages.getRacingGameResult(String.join(",", winnerNameList));
    }
}
