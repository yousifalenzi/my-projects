package solvingProblems

class Staff{
       private var head :ListNode?=null
   data class ListNode(val value:Int, var next:ListNode?)

      fun swapPairs(): ListNode?=swapTwoSingleNode(this.head)

        private fun swapTwoSingleNode(head:ListNode?):ListNode?{
                  var getHead = head ?: return null
                 if (getHead.next==null)return getHead

              val node = getHead.next

            getHead.next = swapTwoSingleNode(node?.next)
            node?.next = getHead
            if (node != null) {
                getHead = node
            }

          return getHead
       }
      fun setValue(i:Int){
          val node = ListNode(i,null)

          if (head==null){
              head = node
          }else{
              var n = head

              while (n?.next!=null){
                  n=n.next
              }
              n?.next  = node
          }

      }

  }

fun main(){



   val newLinked =Staff()

    newLinked.setValue(4)
    newLinked.setValue(11)
    newLinked.setValue(3)
    newLinked.setValue(5)
    newLinked.setValue(2)
    var head = newLinked.swapPairs()
     while (head!=null){

         print("${head.value}, ")
         head = head.next
     }

}