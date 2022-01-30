package dataStructures.ImplementQueueUsingStacks
private data class Node(val data :Int?){
    var Next:Node?=null

}
class MyQueue {

       private var first:Node?=null
       private var last:Node?=null


    fun push(x: Int) {
        val newed = Node(x)

          if (empty()){

              this.first = newed
              this.last = this.first

          }
        else{
              this.last?.Next = newed
              this.last = newed

          }
    }

    fun pop(): Int? {
        if (!empty()){

            val data = this.first?.data
            if (this.first==this.last)this.last=null

            this.first = this.first?.Next
            return data
        }
        return null

    }

    fun peek(): Int? {
        if (!empty()){

            return this.first?.data
        }
      return null
    }

    private fun empty(): Boolean {

        return (this.first==null)
    }
}