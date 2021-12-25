package dataStructures.DoublyLinkedList

fun main(){

    val doubly = DoublyLinkedList_apply<Int>()
    doubly.addFirst(12)
    doubly.addFirst(65)
    doubly.addFirst(32)
    doubly.addFirst(86)
    println("addFirst")
    doubly.dispalyList_Previous()
    //-----------
    doubly.insertlast(43)
    println("insertlast")
    doubly.dispalyList_Previous()
    //-----------
    doubly.insertAfter(32,20)
    println("insertAfter")
    doubly.dispalyList_Previous()
    //-----------
    val deleteKey = doubly.deleteKey(12)
    println("deleteKey = ${deleteKey?.data}")
    doubly.dispalyList_Previous()
    //------------
    doubly.addFirst(90)
    println("addFirst")
    doubly.dispalyList_Previous()
    //------------
    val deleteKey1 = doubly.deleteKey(65)
    println("deleteKey = ${deleteKey1?.data}")
    doubly.dispalyList_Previous()















}