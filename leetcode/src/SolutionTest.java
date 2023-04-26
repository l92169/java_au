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