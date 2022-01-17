package baseball.domain;

import java.util.List;

public class Judgement {
    public String compare(Balls computer, Balls player) {
        final List<Integer> computerNumbers = computer.getNumbers();
        final List<Integer> playerNumbers = player.getNumbers();

        // 볼의 개수
        int correctCount = correctCount(computerNumbers, playerNumbers);
        int strike = countStrike(computerNumbers, playerNumbers);
        int ball = correctCount - strike;

        if (correctCount == 0) {
            return "낫싱";
        }

        return strike + "스트라이크 " + ball + "볼";
    }

    private int correctCount(List<Integer> computer, List<Integer> player) {
        int count = 0;
        for (Integer number : player) {
            if (computer.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private int countStrike(List<Integer> computer, List<Integer> player) {
        int count = 0;
        for (int index = 0; index < player.size(); index++) {
            if(hasPlace(computer, index, player.get(index))) {
                count++;
            }
        }
        return count;
    }

    private boolean hasPlace(List<Integer> computer, int index, int number) {
        return computer.get(index) == number;
    }
}
