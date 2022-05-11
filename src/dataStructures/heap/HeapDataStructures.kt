package dataStructures.heap

import java.util.*

class HeapDataStructures {
   companion object sorting{

       val startTime = System.nanoTime()

        fun QueueHeap(ar: Array<Int>):Array<Int> {
           //PriorityQueue to build min heap
           val numbers = PriorityQueue<Int>()


           //add data in MinHeap
           for (i in 0 until ar.size) { // O(N)
               numbers.add(ar.get(i))
           }

           //************pop data by min heap way***********//

           val array = Array<Int>(numbers.size, { it * 1 })
           var i = 0
           while (!numbers.isEmpty()) {
               array[i] = numbers.poll()//O(N)

               i++
           }

            val endTime = System.nanoTime()
            val duration = endTime - startTime
            println("TIME = ${(duration/1000000)/1000} Seconds")


            return array
       }

   }
    fun HeapfiyMax(arr: Array<Int>, n: Int, k: Int): Array<Int> {




                     var large =  k
                     var left = 2*k+1
                     var right = left+1



        for (i in k downTo 0){


              large = i

            while (large<=n){
                left = 2*large+1
                right =left+1
                val pointer = large

                if (left<=arr.size-1&&arr[left]>arr[pointer]){
                    if (right>arr.size-1||arr[left]>arr[right]){

                        large = left
                    }
                    else{
                        large = right
                    }

                }

               else if (right<=arr.size-1&&arr[right]>arr[pointer]){
                    if (left>arr.size-1||arr[right]>arr[left]){

                        large = right
                    }
                    else{
                        large = right
                    }
               }


                else break

                //swap

                val data = arr[pointer]
                arr[pointer] = arr[large]
                arr[large] = data

            }

        }
        return arr
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

    fun kMin(arr: Array<Int>, n: Int, k: Int) {

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

    var log = 0

    fun heapSort(arr: Array<Int>): Array<Int> =sorting(arr)
    private fun sorting(arr: Array<Int>): Array<Int> {

                   for (i in 1 until arr.size){

                       val remaining = (arr.size-1)-i
                       var currentPosition = 0
                       val lastItem =arr[remaining+1]

                       //swap first element
                       val item = arr[currentPosition]
                       arr[remaining+1] = item
                       arr[currentPosition]=lastItem


                       //Reset the children
                       var leftchild = 1
                       var rightchild = 2

                       while (leftchild<=remaining||rightchild<=remaining){



                           if (leftchild<=remaining&&rightchild<=remaining){
                               currentPosition = if (arr[leftchild]>arr[currentPosition]&&arr[leftchild]>arr[rightchild]){
                                   swap(arr,currentPosition,leftchild)
                               } else if(arr[rightchild]>arr[currentPosition]){
                                   swap(arr,currentPosition,rightchild)
                               } else break
                           }

                              // ----------------------------------//

                           else if (leftchild<=remaining||rightchild<=remaining){
                               currentPosition = if (leftchild<=remaining&&arr[leftchild]>arr[currentPosition]){
                                   swap(arr,currentPosition,leftchild)
                               } else if (rightchild<=remaining&&arr[rightchild]>arr[currentPosition]){
                                   swap(arr,currentPosition,rightchild)
                               } else break
                           }

                           else break


                           //set pair
                           val pair = setChild(leftchild, currentPosition, rightchild)
                           leftchild = pair.first
                           rightchild = pair.second
                       }




                   }
                   return arr
    }
    private fun setChild(left: Int, position: Int, right: Int): Pair<Int, Int> {
        //set child
        var leftchild = left
        var rightchild = right
        leftchild = 2 * position + 1
        rightchild = leftchild + 1
        return Pair(leftchild, rightchild)
    }
    private fun swap(arr: Array<Int>,position: Int,newIndex:Int):Int{

        var pos = position // 0
        val value = arr[pos]//7
        arr[pos] = arr[newIndex]//[9,7,8,4,5,6,10]
        pos = newIndex
        arr[pos]=value
        return pos
    }

   object comper : Comparator<Int>{
       override fun compare(o1: Int?, o2: Int?): Int {
           TODO("Not yet implemented")
       }
   }
}



fun main (){


    val ar = Array<Int>(100,{it*Random().nextInt(12)})

    val array = HeapDataStructures.sorting.QueueHeap(ar)

    println("\n---------------------------")
    println(" MIN  ${array[0]}")
    println("MAX  ${array[array.size-1]}")
    println("MID ${array[(array.size-1)/2]}")
    println("Average  ${array.average()}".toUpperCase())




//    val heapSort = heap.heapSort(kLargest)
//    println(" After Sorting ")
//    for (data in heapSort){
//
//        print("$data , ")
//    }
//    println(" \n--------------------------------------")

//



}






