package dataStructures.queueData

class queueNode<T> {


     var data:T?=null
     var next_one_in_queue:queueNode<T>?=null

      fun show(){

          println("DATA IS :$data")
      }



}