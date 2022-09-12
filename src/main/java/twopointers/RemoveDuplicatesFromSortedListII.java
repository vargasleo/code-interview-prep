package twopointers;

import java.util.HashMap;

// Leetcode - 82. Remove Duplicates from Sorted List II
public class RemoveDuplicatesFromSortedListII {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        var list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))));
        var result = deleteDuplicates(list);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        if (head.val == head.next.val) {
            while (head.next != null && head.val == head.next.val) head = head.next;
            return deleteDuplicates(head.next);
        } else head.next = deleteDuplicates(head.next);
        return head;
    }
}
