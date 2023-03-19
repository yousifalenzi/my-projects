package solvingProblems;

public class addTowNumbers_j {

//You are given two non-empty linked lists representing two non-negative integers.
// The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
//You may assume the two numbers do not contain any leading zero, except the number 0 itself.


        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummyHead = new ListNode(0);
            ListNode p = l1, q = l2, curr = dummyHead;
            int carry = 0;
            while (p != null || q != null) {
                int x = (p != null) ? p.val : 0;
                int y = (q != null) ? q.val : 0;
                int sum = carry + x + y;
                carry = sum / 10;
                curr.next = new ListNode(sum % 10);
                curr = curr.next;
                if (p != null) p = p.next;
                if (q != null) q = q.next;
            }
            if (carry > 0) {
                curr.next = new ListNode(carry);
            }
            return dummyHead.next;
        }


     public ListNode addSum(ListNode l1, ListNode l2){
         ListNode Head = new ListNode(0);

         ListNode F = l1;
         ListNode S = l2;
         ListNode P = Head ;

         int rest = 0 ;


         while (F!=null||S!=null){
             int x =(F!=null)?F.val: 0 ;
             int y =(S!=null)?S.val: 0 ;

              int sum = rest+x+y ;//17
              rest = sum/10 ;//1.7
              P.next = new ListNode(sum%10) ;
              P=P.next;

              F = (F!=null)?F.pre:null;
              S = (S!=null)?S.pre:null;




         }
         if (rest > 0) {
             P.next = new ListNode(rest);
         }
         return Head.next;
     }

      public static void main(String args[]){

          ListNode l1 = new ListNode(2) ;
          ListNode l2 = new ListNode(4) ;
          ListNode l3 = new ListNode(3) ;



          l3.pre = l2 ;
          l2.pre = l1 ;


          ListNode l8 = new ListNode(5) ;
          ListNode l9 = new ListNode(6) ;
          ListNode l10 = new ListNode(4) ;
          l10.pre = l9 ;
          l9.pre = l8 ;


          addTowNumbers_j j = new addTowNumbers_j();
           ListNode listNode2 = j.addSum(l3, l10);

//          int exp = 1 ;
//          int p1 = 24 ;
//          int p2 = 56;
//          int carry = 0;
//          int sum = 0 ;
//          int out = 0 ;
//
//            ListNode l1 = new ListNode(0) ;
//            ListNode head = l1 ;
//
//          while (p1 / exp > 0)
//              {
//                sum =carry+(p1/exp)%10+(p2/exp)%10;
//                carry = sum/10 ;//0
//
//              head.next =new ListNode(sum%10) ;
//              head=head.next;
//
//
//              exp*=10 ;
//          }
//
//
//           ListNode loop = l1 ;
//          while (loop!=null){
//              System.out.print(loop.val+" ");
//              loop=loop.next  ;
//          }

}}



