package dataStructures.stackarray

fun main (){


    val stackArrayList = StackArrayList<Any>()
    stackArrayList.push(12)
    stackArrayList.push(56)
    stackArrayList.push(42)
    stackArrayList.push(43)
    stackArrayList.push(76)
    stackArrayList.push(98)



    stackArrayList.pop()
    stackArrayList.pop()
    println("first  "+stackArrayList.getFirstIn())
    println("last  "+stackArrayList.getLastIn())
    stackArrayList.peek()

}