package lv3;

import java.util.*;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CalculatorLv3 cal = new CalculatorLv3();
        Number a = 0, b = 0;
        int position = 0;
        char op = ' ';
        Number result;
        Double[] std = {0.0};
        while (true) {
            // 도중에 input에 문제가 생겨도 처음으로 돌아오지 않도록
            // 각 단계별로 position값을 정해줌
            if (position == 0) {
                System.out.println("첫번째 숫자를 입력해 주세요");
                String temp1 = sc.nextLine();
                if (temp1.equals("exit")) break;
                // 정수로 받는데 실패하면 실수로 받기
                // 실수로 받기 실패하면 다시 입력
                try {
                    a = Integer.parseInt(temp1);
                    position = 1;
                } catch (NumberFormatException e1) {
                    try {
                        a = Double.parseDouble(temp1);
                        position = 1;
                    } catch (NumberFormatException e2) {
                        System.out.println("숫자를 입력해 주세요");
                        continue;
                    }
                }
            }
            if (position == 1) {
                System.out.println("두번째 숫자를 입력해 주세요");
                String temp2 = sc.nextLine();
                if (temp2.equals("exit")) break;
                try {
                    b = Integer.parseInt(temp2);
                    position = 2;
                } catch (NumberFormatException e1) {
                    try {
                        b = Double.parseDouble(temp2);
                        position = 2;
                    } catch (NumberFormatException e2) {
                        System.out.println("숫자를 입력해 주세요");
                        continue;
                    }
                }
            }
            if (position == 2) {
                System.out.println("사칙연산(+, -, *, /) 중 하나를 입력해 주세요");
                String temp3 = sc.nextLine();
                if (temp3.equals("exit")) break;
                if (temp3.length() != 1) {
                    System.out.println("+, -, *, / 중 하나를 입력해 주세요");
                    continue;
                }
                op = temp3.charAt(0);
            }
            result = cal.calculate(a, b, op);
            try {
                System.out.println("result = " + (Integer) result);
                cal.printResult();
                position = 3;
            } catch (ClassCastException e1) {
                cal.printResult();
                System.out.println("result = " + String.format("%.2f", (Double) result));
                position = 3;
            } catch (ArithmeticException e2) {
                System.out.println("0으로는 나눌 수 없습니다");
                continue;
            }
            if (position == 3) {
                System.out.println("숫자를 입력하면 더 높았던 결과를 출력합니다");
                String temp4 = sc.nextLine();
                if (temp4.equals("exit")) break;
                try {
                    std[0] = Double.parseDouble(temp4);
                    position = 4;
                } catch (NumberFormatException e2) {
                    System.out.println("숫자를 입력해 주세요");
                    continue;
                }
            }
            // cal이 원시타입(raw type)이기 때문에 num이 Object로 취급되어
            // 직접적인 형변환 후 값을 뽑아냄
            // num > std (std의 자료형이 Double일 때)와 같이 사용하면
            // 람다 표현식에 사용되는 변수는 final, 유사 final이어야 한다는 오류가 뜨는데
            // 쉽게 말해 값이 할당된 후 변경되지 않아야 한다는 의미
            // 기존은 반복문 안의 scanner로 값이 바뀌는 환경이였기 때문에 오류
            // 배열, 커스텀 래퍼 클래스로 우회 가능하다
            // (아마도) 참조형에 담아서 사용하면 주소를 지정하기 때문에
            // 주소는 그대로인 채로 값을 변경하여 사용할 수 있는 것 같다
            List<Number> resultList = (List<Number>) cal.getResultList().stream()
                    .filter(num -> ((Number) num).doubleValue() > std[0])
                    .collect(Collectors.toList());
            System.out.println(std[0] + " 보다 큰 값들은 " + resultList);

            position = 0;
        }
    }
}