package racinggame.model;

import nextstep.utils.Randoms;
import racinggame.constant.Messages;

public class RacingCar {

    public static final int MAX_NAME_LENGTH = 5;
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MOVE_CONDITION_NUMBER = 4;
    private static final String MOVE_SIGN = "-";

    private final String name;

    private int position = 0;

    public RacingCar(String name) {
        String trimName = name.trim();

        if (trimName.isEmpty())
            throw new IllegalArgumentException(Messages.RACING_CAR_NAME_CAN_NOT_BE_BLANK);

        if (trimName.length() > MAX_NAME_LENGTH)
            throw new IllegalArgumentException(String.format(
                    "%s(%s)", Messages.EXCEED_RACING_CAR_NAME_LENGTH, trimName));

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void play() {
        int pickedNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
        if (pickedNumber >= MOVE_CONDITION_NUMBER) {
            position++;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            stringBuilder.append(MOVE_SIGN);
        }
        return String.format("%s : %s", name, stringBuilder);
    }
}
