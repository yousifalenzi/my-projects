package JustTry.Higher_Order_Function_and_Lambda

import kotlin.random.Random

fun main(){


     val p = person("yousif",28)
     p.printdata()
    run {
        p.name
    }.print()

    with(p,{//fun person

    })



}
fun String.print()= println(this)
class person(var name :String,var age: Int){

    init {
        println("From First constructor ")
    }
    constructor( name:String) : this(name, Random.nextInt(6,50)){
            println("From Second constructor ")
    }
    fun printdata()= println("my name is $name and age is $age")
}
val List<Int>.firstindex:Int
    get() {
        var ii: Int? =null
        for (i in 0..Random.nextInt(0,this.size)){

            ii = i
        }
        return this[ii!!]
    }
class human{
        var cost = 1000
        private set
        var name :String="yousif"
            set(value)  {
              field = value
                field.forEach {
                    print(it+"-")
                }
            }


   val isexpen:Boolean
   get() = cost>1000

}
class boy(var age: Int, private var name: String){


    fun read(s:String):String{

        return s+this.name
    }
}

val List<String>.lastindex:String
get() {
    val s = this[2]
    return s
}

fun Any.printindex():String{

    if (this==null) return "Nullable receiver"
    return toString()
}

class ex{

    fun indexpage(i:Int)= println("class method")
}
fun ex.indexpage()= println("Extensions")
open class book

class read:book(){

}

fun book.getname()="yousif"
fun read.getname()="ali"

fun printgetname(b:book)= println(b.getname())






class openBook(var pagenumber:Int){

    fun getPageNumber()= this.pagenumber

    fun readPage(){

        println("the page number is ${this.pagenumber}")
    }
}

fun openBook.SearchByIndex(i:Int):Int{


      val get_= i+this.getPageNumber()
       return get_


}
fun <T>MutableList<T>.swap(indx1:Int,indx2:Int){

    val tem = this[indx1]
    this[indx1] = this [indx2]
    this[indx2]= tem
}
fun <T>MutableList<T>.printData()=this.forEach { it -> println(it) }



//************//
