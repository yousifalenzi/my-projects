package sortAlgorthm.mmerge




fun main (){


//
    val arr = IntArray(6)
    arr[0] = 25
    arr[1] = 8
    arr[2] = 11
    arr[3] = 4
    arr[4] = 12
    arr[5] = 32



    //L [21,28,15]
   //[21,28]
   //[21] [28] START MERGE
   //[21,28] [15] START MERGE
   //[15,21,28] LEFT SIDE MERGED DONE

   //R [6,31,7]
   //[6,31]
   //[6] [31] START MERGE
   //[6,31] [7] START MERGE
   //[6,7,31] LEFT SIDE MERGED DONE

   //LEFT [15,21,28]   RIGHT [6,7,31]  START MERGE
   //[6,7,15,21,28,31] ALL ARRAY MERGED DONE


      val mm = merge_sort_newTechne()

      mm.mergeSort(arr)

    arr.forEach {

        println(it)
     }

}