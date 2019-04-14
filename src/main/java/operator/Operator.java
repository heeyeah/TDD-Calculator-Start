package operator;

import parser.Parser;
import vo.OperatorResult;
import vo.OperatorTarget;

public class Operator {

    private static Operator operator;
    private static Parser parser;

    private Operator() {
        parser = Parser.getInstance();
    }

    public static Operator getInstance() {
        if (operator == null) {
            operator = new Operator();
        }
        return operator;
    }

    public OperatorResult calculateIntermediate(String input) {

        OperatorTarget target = parser.getOperatorTarget(input);

        int result = this.calculateOnce(target.getOperator(), target.getLeft(), target.getRight());
        String rest = "";
        boolean isEnd;

        if (target.getRest() == null || "".equals(target.getRest())) {
            isEnd = true;
        } else {
            rest = result + target.getRest();
            isEnd = false;
        }

        return new OperatorResult(result, rest, isEnd);
    }

    public int calculateAll(String input) {

        OperatorResult result;

        do {
            result = calculateIntermediate(input);
            input = result.getRest();
        } while (!result.isEnd());

        return result.getResult();
    }


    public int calculateOnce(char operator, int i, int j) {

        int result = 0;


        switch (operator) {

            case '+':
                result = plus(i, j);
                break;
            case '-':
                result = minus(i, j);
                break;
            case '*':
                result = multiple(i, j);
                break;
            case '/':
                result = divide(i, j);
                break;
        }


        return result;
    }

    private int divide(int i, int j) {
        return i / j;
    }

    private int multiple(int i, int j) {
        return i * j;
    }

    private int minus(int i, int j) {
        return i - j;
    }

    private int plus(int i, int j) {
        return i + j;
    }

}
