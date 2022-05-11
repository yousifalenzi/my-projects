package dataStructures.heap

import java.util.*

fun kLargest(arr: Array<Int>, n: Int, k: Int): IntArray? {
    //PriorityQueue to build min heap
    val numbers = PriorityQueue<Int>()

    //add data in heap
    for (i in 0 until n) {
        numbers.add(-1 * arr[i])
    }
    val array = IntArray(k)
    var i = 0
    if (k <= numbers.size) {
        while (!numbers.isEmpty() && k > i) {
            array[i] = numbers.poll() * -1
            i++
        }
    }
    return array
}
object comper :Comparator<Int>{
    override fun compare(o1: Int, o2: Int): Int {
        val value: Int = o1.compareTo(o2) // which ine bigger

        return if (value>0){
            -1
        } else if (value<0){
            1
        }else 0


    }
//
//
//}
fun main (){
      //add() - Inserts the specified element to the queue. If the queue is full, it throws an exception.
     //offer() - Inserts the specified element to the queue. If the queue is full, it returns false.
     //remove() - removes the specified element from the queue
     //poll() - returns and removes the head of the queue

    // Creating a priority queue
    // Creating a priority queue
    // Using the add() method

    // Using the add() method


    val arr = arrayOf(12, 5, 787, 1, 23)





}}