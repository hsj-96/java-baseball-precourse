package baseball;

import java.util.Arrays;
import java.util.stream.IntStream;
import nextstep.utils.*;

class Game {
    int computer[] = {0, 0, 0};
    int user[] = {0, 0, 0};
    int strike = 0;
    int ball = 0;

    // # 3자리의 중복없는 난수 생성
    void setComputerRandomNumber() {
        int freqCounter[] = new int[9];
        Arrays.fill(freqCounter, 0);

        for (int i = 0; i < 3; i++) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (freqCounter[number - 1] > 0) {
                i--;
                continue;
            }

            freqCounter[number - 1]++;
            computer[i] = number;
        }
    }

    // # 유효한 문자인지 확인
    boolean isValid(String input) {
        if (!isLengthValid(input) || !isNumber(input)) {
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

    // # 플레이어의 숫자 설정
    void setUserNumber(String numbers) {
        int[] strToNum = Arrays.stream(numbers.split("")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < 3; i++) {
            user[i] = strToNum[i];
        }
    }

    // # 사용자의 입력을 받음
    String getUserInput() {
        String input = Console.readLine();

        if (!isValid(input)) {
            throw new IllegalArgumentException("ERROR");
        }

        return input;
    }

    // # 플레이어가 입력한 숫자와 컴퓨터의 숫자를 비교하여 점수를 계산
    boolean isGameEnd() {
        for (int i = 0; i < 3; i++) {
            final int num = user[i];
            if (IntStream.of(computer).anyMatch(x -> x == num)) {
                ball++;
            }

            if (computer[i] == user[i]) {
                strike++;
                ball--;
            }
        }

        if (strike == 3) {
            System.out.println(strike + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다!");
            System.out.println("게임 끝");
            return true;
        } else if (strike > 0 && ball > 0) {
            System.out.println(strike + "스트라이크 " + ball + "볼");
        } else if (strike > 0 && ball == 0) {
            System.out.println(strike + "스트라이크");
        } else if (strike == 0 && ball > 0) {
            System.out.println(ball + "볼");
        } else {
            System.out.print("낫싱");
        }

        return false;
    }

    // # 게임 종료 후, 어떻게 할 것인지 결정
    int isGameContinue() {
        int result;

        while (true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String input = Console.readLine();

            if (!input.equals("1") && !input.equals("2")) {
                System.out.println("[ERROR] 잘못 입력 했습니다.");
                continue;
            }

            result = input.charAt(0) - '0';
            break;
        }

        return result;
    }

    // # 게임 값 초기화
    void resetGame() {
        strike = 0;
        ball = 0;
    }
}

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        game.setComputerRandomNumber();

        while (true) {
            game.resetGame();
            System.out.println("숫자를 입력해 주세요 : ");
            try {
                String userNumbers = game.getUserInput();
                game.setUserNumber(userNumbers);
            }
            catch (IllegalArgumentException e) { // NoSuchElementException은 처리하지 말았어야함 (테스트코드에서 처리 하기 때문)
                System.out.println("[ERROR] 잘못 입력 했습니다.");
                continue;
            }

            int state = 0;
            if (game.isGameEnd()) {
                state = game.isGameContinue();
            }

            if(state == 1) { // 맞추고, 새로 시작할 때
                game.setComputerRandomNumber();
            }
            else if(state == 2) { // 맞추고, 게임 종료
                break;
            }
        }

        System.out.println("게임 끝");
    }
}
