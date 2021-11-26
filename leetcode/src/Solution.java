class Solution {
    public ListNode middleNode(ListNode head) {
        Integer sizeList = getsize(head);
        ListNode cur = head;
        Integer i = 0;
        while (i!= (int)(sizeList/2)){
            cur = cur.next;
            i += 1;
        }
        return cur;
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