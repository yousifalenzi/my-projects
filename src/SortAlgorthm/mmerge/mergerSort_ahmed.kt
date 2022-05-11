package sortAndsearch_Algorthm.mmerge

import java.util.*


class mergerSort_ahmed {


    fun sort (array: Array<Int>){
        val startTime = System.nanoTime()
        sort(array,0,array.size-1)
        val endTime = System.nanoTime()
        val duration = endTime - startTime //divide by 1000000 to get milliseconds
        println("TIME = ${(duration/1000000)/1000} Seconds")
    }

    private fun sort(array:Array<Int>,start:Int , end:Int){

        if (end<=start) return

        val mid = (start+end) /2 // to get mid
        sort(array,start,mid) // to get left side
        sort(array,mid+1,end) // to get right side

        merge(array,start,mid,end) // merge tow array and compare them

    }

    private fun merge(array: Array<Int>, start: Int, mid: Int, end: Int) {

            val tempArray = IntArray(end-start+1) //

           var leftSide_Pointer = start // Pointer representing items from left to Mid
           var rightSide_Pointer = mid+1// Pointer representing items from Mid to End
           var k = 0 // Pointer representing items index in temp array and increment when new items added

          while (leftSide_Pointer<=mid && rightSide_Pointer<=end){

              if (array[leftSide_Pointer]<array[rightSide_Pointer]){
                 tempArray[k] = array[leftSide_Pointer]
                  leftSide_Pointer++
              }
              else{
                  tempArray[k] = array[rightSide_Pointer]
                  rightSide_Pointer++
              }

              k++ //4

          }


           if(leftSide_Pointer<=mid){
              while (leftSide_Pointer<=mid){
                  tempArray[k] =array[leftSide_Pointer]
                  leftSide_Pointer++
                  k++
              }


           }
        else if(rightSide_Pointer<=end){
               while (rightSide_Pointer<=end){
                   tempArray[k] =array[rightSide_Pointer]
                   rightSide_Pointer++
                   k++
               }

        }


          //copy data to new array
         for (i in 0 until tempArray.size){

             array[start+i] = tempArray[i]

         }



    }
}

fun main(){
       val merge = mergerSort_ahmed()

    val ar = Array<Int>(10000000,{it* Random().nextInt(12)})
    merge.sort(ar)


}