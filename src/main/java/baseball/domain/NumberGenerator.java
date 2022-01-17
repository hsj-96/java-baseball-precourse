package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import nextstep.utils.Randoms;

public class NumberGenerator {
    public List<Integer> createRandomNumber() {
        final List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (numbers.contains(number)) {
                continue;
            }
            numbers.add(number);
        }
        return new ArrayList<>(numbers);
    }
}
