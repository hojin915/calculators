package lv2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private List<Integer> result = new ArrayList<>();
    private int index = 0;
    private int first = 0;
    private int second = 0;
    private char op = ' ';


    public int calculate() {
        switch (this.op) {
            case '+':
                return calAdd(this.first, this.second);
            case '-':
                return calSubtract(this.first, this.second);
            case '*':
                return calMultiply(this.first, this.second);
            case '/':
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
