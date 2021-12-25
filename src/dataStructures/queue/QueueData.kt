package dataStructures.queue

class QueueData <T>{//first in - first out

    val queuelist = mutableListOf<T>()



    fun Enqueue(vaule:T){

        this.queuelist.add(vaule)

    }

    fun Dequeue():T?{


        if (!IsEmpty()){
            val first = this.queuelist.first()
            this.queuelist.remove(this.queuelist.first())
            return first
        }
        else  throw Exception("No Data To Remove!!")
    }

    fun getsize():Int= this.queuelist.size

    fun IsEmpty():Boolean=this.queuelist.isEmpty()

    override fun toString(): String {
        return this.queuelist.toString()
    }

}