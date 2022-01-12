package JustTry.Higher_Order_Function_and_Lambda



fun main(){

//  "king".high<String,Int> {
//       println(this.toUpperCase())
//      12
//  }

//    val h = JustTry.Higher_Order_Function_and_Lambda.Higher_Order_Function_and_Lambda_class()
//      h.doing<String> {
//          "yousif".tocamel()
//
//      }

}
fun String.pr()= println(this)

fun <T,R> T.high(block:T.()->R){

    println(this.block())
}

val f:(Int,String)->String = {int,str->""}
val range1:(Int,Int)->Int={i,o ->i+o}
fun hi(i:Int,o:Int):Int {

    return i+o
}

fun math(block:(p1: Int)->Unit){block(7)}
fun plus(i:Int):Int{
    return i*3
}
 fun read(Block:(i:Int)->String):String{

     return Block(23)
 }
fun food(order: (Int) -> Unit) {

     order(2)
}
fun div(math_:(I:Int)->Int):Int{
      val math_1 = math_(2)
    return math_1
}

fun doSomething(g:(i:String)->Unit){
    g("hello form kotlin ")
}
interface apply:()->Unit{
    override fun invoke()

}
interface food:(String)->Unit{
    override fun invoke(i:String)
}

fun dosum(lambdaE:(s:String)->Unit){
    lambdaE("yousif")
}


//Lambda syntax
val zoo:(Int)->String={i->"$i "}
val loop :(Int,String)->Unit={x,d-> println("Hello $x and $d")}


//Extension function
fun func(bl:Int.()->Int){

    println(1.bl())
}
fun String.tocamel(): String {
      return toUpperCase()
}
inline fun <T>under(Block:String.(i:Int)->T){

    println("yousif".Block(2))
}
inline fun <T,R> extension(t:T,Block:T.()->R){

    println(t.Block())

}


