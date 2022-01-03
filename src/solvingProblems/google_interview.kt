package solvingProblems

import kotlin.collections.HashSet

//given a collections  numbers , need you take this collections of numbers and find matching pair that equal to sum

//[1,2,3,9] sum = 8
//[1,2,4,4] sum = 8

//if was is sorted
fun hasPairsWithSum1(arry: Array<Int>, sum:Int):Boolean{

       val last = arry[arry.size-1]
       val size=arry.size


    for (i in 0 until size){ // o(n)

       if(arry[i]+last==sum)return true
    }

    return false
}
fun hasPairsWithSum2(arry: Array<Int>, sum:Int):Boolean{// o(n)

    //    val arr2 = arrayOf(1,2,4,4)

    var low =0
    val high=arry.size-1

    while (low<high){

        if (arry[low]+arry[high]==sum)return true
         low++
    }
    return false
}



//if was isn't sorted
  fun hasPairsWithSum3(arry: Array<Int>, sum:Int):Boolean{

      val size = arry.size
       //arrayOf(1,2,4,4)
    for (i in 0 until size){

        for (j in i+1 until size){

            if (arry[i]+arry[j]==sum)return true
        }
    }
      return false
  }
  fun hasPairsWithSum4(arry: Array<Int>, sum:Int):Boolean{

      val hashSet =HashSet<Int>() // arrayOf(1,2,4,4)
      val len = arry.size

      for (i in 0 until len){
          if (hashSet.contains(arry[i]))return true
           hashSet.add(sum-arry[i])
      }

      return false
  }
fun main(){
                                  //13
    val arr2 = arrayOf(1,8,5,6) // 12, 5 ,




}