package racinggame.view;

import nextstep.utils.Console;
import racinggame.constant.Messages;
import racinggame.model.AttemptCount;
import racinggame.model.RacingCar;
import racinggame.model.RacingCars;
import racinggame.model.Winners;

public class RacingGame implements Game {

    private final RacingCars racingCars = new RacingCars();
    private final AttemptCount attemptCount = new AttemptCount();

    @Override
    public void start() {
        initRacingCars();
        initAttemptCount();
        play();
        result();
    }

    private void result() {
        Winners winners = racingCars.getWinners();
        System.out.println(winners);
    }

    private void play() {
        System.out.println(Messages.EXECUTION_RESULT);
        for (int i = 0; i < attemptCount.getCount(); i++) {
            racingCars.racing();
            System.out.println();
        }
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
