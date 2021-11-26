# linked-list.md

+ [intersection-of-two-linked-lists](#intersection-of-two-linked-lists)

## intersection-of-two-linked-lists

https://leetcode.com/problems/intersection-of-two-linked-lists/

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
    void getIntersectionNode1() {
        ListNode expected = buildLinkedList(List.of(8,4,5));
        ListNode data1 = buildLinkedList(List.of(4,1,8,4,5));
        ListNode data2 = buildLinkedList(List.of(5,6,1,8,4,5));
        ListNode result = solution.getIntersectionNode(data1,data2);
        assertEquals(expected, result.next);
    }

    @Test
    void getIntersectionNode2() {
        ListNode expected = buildLinkedList(List.of(4));
        ListNode data1 = buildLinkedList(List.of(1,9,1,2,4));
        ListNode data2 = buildLinkedList(List.of(3,2,4));
        ListNode result = solution.getIntersectionNode(data1,data2);
        assertEquals(expected, result.next);
    }

    @Test
    void getIntersectionNegative() {
        ListNode expected = buildLinkedList(List.of(6));
        ListNode data1 = buildLinkedList(List.of(2,6,4));
        ListNode data2 = buildLinkedList(List.of(1,5));
        ListNode result = solution.getIntersectionNode(data1,data2);
        assertNotEquals(expected, null);
    }

    @Test
    void getsize() {
        Integer expected = 5;
        ListNode data = buildLinkedList(List.of(1,2,3,4,5));
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
другие классы, если имеютсяimport java.util.Objects;

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
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode hA = headA;
        ListNode hB = headB;
        Integer lenA = getsize(headA);
        Integer lenB = getsize(headB);
        Integer delt = lenA - lenB;
        while (delt > 0){
            hA = hA.next;
            delt -= 1;
        }
        while (delt < 0){
            hB = hB.next;
            delt += 1;
        }

        while (hA.equals(hB) == false){
            hA = hA.next;
            hB = hB.next;
            if (hA == null && hB == null){
                return null;
            }
        }
        return hA;
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