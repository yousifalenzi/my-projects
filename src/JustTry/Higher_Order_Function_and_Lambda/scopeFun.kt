package JustTry.Higher_Order_Function_and_Lambda

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

fun main(){

    val car1=car("toyota")
    val car2=car("ford")
    val car3=car("Chevrolet")
    val car4=car("nissan")
    val car5=car("honda")

     car1.LET {
         it.setname("AZERA")
         it

     }.print_Info()
    car2.apply_ {

        this.setname("VAN")
    }.print_Info()

   car3.Also_ {
       it.setname("DOge")
   }.print_Info()
   car4.Run {
      setname("corolla")
        this
   }.print_Info()


   With(car5,{
     setname("Sonata")
       this
   }).print_Info()


}
inline fun <T,R>With(receiver:T,block: T.() -> R):R{
    return receiver.block()
}
open class openbook:(String)->Unit{
    override fun invoke(p1: String) {
        println(p1.uppercase())
    }



}
class car( var name:String){



    val getname:()->String={this.name}
    val setname:(String)->Unit={this.name=it}
    val print_Info:()->Unit= { println(this.name.uppercase()) }
    fun getfood(s:String,block:(String)->Unit){

        block(s)
    }
}


fun String.println1() {

  println(this.uppercase())
    for (i in 0..this.length-1){

        print(this[i].titlecase()+" ")
    }
}
inline fun <T,R>T.Run(block: T.() -> R):R{

    return block()

}
inline fun <T,R>T.RUN(block: T.() -> R):R{
    return block()

}
inline fun <T>T.apply_(block:T.()->Unit):T{
    block()
    return this
}

inline fun <T>T.Also_(block: (T) -> Unit):T{
     block(this)
    return this
}




inline fun <T> T.callExtensionLambdaAndReturnSelf(block:T.()->Unit){

   block()
}
inline fun <T,R> T.LET(block: (T) -> R):R{
    return block(this)


}
inline fun <T>T.callMyAnonymousLambda(block: (T) -> Unit){
    block(this)
}
data class person1(var name:String,var age:Int){
    fun printData()= println(this.toString())
}

@OptIn(ExperimentalContracts::class)
inline fun <T> T.Ourapply(block: T.() -> Unit) :T{
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    block()
    return this

}
fun String.println()= println(this)

inline fun <T,R> T.showdata(block:(T)->R):R{
       return block(this)
}
inline fun <T,R> T.read(block: (T) -> R):R{
    return block(this)
}

val lambdaExpration:(Int,Int)->Int={i1,i2->i1+i2}
