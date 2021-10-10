package racinggame.view;

import nextstep.utils.Console;
import racinggame.constant.Messages;
import racinggame.model.RacingCar;
import racinggame.model.RacingCars;

public class RacingGame implements Game {

    private final RacingCars racingCars = new RacingCars();

    @Override
    public void start() {
        initRacingCars();
    }

    private void initRacingCars() {
        racingCars.clearRacingCars();
        System.out.println(Messages.READ_RACING_CARS);
        for (String name : Console.readLine().split(",")) {
            addRacingCar(name);
        }
    }

    private void addRacingCar(String name) {
        try {
            RacingCar racingCar = new RacingCar(name);
            racingCars.addRacingCar(racingCar);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            initRacingCars();
        }
    }
}
