package SortAlgorthm.mmerge

/* Java program for Merge Sort */
class MergeSort {
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    fun merge(arr: Array<Int>, start: Int, mid: Int, end: Int) {
        // Find sizes of two subarrays to be merged // mid =0 , end = 1
        val size_for_left = mid - start + 1 // 1
        val size_for_right = end - mid // 1

        /* Create temp arrays */
        val LEFT_SIDE_ARRAY = IntArray(size_for_left) //size = 1
        val RIGHT_SIDE_ARRAY = IntArray(size_for_right) // size = 1

        /*Copy data to temp arrays*/

        for (i in 0 until size_for_left) LEFT_SIDE_ARRAY[i] = arr[start+i] //0
        for (j in 0 until size_for_right) RIGHT_SIDE_ARRAY[j] = arr[mid +1+ j]//







        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        var i = 0
        var j = 0

        // Initial index of merged subarray array
        var k = start
        while (i < size_for_left && j < size_for_right) {
            if (LEFT_SIDE_ARRAY[i] <= RIGHT_SIDE_ARRAY[j]) { // 21 < 28
                arr[k] = LEFT_SIDE_ARRAY[i]   // k = [21]
                i++ // 1
            } else {
                arr[k] = RIGHT_SIDE_ARRAY[j]
                j++
            }
            k++
        }

        /* Copy remaining elements of L[] if any */
        while (i < size_for_left) {
            arr[k] = LEFT_SIDE_ARRAY[i]
            i++
            k++
        }

        /* Copy remaining elements of R[] if any */
        while (j < size_for_right) {
            arr[k] = RIGHT_SIDE_ARRAY[j]
            j++
            k++
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    // [5,8,1,9,3,0,22,14,17]
    fun sort(arr: Array<Int>, startpoint: Int, endpoint: Int) { // start = 0 , end = 8
        if (startpoint < endpoint) {
            // Find the middle point
            val mid = startpoint + (endpoint - startpoint) / 2

            // Sort first and second halves
            sort(arr, startpoint, mid)
            sort(arr, mid + 1, endpoint)//[mid+1 , 5]
            // Merge the sorted halves
            merge(arr, startpoint, mid, endpoint)
        }
    }

    companion object {
        /* A utility function to print array of size n */
        fun printArray(arr: Array<Int>) {
            val n = arr.size
            for (i in 0 until n) print(arr[i].toString() + " ")
            println()
        }


    }
}
/* This code is contributed by Rajat Mishra */
