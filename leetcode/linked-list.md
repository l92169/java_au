# linked-list.md

+ [reverse-linked-list](#reverse-linked-list)

## reverse-linked-list

https://leetcode.com/problems/reverse-linked-list/

<details><summary>Test Cases</summary><blockquote>

``` java
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

    @Test
    void reverseList() {
        ListNode expected = buildLinkedList(List.of(5,4,3,2,1));
        //ListNode expected = null;
        ListNode data = buildLinkedList(List.of(1,2,3,4,5));
        ListNode result = solution.reverseList(data);
        //ListNode result = solution.reverseList(null);
        assertEquals(expected, result);
    }

    @Test
    void reverseListNegative() {
        ListNode expected = buildLinkedList(List.of(3,7,19));
        ListNode data = buildLinkedList(List.of(19,7,10));
        ListNode result = solution.reverseList(data);
        assertNotEquals(expected, result);
    }

    private ListNode buildLinkedList(List<Integer> lst){
        ListNode head = new ListNode();
        ListNode cur = head;
        for (int val: lst){
            ListNode next = new ListNode();
            next.val = val;
            cur.next = next;
            cur = cur.next;
        }
        return  head.next;
    }

    private List<Integer> createList(){
        return List.of(1,2,3,4,5);
    }
}
```

``` java
import java.util.Objects;

public class ListNode { int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                ListNode listNode = (ListNode) o;
                return val == listNode.val && Objects.equals(next, listNode.next);

        }

        @Override
        public String toString() {
                return "ListNode{" +
                        "val=" + val +
                        ", next=" + next +
                        '}';
        }
}

```

</blockquote></details>

``` java
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return  prev;
    }
}```