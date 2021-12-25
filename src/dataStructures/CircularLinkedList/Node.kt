package dataStructures.CircularLinkedList

class Node <T>(val data:T?) {


    var Next:Node<T>?=null



    fun showInfo(){

        println("DATA IS $data")
    }
}