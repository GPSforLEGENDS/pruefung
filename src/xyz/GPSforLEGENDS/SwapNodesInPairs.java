package xyz.GPSforLEGENDS;

public class SwapNodesInPairs {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));

        swapPairs(head);
    }


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

    public static ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = head;
        ListNode pre = null;
        ListNode suc = null;

        head = head.next;

        while (current != null && current.next != null) {
            suc = current.next;
            if (suc != null) {
                current.next = suc.next;
                suc.next = current;
            }

            if (pre != null) {
                pre.next = suc;
            }
            pre = current;
            current = current.next;
        }
        return head;
    }
}
