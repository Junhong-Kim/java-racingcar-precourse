package racinggame.view;

import nextstep.utils.Console;
import racinggame.constant.Messages;
import racinggame.model.AttemptCount;
import racinggame.model.RacingCar;
import racinggame.model.RacingCars;

public class RacingGame implements Game {

    private final RacingCars racingCars = new RacingCars();
    private final AttemptCount attemptCount = new AttemptCount();

    @Override
    public void start() {
        initRacingCars();
        initAttemptCount();
        play();
    }

    private void play() {
        System.out.println(Messages.EXECUTION_RESULT);
        for (int i = 0; i < attemptCount.getCount(); i++) {
            racing();
        }
    }

    private void racing() {
        for (RacingCar racingCar : racingCars.getRacingCarList()) {
            racingCar.play();
            System.out.println(racingCar);
        }
        System.out.println();
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

    private void initAttemptCount() {
        try {
            System.out.println(Messages.READ_ATTEMPT_COUNT);
            attemptCount.setCount(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            initAttemptCount();
        }
    }
}
