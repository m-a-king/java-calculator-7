package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.math.BigDecimal;
import java.util.NoSuchElementException;

public class IOService {

    public String getInput() {
        try {
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String input = getSafeInput();

            validateInput(input);

            return input;
        } finally {
            Console.close();
        }
    }

    private String getSafeInput() {
        try {
            return Console.readLine();
        } catch (NoSuchElementException e) {
            return ""; // 빈 문자열로 처리
        }
    }

    private void validateInput(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException("공백을 입력할 수 없습니다.");
        }
    }

    public void printResult(String result) {
        System.out.println("결과 : " + result);
    }
}