class Solution {
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