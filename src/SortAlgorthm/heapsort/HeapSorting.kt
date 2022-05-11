package SortAlgorthm.heapsort

import dataStructures.queueData.queue
import dataStructures.queueData.queue_anothrway
import java.util.PriorityQueue


val MAX_HEAP = "MAX"
val MIN_HEAP = "MIN"
fun swap(array: Array<Int>,old:Int,new:Int){// 12
                                            //8   7


    val oldVaule = array[old]//12
    array[old] = array[new]
    array[new] = oldVaule


}
fun heapfiyMin(arr: Array<Int>, n: Int, k: Int) {

    var min =  k
    var left = 2*k+1
    var right = left+1

    for (i in k downTo 0){

        min = i
        while (min<=n){
            left = 2*min+1
            right =left+1
            val pointer = min

            if (left<=arr.size-1&&arr[left]<arr[pointer]){
                min = if (right>arr.size-1||arr[left]<arr[right]){

                    left
                } else{
                    right
                }

            }

            else if (right<=arr.size-1&&arr[right]<arr[pointer]){
                min = if (left>arr.size-1||arr[right]<arr[left]){

                    right
                } else{
                    right
                }
            }


            else break

            //swap

            val data = arr[pointer]
            arr[pointer] = arr[min]
            arr[min] = data

        }

    }
}

fun Min_Heapfiy(Array:Array<Int>,n:Int,i:Int){ //

      val left = 2*i+1
      val right = left+1
      var largest = i

    //checking for the smallest element

    if (left<=n&&Array[left]<=Array[i]){//  10
                                     //  8  9
        //                             5,1 , 2,7
        largest = left //5
    }
    else{
        largest = i
    }

    if (right<=n&&Array[right]<Array[largest])
    {
        largest = right//2
    }

    //updating the min -heap tree
    if (largest!=i){
        val data =  Array[i]

        Array[i] = Array [largest]
        Array [largest] = data

        Min_Heapfiy(Array,n,largest)


    }





}

fun print_like_tree (Array:Array<Int>){

    var Vblanks = 32
    var itemPerRow = 1
    var column = 0
    var j = 0
    val currentsize = Array.size
    println("current size is :${Array.size}")

    val dots = "..............................."
    println(dots+dots)

    while (currentsize>0){


        if (column==0){

            for (k in 0 until Vblanks){
                print(" ")
            }
        }

        print(Array[j])
        j++
        if (j==currentsize)break

        column++
        //end of row

        if (column==itemPerRow){

            Vblanks=Vblanks/2
            itemPerRow=itemPerRow*2
            column=0
            println()
        }
        else{

            for (k in 0 until Vblanks*2){

                print(" ")
            }
        }
    }
    println("\n${dots+dots}")
}


fun main(){
//    heapfiyMin(min,(min.size-2)/2,(min.size - 2) / 2)
//    for (value in min){
//
//        print(" ${value} ")
//    }

    val min = arrayOf(10,15,11,4,9,0,14)
    val queue = PriorityQueue<Int>()




    while (!queue.isEmpty()){

        println(queue.poll())

    }



   val n =min.size

    for (i in 0 until n) {
        queue.add((-1)*min[i])
    }
    while (!queue.isEmpty()){

       print("${(queue.poll())*(-1)}, ")


    }








}