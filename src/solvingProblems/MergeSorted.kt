package solvingProblems

import sortAndsearch_Algorthm.binarySearch.Binary_khanway

//merge sorted Tow arrays



 fun merge( merge: IntArray): IntArray {

       // [2,4,6,8],[3,5,9,10]




    for (i in 1 until merge.size) {// [5,2,6,3,1]
        val dataSaveAtIndexI = merge[i] //2
        var current = i - 1 //0


        while (current >= 0 && merge[current] > dataSaveAtIndexI) {

            merge[current + 1] = merge[current] //[5,5,6,3,1]
            current-- //-1


        }
        merge[current + 1] = dataSaveAtIndexI



    }
    return merge

}


//save element at index i [2,5,6,3,1]}








fun makeMerge(array1:Array<Int>,array2:Array<Int>): IntArray { // brute force
      //merge arrays size
       val sizeTotal = array1.size+array2.size
       val NewArray:IntArray= IntArray(sizeTotal)





    //operations
    var LastItem_array1 =array1[array1.size-1]
    var LastItem_array2 =array2[array2.size-1]
    var While_Index=sizeTotal-1 // 9
    var i_array1 =array1.size-2
    var j_array2 =array2.size-2


    while (While_Index>0&&(!(i_array1 == -1 && j_array2 == -1))){

          if (LastItem_array1>LastItem_array2){
              NewArray[While_Index] = LastItem_array1
              While_Index--
              LastItem_array1=array1[i_array1]
              i_array1--
          }

          else{
              NewArray[While_Index] = LastItem_array2
              While_Index--
              LastItem_array2=array2[j_array2]
              j_array2--
          } }

    if (array1[i_array1+1]<array2[j_array2+1]){

        NewArray[i_array1+1]=array1[i_array1+1]
        NewArray[i_array1+2]=array2[j_array2+1]
    }
    else{

        NewArray[i_array1+1]=array2[i_array1+1]
        NewArray[i_array1+2]=array1[j_array2+1]
    }

   return NewArray
}
fun main(){


      val intArray1 = arrayOf(5,8,9,12,15,17)
      val intArray2 = arrayOf(0,7)

    val makeMerge = makeMerge(intArray1, intArray2)
    val binary = Binary_khanway()

    val applyBinarysearch = binary.apply_BinarySearch(5, makeMerge)

    makeMerge.forEach { print(" $it ") }
   print("\n we found it in index $applyBinarysearch")


}