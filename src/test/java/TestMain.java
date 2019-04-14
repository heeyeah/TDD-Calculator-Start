import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

@DisplayName("Practice for writing TEST CODE :)")
class TestMain {


    @Test
    @DisplayName("Convert char to int")
    void convertCharToInt() {

        //given
        char c = '3';

        //when
        int i = c - '0';

        //then
        assertEquals(3, i);
    }

}
