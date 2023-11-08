package info.dmerej;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


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
    private static void initiateTest1() {
        Worksshop1.initiateStack();
        Worksshop1.enterInputString("20 2 +");

        Worksshop1.splitInput();
    }
    private static void initiateTest2() {
        Worksshop1.initiateStack();
        Worksshop1.enterInputString("20 2 + 3 + sqrt 2 * 5 2 max");

        Worksshop1.splitInput();
    }


    @Test
    void test_if_the_split_works() {
        initiateTest2();

        List<String> expectedOutput = new ArrayList<>(Arrays.asList("20", "2", "+", "3", "+", "sqrt", "2", "*", "5", "2", "max"));
        assertEquals(expectedOutput,Worksshop1.tokens);
    }

    @Test
    void check_if_all_natural_numbers() {
        initiateTest1();

        for (String str : Worksshop1.tokens) {
            try {
                int token = Integer.parseInt(str);
                assertTrue(token >= 0);
            } catch (NumberFormatException ignored) {}
        }
    }

    @Test
    void all_tokens_separated_by_one_space() {
        initiateTest1();

        for (String str : Worksshop1.tokens) {
            assertFalse(str.contains(" ")|| str.isEmpty());
        }
    }

    @Test
    void test_if_read_next_token_works() {
        initiateTest1();

        Worksshop1.readNextToken();
        assertEquals(20,Worksshop1.stack.get(0));
        Worksshop1.readNextToken();
        assertEquals(2,Worksshop1.stack.get(1));
        Worksshop1.readNextToken();
        assertEquals(22,Worksshop1.stack.get(0));
    }

    @Test
    void test_final_loop() {
        initiateTest2();

        Worksshop1.loopTokens();
        assertEquals(10,Worksshop1.stack.get(0));
    }

    @Test
    void test_minus_op(){
        Worksshop1.initiateStack();
        Worksshop1.enterInputString("20 2 -");

        Worksshop1.splitInput();
        assertEquals(18,Worksshop1.stack.get(0));
    }

    @Test
    void test_multiplication_op(){
        Worksshop1.initiateStack();
        Worksshop1.enterInputString("20 2 *");

        Worksshop1.splitInput();
        assertEquals(40,Worksshop1.stack.get(0));
    }


    //DOES NOT WORK
    @Test
    void test_if_the_enterInputString_correct_with_two_op() {
        Worksshop1.initiateStack();
        Worksshop1.enterInputString("10 +");

        Worksshop1.splitInput();

        ArrayList<String> expectedOutput = new ArrayList<>();
        expectedOutput.add("10");
        expectedOutput.add("2");
        expectedOutput.add("+");
        assertNotEquals(expectedOutput,Worksshop1.tokens);
    }

    @Test
    void test_if_the_askUserInput_correct_bis() {
        Worksshop1.initiateStack();
        Worksshop1.enterInputString("10 2");

        Worksshop1.splitInput();

        ArrayList<String> expectedOutput = new ArrayList<>();
        expectedOutput.add("10");
        expectedOutput.add("2");
        expectedOutput.add("+");
        assertNotEquals(expectedOutput,Worksshop1.tokens);
    }

}
