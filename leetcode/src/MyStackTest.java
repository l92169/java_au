import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {

    @Test
    void push_pop() {
        MyStack stack = new MyStack();
        stack.push(2);
        stack.push(3);
        stack.push(1);
        stack.pop();
        ArrayDeque<Integer> ad = new ArrayDeque<>(List.of(3,2));
        Arrays.equals(ad.toArray(), stack.s1.toArray());
    }

    @Test
    void top(){
        MyStack stack = new MyStack();
        stack.push(2);
        stack.push(3);
        stack.push(1);
        assertEquals(1, stack.top());
    }
}