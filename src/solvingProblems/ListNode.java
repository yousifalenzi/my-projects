package solvingProblems;

public class ListNode {
    int val;
    ListNode next;
    ListNode pre;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next,ListNode pre) {
        this.val = val;
        this.next = next;
        this.pre = pre ;
    }
}
