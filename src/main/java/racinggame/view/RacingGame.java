package racinggame.view;

import nextstep.utils.Console;
import racinggame.constant.Messages;
import racinggame.model.AttemptCount;
import racinggame.model.RacingCars;

public class RacingGame implements Game {

    @Override
    public void start() {
        RacingCars racingCars = getRacingCars();
        AttemptCount attemptCount = getAttemptCount();
        racingCars.play(attemptCount);

        System.out.println(racingCars.getWinners());
    }

    private RacingCars getRacingCars() {
        RacingCars racingCars = new RacingCars();
        System.out.println(Messages.READ_RACING_CARS);
        try {
            String[] names = Console.readLine().split(",");
            racingCars.addRacingCar(names);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getRacingCars();
        }
        return racingCars;
    }

    private AttemptCount getAttemptCount() {
        AttemptCount attemptCount = new AttemptCount();
        System.out.println(Messages.READ_ATTEMPT_COUNT);
        try {
            attemptCount.setCount(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getAttemptCount();
        }
        return attemptCount;
    }
}
