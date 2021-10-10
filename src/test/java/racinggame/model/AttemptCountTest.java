package racinggame.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.constant.Messages;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class AttemptCountTest {

    private AttemptCount attemptCount;

    @BeforeEach
    void setUp() {
        attemptCount = new AttemptCount();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 100})
    @DisplayName("setCount int 성공 테스트")
    void setCount_int_successTest(int count) {
        // given
        // when
        attemptCount.setCount(count);

        // then
        assertThat(attemptCount.getCount()).isEqualTo(count);
    }

    @ParameterizedTest
    @ValueSource(ints = {-10, -1, 0})
    @DisplayName("setCount int 실패 테스트")
    void setCount_int_failureTest(int count) {
        // given
        // when
        // then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> attemptCount.setCount(count))
                .withMessage(Messages.ATTEMPT_COUNT_MUST_BE_POSITIVE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "10", "100"})
    @DisplayName("setCount 문자열 숫자 성공 테스트")
    void setCount_stringNumber_successTest(String count) {
        // given
        // when
        attemptCount.setCount(count);

        // then
        assertThat(attemptCount.getCount()).isEqualTo(Integer.parseInt(count));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-10", "-1", "0"})
    @DisplayName("setCount 문자열 숫자 실패 테스트")
    void setCount_stringNumber_failureTest(String count) {
        // given
        // when
        // then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> attemptCount.setCount(count))
                .withMessage(Messages.ATTEMPT_COUNT_MUST_BE_POSITIVE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "abc", "가나다"})
    @DisplayName("setCount 문자열 테스트")
    void setCount_string_test(String count) {
        // given
        // when
        // then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> attemptCount.setCount(count))
                .withMessage(Messages.ATTEMPT_COUNT_IS_NOT_NUMBER);
    }
}
