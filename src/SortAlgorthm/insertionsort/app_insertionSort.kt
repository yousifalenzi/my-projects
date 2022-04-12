package sortAndsearch_Algorthm.insertionsort

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.random.Random


fun InsertionSort(array:Array<Int>):Array<Int>{

            for (i in 1 until array.size){//4
                val dataSaveAtIndexI = array[i] //1 [2,5,5,6,1]
                var current = i-1 //3

                while (current>=0&&array[current]>dataSaveAtIndexI){ // [0]=6 > 2 corrcet

                    array[current+1] = array[current] //[1+1] = [1]=6    [2,5,6,3,1]

                    current--//0

                }

                array[current+1] = dataSaveAtIndexI   //[2,3,5,6,1]


            }




    return array
}
 fun insertionSort_yousifWay(arr:Array<Int>):Array<Int>{

            for(i in 1 ..arr.size-1){
                val data = arr[i]
                var j = i
                while (j>0&&data<arr[j-1]){

                    val value = arr[j]//

                    //swap

                    arr[j] = arr[j-1]//
                    arr[j-1]=value //
                    j--


                }


            }


    return arr

}

fun main() {

        val array1 = arrayOf(2,7,3,1,9,8)
        val array2 = arrayOf(9,8,7,6,5,4)

        InsertionSort(array1).forEach {print("$it , ")}
        println("\n")
        insertionSort_yousifWay(array2).forEach {print("$it , ")}
}

