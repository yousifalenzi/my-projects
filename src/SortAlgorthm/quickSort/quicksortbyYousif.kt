package SortAlgorthm.quickSort



fun quickSort_byYousif(array: Array<Int>,start:Int,End:Int){ // [13,1,7,8]
    if(start<End){

        val partition = partition(array,start,End) //[13,1,7,8] , 0 , 3
        quickSort_byYousif(array,start,partition-1)
        quickSort_byYousif(array,partition+1,End)

        // [1,2,5]
    }




}
private fun swap(arr: Array<Int>,pointer:Int,counter:Int){

    val data =  arr[pointer]
    arr[pointer] = arr[counter]
    arr[counter] = data
}
private fun partition(arr:  Array<Int>, low: Int, high: Int):Int {


       val pivot = arr[high] // select pivot
       var pointer =low-1
       var counter =low

    while (counter<=high){

        if (arr[counter]<pivot){

            pointer++
            swap(arr,pointer,counter)
        }


        counter++
    }

         swap(arr,pointer+1,high)
         return pointer+1
}

fun main (){

    val arr = arrayOf(7,5,11,13,3,1)
    quickSort_byYousif(arr,0,arr.size-1)
    for (value in arr){

        print("$value , ")
    }

}