package baseball.domain;

import java.util.List;

public class Judgement {
    public String compare(Balls computer, Balls player) {
        final List<Integer> computerNumbers = computer.getNumbers();
        final List<Integer> playerNumbers = player.getNumbers();

        // 볼의 개수

        // 스트라이크 개수

        // 볼의 개수 = 볼의 개수 - 스트라이크 개수

        return "1스트라이크";
    }

    private int correctCount(List<Integer> computer, List<Integer> player) {
        int count = 0;
        for (Integer number : computer) {
            computer.contains(number);
            count++;
        }
        return count;
    }
}
