package lv3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

// 제너릭 사용(숫자만)
public class CalculatorLv3 <T extends Number, S extends Number> {
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

    private List<Number> result = new ArrayList<>();
    private int index = 0;
    private T first;
    private S second;
    private char op = ' ';

    public Number calculate() {
        switch (Operator.getOperator(this.op)) {
            case ADD:
                return calAdd(this.first, this.second);
            case SUBTRACT:
                return calSubtract(this.first, this.second);
            case MULTIPLY:
                return calMultiply(this.first, this.second);
            case DIVIDE:
                if (this.second.intValue() == 0) {
                    throw new ArithmeticException();
                }
                return calDivide(this.first, this.second);
            default:
                return 0;
        }
    }

    public Number calAdd(T a, S b) {
        Number ret;
        if(a instanceof Integer && b instanceof Integer) {
            ret = a.intValue() + b.intValue();
            result.add(ret.intValue());
        }
        else {
            ret = a.doubleValue() + b.doubleValue();
            result.add(ret.doubleValue());
        }
        this.index++;
        return ret;
    }

    public Number calSubtract(T a, S b) {
        Number ret;
        if(a instanceof Integer && b instanceof Integer) {
            ret = a.intValue() - b.intValue();
            result.add(ret.intValue());
        }
        else {
            ret = a.doubleValue() - b.doubleValue();
            result.add(ret.doubleValue());
        }
        this.index++;
        return ret;
    }

    public Number calMultiply(T a, S b) {
        Number ret;
        if(a instanceof Integer && b instanceof Integer) {
            ret = a.intValue() * b.intValue();
            result.add(ret.intValue());
        }
        else {
            ret = a.doubleValue() * b.doubleValue();
            result.add(ret.doubleValue());
        }
        this.index++;
        return ret;
    }

    public Number calDivide(T a, S b) throws ArithmeticException {
        Number ret;
        ret = a.doubleValue() / b.doubleValue();
        result.add(ret.doubleValue());
        this.index++;
        return ret;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(S second) {
        this.second = second;
    }

    public void setOp(char op) {
        this.op = op;
    }

    public T getFirst() {
        return this.first;
    }

    public S getSecond() {
        return this.second;
    }

    public char getOp() {
        return this.op;
    }

    public Number getResult() {
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