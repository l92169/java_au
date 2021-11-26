# linked-list.md

+ [palindrome-linked-list](#palindrome-linked-list)

## palindrome-linked-list

https://leetcode.com/problems/palindrome-linked-list/

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
    void isPalindrome() {
        Boolean expected = true;
        ListNode data = buildLinkedList(List.of(1,2,2,1));
        Boolean result = solution.isPalindrome(data);
        assertEquals(expected, result);
    }

    @Test
    void isPalindromeNegative() {
        Boolean expected = true;
        ListNode data = buildLinkedList(List.of(1,2));
        Boolean result = solution.isPalindrome(data);
        assertNotEquals(expected, result);
    }

    @Test
    void reverseList() {
        ListNode expected = buildLinkedList(List.of(5,4,3,2,1));
        ListNode data = buildLinkedList(List.of(1,2,3,4,5));
        ListNode result = solution.reverseList(data);
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
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while((fast != null) && (fast.next != null)){
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null){
            slow = slow.next;
        }
        slow = reverseList(slow);
        fast = head;
        while (slow!=null){
            if (fast.val != slow.val){
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
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
}
```