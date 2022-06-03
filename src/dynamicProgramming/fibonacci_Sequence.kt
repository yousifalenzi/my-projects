package dynamicProgramming

var counting  = 0
//Fibonacci Sequence with dynamic Programming
fun fib_with (n:Int): Long{
    val hash = HashMap<Int,Long>()
    hash[1]=1
    hash[2]=1
    hash[3]=2
    hash[4]=3
    hash[5]=5
    hash[6]=8
    hash[7]=13
    hash[8]=21
    hash[9]=34
    hash[10]=55


    fun fibIn(n:Int): Long {
        counting++
        return if (hash.contains(n)) hash.get(n)!!
        else{

            val i = fibIn(n - 1) + fibIn(n - 2)
            hash[n] = i
            i
        }

    }

    return fibIn(n)
}
//Fibonacci Sequence without dynamic Programming
fun fib_without (n:Int): Int{
    counting++
    return if (n<=2) 1
    else fib_without(n-1)+fib_without(n-2)

}
