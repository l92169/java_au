# linked-list.md

+ [middle-of-the-linked-list](#middle-of-the-linked-list)

## middle-of-the-linked-list

https://leetcode.com/problems/middle-of-the-linked-list/

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
    void middleNode1() {
        ListNode expected = buildLinkedList(List.of(3,4,5));
        ListNode data = buildLinkedList(List.of(1,2,3,4,5));
        ListNode result = solution.middleNode(data);
        assertEquals(expected, result);
    }
    @Test
    void middleNode2() {
        ListNode expected = buildLinkedList(List.of(4,5,6));
        ListNode data = buildLinkedList(List.of(1,2,3,4,5,6));
        ListNode result = solution.middleNode(data);
        assertEquals(expected, result);
    }

    @Test
    void getsize1() {
        Integer expected = 5;
        ListNode data = buildLinkedList(List.of(1,2,3,4,5));
        Integer result = solution.getsize(data);
        assertEquals(expected, result);
    }

    @Test
    void getsize2() {
        Integer expected = 0;
        ListNode data = buildLinkedList(List.of());
        Integer result = solution.getsize(data);
        assertEquals(expected, result);
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
    public ListNode middleNode(ListNode head) {
        Integer sizeList = getsize(head);
        ListNode cur = head;
        Integer i = 0;
        while (i!= (int)(sizeList/2)){
               cur = cur.next;
               i += 1;
        }
        return cur;
    }
    public Integer getsize(ListNode head){
        ListNode cur = head;
        Integer count = 0;
        while (cur!= null){
            cur = cur.next;
            count += 1;
        }
        return count;
    }
}
```