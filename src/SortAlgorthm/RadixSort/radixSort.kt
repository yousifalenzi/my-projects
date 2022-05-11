package SortAlgorthm.RadixSort

import java.util.*


class radixSort {

    // A utility function to get maximum value in arr[]
    fun getMax(arr: IntArray, n: Int): Int {
        var mx = arr[0]
        for (i in 1 until n) if (arr[i] > mx) mx = arr[i]
        return mx
    }
    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    fun countSort(arr: IntArray, n: Int, exp: Int) {
        val output = IntArray(n) // output array
        var i: Int
        val count = IntArray(10)
        Arrays.fill(count, 0)

        // Store count of occurrences in count[]
        i = 0
        while (i < n) {
            count[arr[i] / exp % 10]++
            i++
        }

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        i = 1
        while (i < 10) {
            count[i] += count[i - 1]
            i++
        }

        // Build the output array
        i = n - 1
        while (i >= 0) {
            output[count[arr[i] / exp % 10] - 1] = arr[i]
            count[arr[i] / exp % 10]--
            i--
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to current digit
        i = 0
        while (i < n) {
            arr[i] = output[i]
            i++
        }
    }



    // The main function to that sorts arr[] of size n using
    // Radix Sort

    fun radixsort(arr: IntArray, n: Int) {
        // Find the maximum number to know number of digits
        val m = getMax(arr, n)// 21

        // Do counting sort for every digit. Note that
        // instead of passing digit number, exp is passed.
        // exp is 10^i where i is current digit number
        var exp = 1
        while (m / exp > 0) {
            countSort(arr, n, exp)
            exp *= 10
        }
    }

    // A utility function to print an array
    fun print(arr: IntArray, n: Int) {
        for (i in 0 until n) print(arr[i].toString() + " ")
    }
}

private fun isPrime (n:Int):Boolean{
    val nn = n/2
    for (i in 2 .. nn){

        if (n%i==0)return false
    }
    return true
}
fun main(args: Array<String>) {
//    val radix = radixSort()
//    val arr = intArrayOf(4,7,9,60,3,7)
//    val n = arr.size
//
//    // Function Call
//    radix.radixsort(arr, n)
//    radix.print(arr, n)

//      val i = 93
//       var exp = 1
//
//    while(i/exp>0){
//        println(" digit at $exp = ${(i/exp)%10}")
//        exp *= 10
//    }


//
//      val arr = arrayOf(2,3,5,7,11,13)
//
//    for (i in 0 until arr.size){
//
//        if (!isPrime(arr[i])) {
//            arr[i] = 0
//
//        }
//
//    }
//
//   arr.forEach { print("${it},") }




}