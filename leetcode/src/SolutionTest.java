import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @org.junit.jupiter.api.Test
    void testTopKFrequent() {
        String[] words = new String[]{"i","love","leetcode","i","love","coding"};
        List<String> expected = List.of("i","love");
        assertEquals(expected, solution.topKFrequent(words, 2));
    }
}