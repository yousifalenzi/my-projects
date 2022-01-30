package dataStructures.QueueLinked


fun main (){

    val queueing = QueueLinked<Any>()
    queueing.enqueue("bayan")
    queueing.enqueue("yousif")
    queueing.enqueue("lola")
    queueing.enqueue("maryam")
    queueing.enqueue("naif")
    queueing.enqueue("omar")
    queueing.enqueue("muath")
    queueing.dequeue()
    queueing.dequeue()
    queueing.dequeue()

     queueing.first()
     queueing.last()

    queueing.peek()


}