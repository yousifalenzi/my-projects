package SortAlgorthm.Recursive


class recursive{




    fun fibonacciIterative(num: Int): Int {


          val arry= mutableListOf<Int>()
        arry.add(0)
        arry.add(1)

        for (i in 2 until num+1){   //[0,1]

            arry.add(arry[i-2]+arry[i-1])//[0,1,1,2,3]
        }
        return arry[num]

    }
    fun fibonacciRecursive(num: Int):Int{

           if(num<2)return num

        return fibonacciRecursive(num-2)+fibonacciRecursive(num-1)
    }

    fun factorialIterative(num: Int): Int {
        if (num<0)return  0
        if(num==2||num==1)return num



        var facotr = 1
        for (i in num downTo 2 step 2){
            facotr=facotr*(i*(i-1))
        }
        return facotr
    }
    fun factorialRecursive(num:Int):Int{

             if (num==2||num<2)return num
            return num*factorialRecursive(num-1)


    }
    fun SearchRecursive(A: Array<Int>, index:Int, targetVale:Int){

        if (index >A.size-1) return println("Not Found ")
        else if (A[index]==targetVale)  println(index)
        else  SearchRecursive(A,index+1,targetVale)



    }
    fun recursiveString(str: String):String{//u

          if (str=="")return ""
          else{

              return recursiveString(str.substring(1))+str[0] // you
          }

    }
     fun reversStr(input: String): String? {

         val str: CharArray = input.toCharArray() // [y,o,u]


         val length = str.size //3


         var res: String? = str[str.size - 1].toString() + "" //res[u]



         if (length <= 1) return str[0].toString() + ""

         res += reversStr(input.substring(0, length - 1))
         return res
     }
    fun reverseStringIteration(str:String): String {
             var current = ""
            for (i in str.length-1 downTo 0 ){

                current+=str[i]
            }
        return current

    }

}


 fun main(){

     val re =recursive()
      println(re.reversStr("you"))
 }