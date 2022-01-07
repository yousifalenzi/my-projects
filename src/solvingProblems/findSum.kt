package solvingProblems
//make fun return sum of number start sum from 1 until n


fun makeSum1(sum:Int):Int{//o(n)

    var result = 0
    for (i in 1 .. sum) result+=i
    return result

}


//another solution
fun makeSum2(sum:Int):Int = sum*(sum+1)/2 // o(1)
fun main (){


    println(makeSum1(10))
}