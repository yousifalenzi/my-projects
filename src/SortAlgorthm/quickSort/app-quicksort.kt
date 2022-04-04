package SortAlgorthm.quickSort

fun main(){


    val inta = IntArray(6)
      inta.set(0,12)
      inta.set(1,11)
      inta.set(2,3)
      inta.set(3,6)
      inta.set(4,17)
      inta.set(5,7)



      val quick = geeks_quickSort()
     quick.QuickSort(inta,0,inta.size-1)
      inta.forEach { println(it) }



}