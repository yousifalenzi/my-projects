package SortAlgorthm.quickSort


class geeks_quickSort {


     fun QuickSort(arr:IntArray,low:Int,high:Int){

         quicksort(arr,low,high)
     }
     private fun quicksort(arr:IntArray,low:Int,high:Int){

        if(low<high) {

            val pi = partition(arr,low,high)

            quicksort(arr,low,pi-1)  // Before pi

            quicksort(arr,pi+1,high) // after pi
        }




    }
     private fun swap(arr: IntArray,i:Int,j:Int){

         val temp = arr[i]
         arr[i] = arr[j]
         arr[j] = temp
     }
     private fun partition(arr: IntArray, low: Int, high: Int): Int {


        val pivot = arr[high] // select pivot
        var i = (low -1) // i - low


        for(j in low .. high-1){


            if (arr[j]<=pivot)
            {
                i++
                swap(arr,i,j)

            }

        }

        swap(arr,i+1,high)
        return i+1

    }

}