package test.unit;

import operator.Operator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import vo.OperatorResult;

import static org.junit.Assert.*;

@DisplayName("연산자 테스트")
class OperatorTest {

    private static int i, j;
    private Operator operator = Operator.getInstance();

    @BeforeAll
    static void setTestParameter() {

        //given
        i = 10;
        j = 5;
    }

    @Test
    @DisplayName("더하기 연산")
    void operatePlus() {

        //when
        int result = operator.calculateOnce('+', i, j);

        //then
        assertEquals(15, result);
    }

    @Test
    @DisplayName("빼기 연산")
    void operateMinus() {

        //when
        int result = operator.calculateOnce('-', i, j);

        //then
        assertEquals(5, result);
    }

    @Test
    @DisplayName("곱하기 연산")
    void operateMultiple() {

        //when
        int result = operator.calculateOnce('*', i, j);

        //then
        assertEquals(50, result);
    }

    @Test
    @DisplayName("나누기 연산")
    void operateDivide() {

        //when
        int result = operator.calculateOnce('/', i, j);

        //then
        assertEquals(2, result);
    }

    @Test
    @DisplayName("전체 연산")
    void calculateAll() {

        //given
        String input = "12+15+3/10";

        //when
        int result = operator.calculateAll(input);

        //then
        assertEquals(3, result);
    }

    @Test
    @DisplayName("중간연산 - 연산이 남아 있음")
    void operateIntermediate() {

        //given
        String input = "12+15+3/10";

        //when
        OperatorResult result = operator.calculateIntermediate(input);

        //then
        assertEquals(27, result.getResult());
        assertEquals("27+3/10", result.getRest());
        assertFalse(result.isEnd());
    }

    @Test
    @DisplayName("중간연산 - 연산 종료")
    void operateIntermediate2() {

        //given
        String input = "30/10";

        //when
        OperatorResult result = operator.calculateIntermediate(input);

        //then
        assertEquals(3, result.getResult());
        assertEquals("", result.getRest());
        assertTrue(result.isEnd());
    }
}