package dataStructures.stack
open class info(var n :String,var g:Int){

    var name:String?=n
     var age :Int?=g

}
fun get (i:info){

    print(i)
}
object Info1{

    var name:String?=null
}
class array(val arrr:IntArray){

    val arr = arrr


    fun add(i:Int){
          var yi=-1
        arr.set(++yi,i)
    }

    //1. Using MutableList to Remove
    fun remove(arr:IntArray,i:Int):IntArray{
           if (i<0||i>=arr.size){
               throw Exception()
           }

        val result = arr.toMutableList()
         result.removeAt(i)
        return result.toIntArray()
    }
}
fun main () {
    Info1.name="google"
     val stc = Array<Any>(4){}

     val stackarr = StackArrays<Any>(stc)
    stackarr.push("yousif")
    stackarr.push(12)
    stackarr.push(Info1.name!!)
    stackarr.push(object :info("kaka",33){}.n)

    val gett = stackarr.print()
    for (any in gett) {
        println(any)
    }

}