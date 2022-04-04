package SortAlgorthm.quickSort

class QuickSort  {





    fun QuickSort(Arr:IntArray,start:Int,end:Int){
        QuickSort_fun(Arr,start,end)
    }
   private fun QuickSort_fun(Arr:IntArray,start:Int,end:Int){

        if(start<end){
         val partition = Partition(Arr,start,end)
        QuickSort_fun(Arr,start,partition-1)
        QuickSort_fun(Arr,partition+1,end)

        }


    }

    private fun Partition(arr: IntArray, start: Int, end: Int):Int {

        val pivot = arr[end] // pivot
        var i = start-1

        for (j in start until end ){

            if (arr[j]<=pivot){
                i++
                 val i_val = arr[i]
                 val j_val = arr[j]
                arr[i] = j_val
                arr[j]=i_val
            }
        }

        val end_val = arr[i+1] // 23
        arr[end] = end_val
        arr[i+1] = pivot
        return i+1





    }

}