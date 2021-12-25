package dataStructures.DoublyLinkedList

class Node <T> {

    var data:T?=null
    var Next:Node<T>?=null
    var previous:Node<T>?=null
    var index:Int?=null


    fun showInfo(count:Int){

        print("{$data}"+"__")
    }
}