# design.md

+ [implement-queue-using-stacks](#implement-queue-using-stacks)

## implement-queue-using-stacks

https://leetcode.com/problems/implement-queue-using-stacks/

<details><summary>Test Cases</summary><blockquote>

``` java
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
```

</blockquote></details>

``` java
class MyQueue {
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();

    public void push(int x) {
        while(!s1.empty())
            s2.push(s1.pop());
        s1.push(x);
        while(!s2.empty())
            s1.push(s2.pop());
    }

    public int pop() {
        return s1.pop();
    }

    public int peek() {
        return s1.peek();
    }

    public boolean empty() {
        return s1.isEmpty();
    }
}
```