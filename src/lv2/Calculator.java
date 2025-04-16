package lv2;

public class Calculator {
    private int[] result = new int[30];
    int index = 0;
    int first = 0;
    int second = 0;
    char op = ' ';


    public int calculate() {
        System.out.println(this.op);
        switch (this.op) {
            case '+':
                return add(this.first, this.second);
            case '-':
                return subtract(this.first, this.second);
            case '*':
                return multiply(this.first, this.second);
            case '/':
                return divide(this.first, this.second);
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
}
