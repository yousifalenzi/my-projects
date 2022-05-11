package SortAlgorthm.RadixSort

class RadixSort_Yousif {


      fun radixSort(arr: Array<Int>) = rdxSort(arr)


    // A utility function to get maximum value in arr[]
    private fun getMax(arr: Array<Int>): Int {
        var mx = arr[0]
        for (i in 1 until arr.size) if (arr[i] > mx) mx = arr[i]
        return mx
    }
    private fun rdxSort(array: Array<Int>){

        //find max number to can get the high digits
        val max = getMax(array)

        var exp = 1
        while (max/exp>0){

            countingSort(array,exp)
            exp*= 10
        }

    }
    private fun countingSort(array: Array<Int>, exp: Int) {
          //counter special
          var i = 0
         //Creating an array for the number counting operation
         val countingArray = Array(10){0}// [0,0,0,0,0,0,0,0,0,0]
         //Creating an output array
         val outputArray = Array<Int>(array.size){0}// [0,0,0,0,0]

         // Store count of occurrences in count[]
          while (i<array.size){
              countingArray[(array[i]/exp)%10]++
              i++
          }

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
           i = 1
            while (i<10){

                countingArray[i] += countingArray[i-1]
                i++
            }

        // Build the output array
        i = array.size - 1
        while (i>=0){
            val index = countingArray[array[i]/exp %10]-1

            outputArray[index]=array[i]

            countingArray[array[i] / exp % 10]--
            i--
        }



        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to current digit
        i = 0
        while (i < array.size) {
            array[i] = outputArray[i]
            i++
        }
    }
}

fun main (){

    val arr = arrayOf(12,1,7,5,13,89,21,25,65,23)
    val rdx = RadixSort_Yousif()
    rdx.radixSort(arr)
    arr.forEach { print("${it}, ") }
}