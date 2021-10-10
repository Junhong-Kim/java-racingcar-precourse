package racinggame.model;

import racinggame.constant.Messages;
import racinggame.utils.StringUtils;

public class AttemptCount {

    private int count;

    public void setCount(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException(Messages.ATTEMPT_COUNT_MUST_BE_POSITIVE);
        }
        this.count = count;
    }

    public void setCount(String input) {
        if (!StringUtils.isNumber(input)) {
            throw new IllegalArgumentException(Messages.ATTEMPT_COUNT_IS_NOT_NUMBER);
        }
        setCount(Integer.parseInt(input));
    }

    public int getCount() {
        return count;
    }
}
