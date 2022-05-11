package SortAlgorthm.mmerge

import dataStructures.heap.HeapDataStructures
import java.util.*

class merge_sort_newTechne {


    fun mergeSort(arr:Array<Int>){

        MergeSort(arr,arr.size)



    }

    private fun MergeSort(array:Array<Int>, n:Int){   // L[25,8,11] R[4,12,32]

        if (n<2)return

        val mid = n/2
        val L = Array<Int>(mid,{it*1})
        val R = Array<Int>(n-mid,{it*1})

        for (i in 0 until  mid) { L[i] = array[i] }
        for (j in mid until n) { R[j-mid] = array[j] }

        MergeSort(L,mid)
        MergeSort(R,n-mid)

        merge(array,L,R,mid,n-mid)



    }

    private fun merge(a: Array<Int>, l: Array<Int>, r:Array<Int>, left: Int, right: Int) {
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
fun main (){
      val m = merge_sort_newTechne()
    val ar = Array<Int>(10000000,{it* Random().nextInt(12)})

      val merge  = m.mergeSort(ar)
//    ar.forEach {
//        print("${it},")
//    }

}