package dataStructures.CircularLinkedList

fun main(){

    val circular =CircularLinkedList_apply<Int>()

    circular.AddFirst(12)
    circular.AddFirst(2)
    circular.AddFirst(76)
    circular.AddFirst(43)

    circular.addLast(20)
    val deleteFirst = circular.deleteFirst()
    println("removed data is $deleteFirst")
    circular.dispalyList()



}