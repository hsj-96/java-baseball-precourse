package baseball;

import java.util.Arrays;
import nextstep.utils.*;

public class Application {
    int computer[] = {0, 0, 0};
    int user[] = {0, 0, 0};

    // # 3자리의 중복없는 난수 생성
    void setComputerRandomNumber() {
        for (int i = 0; i < 3; i++) {
            int number = Randoms.pickNumberInRange(1, 9);
            computer[i] = number;
        }

        if (isDuplicated(computer)) {
            setComputerRandomNumber();
        }
    }

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
