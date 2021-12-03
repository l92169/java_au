import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MinStackTest {

    @Test
    void push_pop() {
        MinStack stack = new MinStack();
        stack.push(2);
        stack.push(3);
        stack.push(1);
        stack.pop();
        ArrayDeque<Integer> expected = new ArrayDeque<>(List.of(3,2));
        Arrays.equals(expected.toArray(), stack.stack.toArray());
    }
    @Test
    void testGetMin() {
        MinStack stack = new MinStack();
        stack.push(2);
        stack.push(3);
        stack.push(1);
        assertEquals(1, stack.getMin());
    }
}