package dataStructures.stackarray

fun main (){


    val stackArrayList = StackArrayList<Any>()
    stackArrayList.push(12)
    stackArrayList.push(14)
    stackArrayList.push("yousif")
    stackArrayList.push("aqyal")
    stackArrayList.push("bayan")
    stackArrayList.pop()
    stackArrayList.pop()
    stackArrayList.pop()
    stackArrayList.pop()


    stackArrayList.peek()

}