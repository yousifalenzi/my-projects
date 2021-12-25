package dataStructures.queueData

class linkedlist_queue {

    var front :queueNode<Int?>?=null
    var rear :queueNode<Int?>?=null
    var count:Int

    init {
      count=0

    }
    fun enqueue(data:Int){
        val newPerson = queueNode<Int?>()
        newPerson.data=data
        if (isEmpty()){
            count++//1
            front = newPerson
            rear = newPerson
        }
        else{
             count++
            rear?.next_one_in_queue=newPerson
            rear=newPerson

        }

    }
    fun dequeue(){
       if (isEmpty())return
        else{
           front=front?.next_one_in_queue
       }
    }
    fun isEmpty():Boolean{

        return count==0

    }


}