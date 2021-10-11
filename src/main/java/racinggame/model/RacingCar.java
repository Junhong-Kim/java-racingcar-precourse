package racinggame.model;

import nextstep.utils.Randoms;
import racinggame.constant.Messages;

public class RacingCar implements Comparable<RacingCar> {

    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MOVE_CONDITION_NUMBER = 4;
    private static final String MOVE_SIGN = "-";

    private final RacingCarName racingCarName;

    private int position = 0;

    public RacingCar(String name) {
        if (name == null) {
            throw new NullPointerException(Messages.RACING_CAR_NAME_CAN_NOT_BE_NULL);
        }
        racingCarName = new RacingCarName(name.trim());
    }

    public RacingCarName getRacingCarName() {
        return racingCarName;
    }

    public int getPosition() {
        return position;
    }

    public void play() {
        int pickedNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
        if (pickedNumber >= MOVE_CONDITION_NUMBER) {
            position++;
        }
        System.out.println(this);
    }

    public boolean isWinner(int winnerPosition) {
        return position == winnerPosition;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            stringBuilder.append(MOVE_SIGN);
        }
        return String.format("%s : %s", racingCarName.getName(), stringBuilder);
    }

    @Override
    public int compareTo(RacingCar o) {
        return Integer.compare(this.position, o.position);
    }
}
