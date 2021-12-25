package dataStructures.refresh

fun main(){

val stack = stack(4)
    stack push 12
    stack push 7
    stack push 9
    stack push 25

    val factorial = factorial(10)
    println("$factorial")


}
 fun factorial(n:Int):Long{
    return if(n==1) n.toLong() else n*factorial(n-1)
}