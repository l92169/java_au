# linked-list.md

+ [sort-list](#sort-list)

## sort-list

https://leetcode.com/problems/sort-list/

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
    void sortList1() {
        ListNode expected = buildLinkedList(List.of(1,2,3,4));
        ListNode data = buildLinkedList(List.of(4,2,1,3));
        ListNode result = solution.sortList(data);
        assertEquals(expected, result);
    }

    @Test
    void sortList2() {
        ListNode expected = buildLinkedList(List.of(-1,0,3,4,5));
        ListNode data = buildLinkedList(List.of(-1,5,3,4,0));
        ListNode result = solution.sortList(data);
        assertEquals(expected, result);
    }

    @Test
    void sortList3() {
        ListNode expected = buildLinkedList(List.of());
        ListNode data = buildLinkedList(List.of());
        ListNode result = solution.sortList(data);
        assertEquals(expected, result);
    }

    @Test
    void mergeTwoLists() {
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
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null){
            return head;
        }
        ListNode p = null, slow = head, fast = head;
        while (fast!=null && fast.next!=null){
            p = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        p.next = null;
        return mergeTwoLists(sortList(head), sortList(slow));
    }
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