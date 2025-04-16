package lv2;

public class Calculator {
    private int resultLength = 2;
    private int[] result = new int[resultLength];
    private int index = 0;
    private int first = 0;
    private int second = 0;
    private char op = ' ';


    public int calculate() {
        switch (this.op) {
            case '+':
                return add(this.first, this.second);
            case '-':
                return subtract(this.first, this.second);
            case '*':
                return multiply(this.first, this.second);
            case '/':
                if (this.second == 0) {
                    throw new ArithmeticException();
                }
                return divide(this.first, this.second);
            default:
                return 0;
        }
    }

    public int add(int a, int b) {
        int temp = a + b;
        this.result[this.index] = temp;
        this.index++;
        return temp;
    }

    public int subtract(int a, int b) {
        int temp = a - b;
        this.result[this.index] = temp;
        this.index++;
        return temp;
    }

    public int multiply(int a, int b) {
        int temp = a * b;
        this.result[this.index] = temp;
        this.index++;
        return temp;
    }

    public int divide(int a, int b) throws ArithmeticException {
        int temp = a / b;
        this.result[this.index] = temp;
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

    public int getFirst(int first) {
        return this.first;
    }

    public int getSecond(int second) {
        return this.second;
    }

    public char getOp() {
        return this.op;
    }

    public void dequeue() {
        for (int i = 0; i < this.resultLength - 1; i++) {
            this.result[i] = this.result[i + 1];
        }
        this.index--;
    }
}
