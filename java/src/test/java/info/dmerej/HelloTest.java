package info.dmerej;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class HelloTest {
    @AfterAll
    static void afterAll() {

    }

    /*@Test
    void itWorks() {
        var hello = new Hello();
        var actual = hello.getAnswer();
        assertEquals(42, actual);
        System.out.println();
        assertThat(actual).as("Should be less than 10 but was %d", actual).isEqualTo(41);
        Hello hello1 = new Hello();

    }

    @Test
    void itDoesNotWork() {
    }*/

    //WORKS
    @Test
    void test_if_the_split_works() {
        Worksshop1.initiateStack();
        Worksshop1.enterInputString("20 2 +");

        Worksshop1.splitInput();

        ArrayList<String> expectedOutput = new ArrayList<>();
        expectedOutput.add("20");
        expectedOutput.add("2");
        expectedOutput.add("+");
        assertEquals(expectedOutput,Worksshop1.tokens);
    }

    @Test
    void check_if_all_natural_numbers() {
        Worksshop1.initiateStack();
        Worksshop1.enterInputString("20 2 +");

        Worksshop1.splitInput();

        for (String str : Worksshop1.tokens) {
            try {
                int token = Integer.parseInt(str);
                assertTrue(token >= 0);
            } catch (NumberFormatException ignored) {}
        }
    }


    //DOES NOT WORK
}
