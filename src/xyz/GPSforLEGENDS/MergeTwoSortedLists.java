package xyz.GPSforLEGENDS;

public class MergeTwoSortedLists {

    public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public static void main(String[] args) {

    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode head = null;
        ListNode prev = null;

        while(list1 != null || list2 != null){
            if(list1 == null){
                if(prev != null){
                    prev.next = list2;
                } else{
                    head = list2;
                }
                prev = list2;
                list2 = list2.next;
            }
            else if(list2 == null){
                if(prev != null){
                    prev.next = list1;
                } else{
                    head = list1;
                }
                prev = list1;
                list1 = list1.next;
            }
            else{
                if(list1.val < list2.val){
                    if(prev != null){
                        prev.next = list1;
                    } else{
                        head = list1;
                    }
                    prev = list1;
                    list1 = list1.next;
                } else{
                    if(prev != null){
                        prev.next = list2;
                    } else{
                        head = list2;
                    }
                    prev = list2;
                    list2 = list2.next;
                }
            }
        }

        return head;
    }
}
