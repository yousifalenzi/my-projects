package solvingProblems

import JustTry.Higher_Order_Function_and_Lambda.printindex

//merge sorted Tow arrays



 fun merge( merge: IntArray): IntArray {






    for (i in 1 until merge.size) {
        val dataSaveAtIndexI = merge[i]
        var current = i - 1


        while (current >= 0 && merge[current] > dataSaveAtIndexI) {

            merge[current + 1] = merge[current] //[5,5,6,3,1]
            current-- //-1


        }
        merge[current + 1] = dataSaveAtIndexI



    }
    return merge

}











fun makeMerge(array1:Array<Int>,array2:Array<Int>): IntArray { // brute force
      //merge arrays size
        val sizeTotal = array1.size+array2.size
        val NewArray:IntArray= IntArray(sizeTotal)
        var i = 0
        var j = 0
        var index= 0
        var indexsave = 0
        var arr :Array<Int>?=null



           while (i<=array1.size-1&&j<=array2.size-1){


                  if (array1[i]<array2[j]){

                      NewArray[index] = array1[i]
                      i++
                      arr= array2
                      indexsave = j
                  }
                  else{
                      NewArray[index] = array2[j]
                      j++
                      arr= array1
                      indexsave = i
                  }
                   index++
              }

            //add what items remaining
           for (ii in indexsave until arr!!.size){

               NewArray[index] = arr[ii]
               index++

           }


    return NewArray
}
fun main(){


      val intArray1 = arrayOf(4,31,32,33,55,77,88)
      val intArray2 = arrayOf(2,3,5)

    val makeMerge = makeMerge(intArray1, intArray2)


    makeMerge.forEach { print(" $it ") }



}