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