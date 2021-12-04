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