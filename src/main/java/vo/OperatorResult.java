package vo;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class OperatorResult {

    private int result;
    private String rest;
    private boolean isEnd;

    public OperatorResult(int result, String rest, boolean isEnd) {
        this.result = result;
        this.rest = rest;
        this.isEnd = isEnd;
    }

    @Override
    public String toString() {
        return "OperatorResult{" +
                "result=" + result +
                ", rest='" + rest + '\'' +
                ", isEnd=" + isEnd +
                '}';
    }
}
