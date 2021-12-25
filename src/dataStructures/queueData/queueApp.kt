package dataStructures.queueData

fun main() {





     println((0+3)%100)



    val que = queue_anothrway(4)

    que.enqueue(11)
    que.enqueue(42)
    que.enqueue(53)
    que.enqueue(86)





    que.showData()

    val front =que.get_Front()
    val rear = que.get_Rear()
    val size =que.getsize()
    val rear_arrow =que.get_the_rear()

    println("the front value is : $front , and the rear value is : $rear")
    println("the size is : $size")
    println("the rear arrow is : $rear_arrow")
}