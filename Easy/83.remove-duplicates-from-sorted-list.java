/*
 *Given the head of a sorted linked list, delete all duplicates such that each element appears only once. 
 Return the linked list sorted as well.

 Input: head = [1,1,2]
Output: [1,2]

Input: head = [1,1,2,3,3]
Output: [1,2,3]

Constraints:

The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order.

 */

 //https://leetcode.com/problems/remove-duplicates-from-sorted-list


 class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        if(head==null){
            return head;
        }
        while(current.next!=null){
            if(current.val==current.next.val){
                current.next=current.next.next;
            }
            else{
                current=current.next;
            }
        }
        return head;
    }
}