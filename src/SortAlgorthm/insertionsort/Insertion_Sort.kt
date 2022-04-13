package sortAndsearch_Algorthm.insertionsort

class Insertion_Sort {


    fun insertionSort(arr:IntArray):IntArray{

         for (i in 1 until arr.size){

             val element =arr[i]
             var j=i-1//2
             while (j>=0&& arr[j]>element){//2

                 arr[j+1]=arr[j]
                 j--//1
             }
             arr[j+1] = element
         }

        return arr
    }

    fun Insertion_Sort_2(arr:IntArray):IntArray{

        var key:Int
        var j = 0

        for (i in 1..arr.size-1){
            key=arr[i]
            j=i-1
            while (j>=0&& arr[j]>key){
                arr[j+1]=arr[j]
                j--

            }
            arr[j+1]= key
        }


        return arr
    }
}