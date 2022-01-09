package baseball;

import java.util.Arrays;
import nextstep.utils.*;

public class Application {
    // # 숫자 중복 체크
    boolean isDuplicated(int[] numbers) {
        int freqCounter[] = new int[9];
        Arrays.fill(freqCounter, 0);

        for (int i = 0; i < 3; i++) {
            int number = numbers[i];
            if (freqCounter[number - 1] > 0) {
                return true;
            }

            freqCounter[number - 1]++;
        }

        return false;
    }

    public static void main(String[] args) {
    }
}
