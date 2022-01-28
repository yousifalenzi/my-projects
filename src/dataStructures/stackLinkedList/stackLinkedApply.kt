package dataStructures.stackLinkedList

fun main (){


    val stalking = StackLinkedList<Int>()


    stalking.push(99)
    stalking.push(98)
    stalking.push(97)
    stalking.push(96)
    println(stalking.pop())
    println(stalking.pop())
    println(stalking.pop())
    println(stalking.pop())
    println(stalking.pop())
    println("FIRST IN : "+stalking.getFirstIn())
    println("LAST IN : "+stalking.getLastIn())


    stalking.peek()


}