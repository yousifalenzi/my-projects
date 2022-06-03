package solvingProblems



class Solution{



   internal class ListNode1(val `val` :Int) {
       private var next: ListNode1? = null
       private var pre: ListNode1? = null



       fun getNext():ListNode1? = this.next
       fun getPre():ListNode1? = this.pre

       fun setNext(nextLco: ListNode1?){
           this.next = nextLco
       }
       fun setPre(PreLco: ListNode1?){
           this.pre = PreLco
       }}



    internal fun addTwoNumbers(l1: ListNode1?, l2: ListNode1?): ListNode1? {

      val head:ListNode1 = ListNode1(0)
      var f: ListNode1? = l1
      var s: ListNode1? = l2
      var p: ListNode1?  = head
      var rest = 0

      while (f!=null||s!=null){

          val x = f?.`val` ?: 0
          val y = s?.`val` ?: 0

          val sum = rest+x+y
          rest = sum /10
          val listNode1 = ListNode1(sum % 10)
          listNode1.setPre(p)

          p?.setNext(listNode1)
          p= p?.getNext()!!

          f = f?.getNext()
          s = s?.getNext()

      }
      if (rest > 0) {
          val listNode1 = ListNode1(rest)
          listNode1.setPre(p)
          p?.setNext(listNode1)
      }


      return  head.getNext()
  }





}

fun main (){

     val f1 = Solution.ListNode1(8)
     val f2 = Solution.ListNode1(9)
     val f3 = Solution.ListNode1(2)
      f1.setNext(f2)
      f2.setNext(f3)

    val f4 = Solution.ListNode1(7)
    val f5 = Solution.ListNode1(8)
    f4.setNext(f5)





  val so = Solution()
  val addTwoNumbers = so.addTwoNumbers(f1, f4)





}