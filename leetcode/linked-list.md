# linked-list.md

+ [merge-two-sorted-lists](#merge-two-sorted-lists)

## merge-two-sorted-lists

https://leetcode.com/problems/merge-two-sorted-lists/

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
    void mergeTwoLists1() {
        ListNode expected = buildLinkedList(List.of(1,1,2,3,4,4));
        ListNode data1 = buildLinkedList(List.of(1,2,4));
        ListNode data2 = buildLinkedList(List.of(1,3,4));
        ListNode result = solution.mergeTwoLists(data1,data2);
        assertEquals(expected, result);
    }

    @Test
    void mergeTwoLists2() {
        ListNode expected = buildLinkedList(List.of());
        ListNode data1 = buildLinkedList(List.of());
        ListNode data2 = buildLinkedList(List.of());
        ListNode result = solution.mergeTwoLists(data1,data2);
        assertEquals(expected, result);
    }

    @Test
    void mergeTwoLists3() {
        ListNode expected = buildLinkedList(List.of(0));
        ListNode data1 = buildLinkedList(List.of());
        ListNode data2 = buildLinkedList(List.of(0));
        ListNode result = solution.mergeTwoLists(data1,data2);
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode output = new ListNode();
        ListNode cur = output;
        while (list1 != null && list2 != null){
            if (list1.val < list2.val){
                cur.next = list1;
                list1 = list1.next;
            }
            else{
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 == null){
            cur.next = list2;
        }
        if (list2 == null){
            cur.next = list1;
        }
        return output.next;
    }
}
```