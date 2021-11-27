                          # array.md

+ [squares-of-a-sorted-array](#squares-of-a-sorted-array)

## squares-of-a-sorted-array

https://leetcode.com/problems/squares-of-a-sorted-array/

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

</blockquote></details>

``` java
class Solution {
    public Integer get_first_nonnegative(int[] nums){
        for (int i = 0; i < nums.length;i++){
            if (nums[i] >= 0){
                return i;
            }
        }
        return -1;
    }
    public int[] sortedSquares(int[] nums) {
        Integer ind = get_first_nonnegative(nums);
        if (ind == -1) {
            int[] A = new int[nums.length];
            Integer count = 0;
            for (int i = nums.length - 1; i >= 0; i--) {
                A[i] = nums[count] * nums[count];
                count += 1;
            }
            return A;
        }
        else if (ind == 0) {
            int[] A = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                A[i] = nums[i] * nums[i];
            }
            return A;
        }
        else {
            Integer left = ind - 1, right = ind;
            Integer length = nums.length;
            int[] res = new int[nums.length];
            Integer i = 0;
            while (right < length && left >= 0) {
                if (nums[left] * nums[left] < nums[right] * nums[right]) {
                    res[i] = (nums[left] * nums[left]);
                    left -= 1;
                    i++;
                } else {
                    res[i] = (nums[right] * nums[right]);
                    right += 1;
                    i++;
                }
            }
            while (left >= 0) {
                res[i] = (nums[left] * nums[left]);
                left -= 1;
                i++;
            }
            while (right < length) {
                res[i] = (nums[right] * nums[right]);
                right += 1;
                i++;
            }
            return res;
        }
    }
}
```