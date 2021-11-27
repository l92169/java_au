import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private Solution solution;
    @Test
    void get_first_nonnegative() {
        Integer expected = 2;
        int[] data = {-4,-1,0,3,10};
        Integer result = solution.get_first_nonnegative(data);
        assertEquals(expected, result);
    }

    @Test
    void sortedSquares1() {
        int[] expected = {0,1,9,16,100};
        int[] data = {-4,-1,0,3,10};
        int[] result = solution.sortedSquares(data);
        assertArrayEquals(expected, result);
    }

    @Test
    void sortedSquares2() {
        int[] expected = {4,9,9,49,121};
        int[] data = {-7,-3,2,3,11};
        int[] result = solution.sortedSquares(data);
        assertArrayEquals(expected, result);
    }

    @Test
    void sortedSquares3() {
        int[] expected = {1};
        int[] data = {-1};
        int[] result = solution.sortedSquares(data);
        assertArrayEquals(expected, result);
    }


    @BeforeEach
    void setUp() {
        solution = new Solution();
    }
}