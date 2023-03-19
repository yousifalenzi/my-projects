package solvingProblems


//Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
//
//Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

fun multiply(num1: String, num2: String): String? {

    
    //convert 
    val toCharArray = num1.toCharArray()
    val toCharArray1 = num2.toCharArray()
    
    for (i in toCharArray.indices){
        val k:Int = toCharArray[i].toInt()
        println(k)
    }
    return null 

}


fun main (){


    val toByte = "2".toByteArray()


    for (i in toByte){

         println(i)
    }


}