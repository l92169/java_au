# design.md

+ [min-stack](#min-stack)

## min-stack

https://leetcode.com/problems/min-stack/

<details><summary>Test Cases</summary><blockquote>

``` java
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
```

</blockquote></details>

``` java
def __init__(self):
    self.users = {}
class MinStack {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();
    public void push(int val) {
        if( minStack.isEmpty() || val <=  minStack.peek()){   //Push when empty OR x<= current smallest value
             minStack.push(val);
        }
        stack.push(val);
    }

    public void pop() {
        int val = stack.pop();
        if (minStack.peek() == val) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
```