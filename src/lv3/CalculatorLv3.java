package lv3;

import java.util.ArrayList;
import java.util.List;

// 제너릭 사용(숫자만) -> 클래스 제너릭 제거
public class CalculatorLv3 {
    private List<Number> result = new ArrayList<>();
    private int index = 0;
    private int resultCount = 100;
    private enum Operator {
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
            for (Operator op : Operator.values()) {
                if (op.getSymbol().charAt(0) == symbol) {
                    result = op;
                    break;
                }
            }
            if (result == null) {
                // 프로그램 실행을 멈추지 않을 때
                System.out.println("Not supported operator");
                // exception을 생성할 때
                // throw new IllegalArgumentException("Not supported operator");
            }
            return result;
        }
    }

    public <T extends Number, S extends Number> Number calculate(T first, S second, char op) {
        Number ret;
        switch (Operator.getOperator(op)) {
            case ADD:
                ret = calAdd(first, second);
                return ret;
            case SUBTRACT:
                ret = calSubtract(first, second);
                return ret;
            case MULTIPLY:
                ret = calMultiply(first, second);
                return ret;
            case DIVIDE:
                calDivide(first, second);
            default:
                return 0;
        }
    }

    private Number calAdd(Number first, Number second) {
        Number ret;
        if (first instanceof Integer && second instanceof Integer) {
            ret = first.intValue() + second.intValue();
            result.add((Integer) ret);
        } else {
            ret = first.doubleValue() + second.doubleValue();
            result.add((Double) ret);
        }
        this.index++;
        return ret;
    }

    private Number calSubtract(Number first, Number second) {
        Number ret;
        if (first instanceof Integer && second instanceof Integer) {
            ret = first.intValue() - second.intValue();
            result.add(ret.intValue());
        } else {
            ret = first.doubleValue() - second.doubleValue();
            result.add(ret.doubleValue());
        }
        this.index++;
        return ret;
    }

    private Number calMultiply(Number first, Number second) {
        Number ret;
        if (first instanceof Integer && second instanceof Integer) {
            ret = first.intValue() * second.intValue();
            result.add(ret.intValue());
        } else {
            ret = first.doubleValue() * second.doubleValue();
            result.add(ret.doubleValue());
        }
        this.index++;
        return ret;
    }

    private Number calDivide(Number first, Number second) {
        Number ret;
        /* 0으로 나누면 예외처리
                if (second.intValue() == 0) {
                    throw new ArithmeticException();
                }
                ret = first.doubleValue() / second.doubleValue();
                result.add(ret.doubleValue());
                this.index++;
                return ret;*/
        // 예외처리 없이 코드 진행
        if (first instanceof Integer && second instanceof Integer) {
            try{
                ret = first.intValue() / second.intValue();
                result.add(ret.doubleValue());
                this.index++;
                return ret;
            } catch (ArithmeticException e) {
                System.out.println("divided by zero(Integer)");
                return null;
            }
        }
        // Double이 들어간 나눗셈에서 0으로 나누면 exception 대신
        // Infinity, Nan이 결과로 나오기 때문에 따로 처리
        else {
            ret = first.doubleValue() / second.doubleValue();
            if(Double.isInfinite(ret.doubleValue()) || Double.isNaN(ret.doubleValue())) {
                System.out.println("divided by zero(Double)");
                return null;
            }
            return ret;
        }
    }

    // 개수는 main에서도 수정 가능
    public void setResultCount(int resultCount) {
        this.resultCount = resultCount;
    }

    // 가장 최근의 결과값 리턴
    public Number getResult() {
        return result.get(this.index - 1);
    }

    // 가장 오래된 결과값 제거
    // result.size() 로 최대 개수 정하기
    public void deleteResult() {
        if (result.size() < resultCount) {
            System.out.println("Result is empty");
        } else {
            result.remove(0);
            this.index--;
        }
    }

    // 결과값 전체 리턴
    public List<Number> getResultList() {
        return this.result;
    }

    // 결과값 전체 출력
    public void printResult() {
        System.out.println(result);
    }
}