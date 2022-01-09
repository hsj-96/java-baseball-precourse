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

    // # 유효한 문자인지 확인
    boolean isValid(String input) {
        if (!isNumber(input) || !isLengthValid(input)) {
            return false;
        }

        int[] strToNum = Arrays.stream(input.split("")).mapToInt(Integer::parseInt).toArray();
        if (isDuplicated(strToNum)) {
            return false;
        }

        return true;
    }

    // # 입력한 문자가 숫자인지 확인
    boolean isNumber(String input) {
        for (int i = 0; i < 3; i++) {
            if (!Character.isDigit(input.charAt(i)) || input.charAt(i) == '0') {
                return false;
            }
        }

        return true;
    }

    // # 입력한 글자의 수가 3개인지 확인
    boolean isLengthValid(String input) {
        if (input.length() != 3) {
            return false;
        }

        return true;
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

    // # 사용자의 입력을 받음
    String getUserInput() throws Exception {
        String input = Console.readLine();

        if (!isValid(input)) {
            throw new Exception("ERROR");
        }

        return input;
    }
    
    public static void main(String[] args) {
    }
}
