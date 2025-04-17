package lv1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int position = 0;
        char op = ' ';
        int a = 0;
        int b = 0;
        Scanner sc = new Scanner(System.in);
        Calculator cal = new Calculator();
        while (true) {
            int result = 0;
            if (position == 0) {
                System.out.println("첫번째 양의 정수(0 포함)를 입력해 주세요: ");
                String first = sc.nextLine();
                if (first.equals("exit"))
                    break;
                try {
                    a = Integer.parseInt(first);
                    cal.setFirst(a);
                    position = 1;
                } catch (NumberFormatException e) {
                    System.out.println("양의 정수를 입력해 주세요");
                    continue;
                }
                if (a < 0) {
                    System.out.println("양의 정수를 입력해 주세요");
                    continue;
                }
            }
            if (position == 1) {
                System.out.println("두번째 양의 정수(0 포함)를 입력해 주세요: ");
                String second = sc.nextLine();
                if(second.equals("exit"))
                    break;
                try {
                    b = Integer.parseInt(second);
                    cal.setSecond(b);
                    position = 2;
                } catch (NumberFormatException e) {
                    System.out.println("양의 정수를 입력해 주세요");
                    continue;
                }
                if (b < 0) {
                    System.out.println("양의 정수를 입력해 주세요");
                    continue;
                }
            }
            if (position == 2) {
                System.out.println("사칙연산(+, -, *, /) 중 하나를 입력해 주세요");
                String temp = sc.nextLine();
                if(temp.equals("exit"))
                    break;
                if (temp.length() != 1) {
                    System.out.println("+, -, *, / 중 하나를 입력해 주세요");
                    continue;
                }
                op = temp.charAt(0);
                cal.setOp(op);
                result = cal.calculate();

                /*
                switch (op) {
                    case '+':
                        result = a + b;
                        break;
                    case '-':
                        result = a - b;
                        break;
                    case '*':
                        result = a * b;
                        break;
                    case '/':
                        try{
                            result = a / b;
                        } catch (ArithmeticException e){
                            System.out.println("0으로는 나눌 수 없습니다");
                            position = 0;
                            continue;
                        }
                        break;
                    default:
                        System.out.println("+, -, *, / 중 하나를 입력해 주세요");
                        continue;
                }
                */
            }
            System.out.println("result = " + result);
            position = 0;
        }
        System.out.println("종료");
    }
}