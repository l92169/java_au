# design.md

+ [implement-stack-using-queues](#implement-stack-using-queues)

## implement-stack-using-queues

https://leetcode.com/problems/implement-stack-using-queues/

<details><summary>Test Cases</summary><blockquote>

``` java
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
```

</blockquote></details>

``` java
class MyStack{
	Queue<Integer> s1 = new LinkedList<>();
	Queue<Integer> s2 = new LinkedList<>();

	public void push(int x) {
		s1.add(x);
		int i = 0;
		while(i < s1.size() - 1){
			s2.add(s1.remove());
			s1.add(s2.remove());
			i++;
		}
	}

	/** Removes the element on top of the stack and returns that element. */
	public int pop() {
		return s1.remove();
	}

	/** Get the top element. */
	public int top() {
		return s1.peek();
	}

	/** Returns whether the stack is empty. */
	public boolean empty() {
		return s1.isEmpty();
	}
}
```