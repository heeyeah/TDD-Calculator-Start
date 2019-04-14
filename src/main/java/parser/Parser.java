package parser;

import vo.OperatorTarget;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Parser {

    private static final Set<Character> operatorSet = Stream.of('+', '-', '*', '/').collect(Collectors.toSet());

    private static Parser parser;

    private Parser() {
    }

    public static Parser getInstance() {

        if (parser == null) {
            parser = new Parser();
        }
        return parser;
    }

    public boolean validateNumberAndOperator(String input) {

        for (char c : input.toCharArray()) {

            if (!operatorSet.contains(c) && !('0' <= c && c <= '9')) {
                return false;
            }

        }

        return true;
    }

    private boolean isOperator(char c) {
        return operatorSet.contains(c);
    }


    public OperatorTarget getOperatorTarget(String input) {

        boolean flag = false;
        char[] array = input.toCharArray();


        char operator = 0;
        int restIndex = -1;
        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder();

        for (int i = 0; i < array.length; i++) {

            char c = array[i];

            if (isOperator(c)) {

                if (operator == 0) {
                    operator = c;
                    flag = true;
                } else {
                    restIndex = i;
                    break;
                }
            } else {

                if (flag) {
                    right.append(c);
                } else {
                    left.append(c);
                }
            }
        }


        String rest = (restIndex == -1) ? "" : input.substring(restIndex);

        return new OperatorTarget(Integer.parseInt(left.toString()), Integer.parseInt(right.toString()), operator, rest);
    }
}
