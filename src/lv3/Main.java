package lv3;

import java.util.IllegalFormatConversionException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CalculatorLv3 cal = new CalculatorLv3();
        Number a, b;
        int position = 0;
        char op = ' ';
        Number result;
        while (true) {
            if (position == 0) {
                System.out.println("첫번째 숫자를 입력해 주세요");
                String temp1 = sc.nextLine();
                if(temp1.equals("exit")) break;
                // 정수로 받는데 실패하면 실수로 받기
                // 실수로 받기 실패하면 다시 입력
                try {
                    a = Integer.parseInt(temp1);
                    cal.setFirst(a);
                    position = 1;
                } catch (NumberFormatException e1) {
                    try{
                        a = Double.parseDouble(temp1);
                        cal.setFirst(a);
                        position = 1;
                    } catch (NumberFormatException e2) {
                        System.out.println("숫자를 입력해 주세요");
                        continue;
                    }
                }
            }
            if( position == 1) {
                System.out.println("두번째 숫자를 입력해 주세요");
                String temp2 = sc.nextLine();
                if(temp2.equals("exit")) break;
                try {
                    b = Integer.parseInt(temp2);
                    cal.setSecond(b);
                    position = 2;
                } catch (NumberFormatException e1) {
                    try{
                        b = Double.parseDouble(temp2);
                        cal.setSecond(b);
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
                if(temp3.equals("exit")) break;
                if(temp3.length() != 1) {
                    System.out.println("+, -, *, / 중 하나를 입력해 주세요");
                    continue;
                }
                op = temp3.charAt(0);
                cal.setOp(op);
            }
            try {
                result = cal.calculate();
                System.out.println("result = " + (Integer) result);
            } catch (ClassCastException e1) {
                result = cal.calculate();
                System.out.println("result = " + String.format("%.2f", (Double) result));
            } catch (ArithmeticException e2) {
                System.out.println("0으로는 나눌 수 없습니다");
            }
            position = 0;
        }
    }
}