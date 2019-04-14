package vo;


import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class OperatorTarget {

    private int left;
    private int right;
    private char operator;
    private String rest;

    public OperatorTarget(int left, int right, char operator, String rest) {
        this.left = left;
        this.right = right;
        this.operator = operator;
        this.rest = rest;
    }
}
