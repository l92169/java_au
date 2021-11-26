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