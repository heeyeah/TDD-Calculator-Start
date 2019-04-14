package test.unit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import parser.Parser;
import vo.OperatorTarget;

import static org.junit.Assert.*;

class ParserTest {

    //given
    private String correctInput;
    private String incorrectInput1 = "100+4+a";
    private Parser parser = Parser.getInstance();

    @BeforeEach
    void setUp() {
        correctInput = "100-90+10*5/10";
    }

    @Test
    @DisplayName("적합한 input에 대한 테스트")
    void validateNumberAndOperatorForCorrect() {
        assertTrue(parser.validateNumberAndOperator(correctInput));
    }

    @Test
    @DisplayName("부적합한 input에 대한 테스트")
    void validateNumberAndOperatorForIncorrect() {
        assertFalse(parser.validateNumberAndOperator(incorrectInput1));
    }

    @Test
    @DisplayName("입력값에서 현재 계산해야 할 대상을 반환")
    void getOperatorTarget() {

        //when
        OperatorTarget target = parser.getOperatorTarget(correctInput);

        //then
        assertEquals(100, target.getLeft());
        assertEquals(90, target.getRight());
        assertEquals('-', target.getOperator());
        assertEquals("+10*5/10", target.getRest());


        //when
        OperatorTarget target2 = parser.getOperatorTarget("30/10");
        assertEquals(30, target2.getLeft());
        assertEquals(10, target2.getRight());
        assertEquals('/', target2.getOperator());
        assertEquals("", target2.getRest());

    }


}
