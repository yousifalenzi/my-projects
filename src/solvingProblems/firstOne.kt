package solvingProblems

import java.util.ArrayList


//Given 2 arrays , create a function that let's a user know(true/false) whether these tow arrays contain any
// common items


  fun commonItems1(arr1:Array<Char>, arr2:Array<Char>):Boolean{ // O(N*M)

       for(i in 0 until arr1.size){

           for(j in 0 until arr2.size){

               if (arr1[i]==arr2[j])return true
           }
       }

      return false
  } //
  fun commonItems2(arr1:Array<Char>, arr2:Array<Char>):Boolean{ //O(N)

       for (i in 0 until arr1.size){

           if (arr2.contains(arr1[i]))return true
       }

    return false
}

fun commonItems3(arr1:Array<Char>, arr2:Array<Char>):Boolean{

    val hash =HashMap<Char,Boolean>()

    for (i in 0 until arr1.size){
        val key = arr1[i]
        hash[key]=true
    }


    for (j in 0 until arr2.size){

        if (hash[arr2[j]] == true)return true
    }
    return false
}
fun commonItems4(arr1:Array<Char>, arr2:Array<Char>):List<Char>{
    var filter = listOf<Char>()
    for (i in 0 until arr1.size) {
         filter = arr2.filter { it==arr1[i] }
    }
    return filter
}
fun main(){

    val arr1 = arrayOf('a','b','d','g')
    val arr2 = arrayOf('h','y','d')


     //println(commonItems4(arr1,arr2))

    val arr3 = arrayOf('h','y','d').filter{it==arr1[2]}
    println(arr3)




}