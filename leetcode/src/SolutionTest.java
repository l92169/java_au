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