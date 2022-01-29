package dataStructures.QueueLinked


fun main (){

    val queueing = QueueLinked<Any>()
    queueing.enqueue(12)
    queueing.enqueue(14)
    queueing.enqueue(18)
    queueing.enqueue(11)
    queueing.enqueue(23)
    queueing.enqueue(17)
    queueing.enqueue(53)
    queueing.dequeue()
    queueing.dequeue()
    queueing.dequeue()
    queueing.dequeue()
    queueing.dequeue()
    queueing.dequeue()
    queueing.dequeue()


    queueing.enqueue(53)

    println("First "+queueing.first())
    println("Last "+queueing.last())
    queueing.enqueue(11)
    println("First "+queueing.first())
    println("Last "+queueing.last())
    queueing.dequeue()
    println("First "+queueing.first())
    println("Last "+queueing.last())
    queueing.peek()

}