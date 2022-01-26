/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;

        int num = head.val;
        ListNode list = new ListNode(head.val);
        ListNode solution = list;

        while(head != null) {
            if(num != head.val) {
                list.next = new ListNode(head.val);
                list = list.next;
                num = head.val;
            }
            head = head.next;
        }

        return solution;
    }
}