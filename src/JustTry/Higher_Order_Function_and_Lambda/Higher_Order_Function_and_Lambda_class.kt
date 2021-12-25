package JustTry.Higher_Order_Function_and_Lambda

class Higher_Order_Function_and_Lambda_class {

     // Higher_Order_Function
     inline  fun printNumbers(printN:(n:String)->String){

         val printN1 = printN("yousif")
     }

    inline  fun getname(getnames:(i:Int)->Unit){
        getnames(0)
    }

    infix fun makesNumber(n:Int){
        println("hello $n")
    }

    inline fun run (block:()->Unit){
        block()

    }
    inline fun <R> doing(block: () -> R){
       println(block())
    }
}