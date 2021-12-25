package sortAlgorthm.mmerge

class merge_sort_newTechne {


    fun mergeSort(arr:IntArray){

        MergeSort(arr,arr.size)
    }

    private fun MergeSort(array:IntArray, n :Int){   // L[25,8,11] R[4,12,32]

        if (n<2)return

        val mid = n/2
        val L = IntArray(mid)
        val R = IntArray(n-mid)

        for (i in 0 until  mid) { L[i] = array[i] }
        for (j in mid until n) { R[j-mid] = array[j] }

        MergeSort(L,mid)
        MergeSort(R,n-mid)

        merge(array,L,R,mid,n-mid)



    }

    private fun merge(a: IntArray, l: IntArray, r:IntArray, left: Int, right: Int) {
        var i = 0
        var j = 0
        var k = 0
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++]
            } else {
                a[k++] = r[j++]
            }
        }
        while (i < left) {
            a[k++] = l[i++]
        }
        while (j < right) {
            a[k++] = r[j++]
        }
    }
}