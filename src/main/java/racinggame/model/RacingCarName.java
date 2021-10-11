package racinggame.model;

import racinggame.constant.Messages;

public class RacingCarName {

    public static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public RacingCarName(String name) {
        if (name == null) {
            throw new NullPointerException(Messages.RACING_CAR_NAME_CAN_NOT_BE_NULL);
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException(Messages.RACING_CAR_NAME_CAN_NOT_BE_BLANK);
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format("%s(%s)", Messages.EXCEED_RACING_CAR_NAME_LENGTH, name));
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
