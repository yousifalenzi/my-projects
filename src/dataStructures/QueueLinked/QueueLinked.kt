package dataStructures.QueueLinked
private data class Node<T>(val data :T?){
    var NextQueue:Node<T>?=null

}
class QueueLinked<T>{
    private var first:Node<T>?=null
    private var last:Node<T>?=null
    private var length = 0
    private fun isEmpty():Boolean = length==0


    fun first(): T? =this.first?.data
    fun last(): T? =this.last?.data
    fun peek():Boolean{
        return if (!isEmpty()){
             var next =this.first
             var leng = this.length-1

             for (i in 0 until this.length){
                print(" -- (Index/${this.length-leng})[${next?.data}] --")
                 next = next?.NextQueue
                leng--

            }
            true
        }else
            false
    }
    fun enqueue(value:T):T?{
        val node = Node<T>(value)
         if (isEmpty()){

            this.first = node
            this.last = this.first
        }
        else{
            this.last?.NextQueue = node
            this.last = node
        }

        this.length++
        return node.data

    }
    fun dequeue():Any?{

        return if (!isEmpty()){

            val data = this.first?.data
            if (this.first === this.last)this.last=null
            this.first = this.first?.NextQueue
            this.length--

            data

        }else null


    }
}