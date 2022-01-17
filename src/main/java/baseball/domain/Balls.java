package baseball.domain;

import java.util.HashSet;
import java.util.List;

public class Balls {
    private static final int BALL_SIZE = 3;

    private final List<Integer> numbers;

    public Balls(List<Integer> numbers) {
        validateDuplicatedNumber(numbers);
        validateNumberRange(numbers);
        this.numbers = numbers;
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != BALL_SIZE) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 올 수 없습니다.");
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 9) {
                throw new IllegalArgumentException("[ERROR] 숫자는 1부터 9까지입니다.");
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
