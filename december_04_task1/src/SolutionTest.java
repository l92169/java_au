import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @org.junit.jupiter.api.Test
    void getWords() {
        List<String> expected = List.of("hellooo", "nameeeee");
        List<String> result = solution.getWords("hellooo my nameeeee is Lisa");
        assertEquals(expected, result);
    }


    @org.junit.jupiter.api.Test
    void getReversedWords() {
        String expected = "olleh ym eman si asiL";
        String result = solution.getReversedWords("hello my name is Lisa");
        assertEquals(expected, result);
    }

    @org.junit.jupiter.api.Test
    void getDistanceSorted() {
    }
}