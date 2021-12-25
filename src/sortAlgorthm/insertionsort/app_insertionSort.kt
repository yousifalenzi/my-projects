package sortAndsearch_Algorthm.insertionsort

import java.io.IOException
import java.util.concurrent.TimeUnit



fun INSERT_SORT(array: IntArray):IntArray{

         for (i in 1 until array.size){//3
             val dataSaveAtIndexI = array[i] //save element at index i [2,5,6,3,1]
             var current = i-1 //2

              while (current>=0&&array[current]>dataSaveAtIndexI){ // [0]=6 > 2 corrcet

                  array[current+1] = array[current] //[1+1] = [1]=6    [2,5,6,3,1]

                 current--//0
              }

             array[current+1] = dataSaveAtIndexI   //[2,5,6,3,1]

         }


    return array
}

fun main() {




    val arr = IntArray(6)
    arr.set(0,7)
    arr.set(1,11)
    arr.set(2,3)
    arr.set(3,15)
    arr.set(4,8)
    arr.set(5,9)

    INSERT_SORT(arr).forEach { print(" ($it) ") }




}