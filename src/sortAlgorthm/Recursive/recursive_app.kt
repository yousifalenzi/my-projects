package sortAlgorthm.Recursive





    fun Recursive_LinearSearch(A: Array<Int>, i:Int, x:Int){

        if (i >A.size-1) return println("Not Found ")
        else if (A[i]==x)  println(i)
        else  Recursive_LinearSearch(A,i+1,x)



    }


 fun main(args:Array<String>){


      val arr = arrayOf(3,5,7)
     Recursive_LinearSearch(arr,0,1)




 }