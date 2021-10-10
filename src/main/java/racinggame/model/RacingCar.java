package racinggame.model;

import racinggame.constant.Messages;

public class RacingCar {

    public static final int MAX_NAME_LENGTH = 5;

    private final String name;

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
}
