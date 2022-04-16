import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 */
class Solution {
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (ListNode node: lists) {
            while (node != null) {
                pq.add(node.val);
                node = node.next;
            }
        }
        ListNode ans = new ListNode(0);
        ListNode ptr = ans;
        while (!pq.isEmpty()) {
            ptr.next = new ListNode(pq.poll());
            ptr = ptr.next;
        }
        return ans.next;
    }
}
