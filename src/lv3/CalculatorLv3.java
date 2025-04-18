package lv3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class CalculatorLv3 {
    public enum Operator {
        ADD("+"), SUBTRACT("-"), MULTIPLY("*"), DIVIDE("/");

        private final String symbol;

        Operator(String symbol) {
            this.symbol = symbol;
        }

        public String getSymbol() {
            return this.symbol;
        }

        public static Operator getOperator(char symbol) {
            Operator result = null;
            // Operator.values() == enum Operator 요소들의 배열
            // symbol은 속성이기 때문에 여기에 포함되지 않는다
            for (Operator op : Operator.values()){
                if (op.getSymbol().charAt(0) == symbol){
                    result = op;
                    break;
                }
            }
            if(result == null) {
                // 프로그램 실행을 멈추지 않을 때
                System.out.println("Not supported operator");
                // exception을 생성할 때
                // throw new IllegalArgumentException("Not supported operator");
            }
            return result;
        }
    }

    private List<Integer> result = new ArrayList<>();
    private int index = 0;
    private int first = 0;
    private int second = 0;
    private char op = ' ';


    public int calculate() {
        switch (Operator.getOperator(this.op)) {
            case ADD:
                return calAdd(this.first, this.second);
            case SUBTRACT:
                return calSubtract(this.first, this.second);
            case MULTIPLY:
                return calMultiply(this.first, this.second);
            case DIVIDE:
                if (this.second == 0) {
                    throw new ArithmeticException();
                }
                return calDivide(this.first, this.second);
            default:
                return 0;
        }
    }

    public int calAdd(int a, int b) {
        int temp = a + b;
        result.add(temp);
        this.index++;
        return temp;
    }

    public int calSubtract(int a, int b) {
        int temp = a - b;
        result.add(temp);
        this.index++;
        return temp;
    }

    public int calMultiply(int a, int b) {
        int temp = a * b;
        result.add(temp);
        this.index++;
        return temp;
    }

    public int calDivide(int a, int b) throws ArithmeticException {
        int temp = a / b;
        result.add(temp);
        this.index++;
        return temp;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public void setOp(char op) {
        this.op = op;
    }

    public int getFirst() {
        return this.first;
    }

    public int getSecond() {
        return this.second;
    }

    public char getOp() {
        return this.op;
    }

    public int getResult() {
        return result.get(this.index - 1);
    }

    public void deleteResult() {
        result.remove(0);
        this.index--;
    }

    public void printResult() {
        System.out.println(result);
    }
}