import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MyQueueTest {
    @Test
    void testSolution() {
        MyQueue myQueue = new MyQueue();
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(1);
        myQueue.pop();
        ArrayDeque<Integer> expected = new ArrayDeque<>(List.of(3,1));
        Arrays.equals(expected.toArray(), myQueue.s1.toArray());
    }
}