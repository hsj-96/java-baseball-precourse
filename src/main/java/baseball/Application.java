package baseball;

import baseball.domain.Balls;
import baseball.domain.Judgement;
import baseball.domain.NumberGenerator;
import java.util.Arrays;
import java.util.List;

/**
 * 객체 지향 프로그래밍
 * 1. 기능(메서드)을 가지고 있는 클래스를 인스턴스(객체)화한다.
 * 2. 필요한 기능을 가지고 있는 인스턴스의 메서드를 호출한다.
 * 3. 호출한 결과를 조합(협력)한다.
 */

public class Application {
    public static void main(String[] args) {
        NumberGenerator generator = new NumberGenerator();
        final List<Integer> numbers = generator.createRandomNumber();
        System.out.println(numbers);

        Balls balls = new Balls(numbers);
    }
}