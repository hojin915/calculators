package lv3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CalculatorLv3 cal = new CalculatorLv3();
        int a = 0, b = 0;
        int position = 0;
        char op = ' ';
        int result;
        while (true) {
            if (position == 0) {
                System.out.println("첫번째 0 이상의 정수를 입력해 주세요");
                String temp1 = sc.nextLine();
                if(temp1.equals("exit")) break;
                try {
                    a = Integer.parseInt(temp1);
                    cal.setFirst(a);
                    position = 1;
                } catch (NumberFormatException e) {
                    System.out.println("0 이상의 정수를 입력해 주세요");
                    continue;
                }
            }
            if( position == 1) {
                System.out.println("두번째 0 이상의 정수를 입력해 주세요");
                String temp2 = sc.nextLine();
                if(temp2.equals("exit")) break;
                try {
                    b = Integer.parseInt(temp2);
                    cal.setSecond(b);
                    position = 2;
                } catch (NumberFormatException e) {
                    System.out.println("0 이상의 정수를 입력해 주세요");
                    continue;
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
                System.out.println("result = " + result);
            } catch (ArithmeticException e) {
                System.out.println("0으로는 나눌 수 없습니다");
            }
            position = 0;
        }
    }
}