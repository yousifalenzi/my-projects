package dataStructures.SinglyLinkedList

fun main(){



    val Singly1= SinglyLinkedList()


    Singly1.insertFirst(12)
    Singly1.insertFirst(23)
    Singly1.insertFirst(64)
    Singly1.insertFirst(13)
    Singly1.insertFirst(17)

    println("last = ${Singly1.last?.data}")





   Singly1.dispalyList()
}