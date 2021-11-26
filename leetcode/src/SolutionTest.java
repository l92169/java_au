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