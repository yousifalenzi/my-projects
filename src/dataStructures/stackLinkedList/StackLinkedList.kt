package dataStructures.stackLinkedList
private data class Node<T>(val data :T){
    var nextStack:Node<T>?=null

}
class StackLinkedList<T> {


    private var top:Node<T>?=null
    private var bottom:Node<T>?=null
    private var length=0


    fun getFirstIn():T? = this.bottom?.data
    fun getLastIn():T? = this.top?.data

    fun peek():Any{
        return if (this.length>0){

            var next= this.top
            var leng = this.length
            while (next!=null){
                println("(${leng}) [${next.data}] ")
                next = next.nextStack
                leng--
            }
            true
        }
        else false


    }
    fun push(value:T){
        val newed = Node<T>(value)
        if (this.top==null){
            this.top = newed
            this.bottom = newed
            this.length++
        }else{
            val holdingPointer = this.top
            this.top = newed
            this.top!!.nextStack = holdingPointer
            this.length++
        }




    }
    fun pop(): Any? {

        return if (this.length>0){
            val data = this.top?.data
            this.top = this.top?.nextStack
            this.length--
            if (this.length==0)this.bottom=null
            data
        } else
            null
    }
}