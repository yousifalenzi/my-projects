import java.time.Duration
import java.time.Instant
import java.util.regex.Pattern

object car{

   val name="hello"
   val get:(String)->Unit={ println(it)}
}

class boy{
    object boy1 {


          fun <T> aslist(vararg input:T): List<T> {
              val result = ArrayList<T>()
              for (item in input){
                  result.add(item)
              }
              return result
          }
        @JvmStatic fun main(args: Array<String>) {

            val aslist = boy.boy1.aslist(1, 2, 4, 5, 6, 7, 8, 8, 6, 4, 3,)
            println(aslist[3])


        }


    }
   companion object{

   }

}


open class ride{
    open fun hond(){
        println("yousif")
    }
}

class names(val name:String,val age1:Int){

    companion object{

        fun printall(vararg n:names){

            for (i in n){
                println("name is :${i.name} : age is ${i.age1}")
            }
        }
    }


}
inline fun setstudent(block: () -> Int){
    block()
}

fun main(){

   val f:String?="hello"
    println(f?.length)
    println(f?.length)


}
object Benchmark {
    fun realtime(body: () -> Unit): Duration {
        val start = Instant.now()
        try {
            body()
        } finally {
            val end = Instant.now()
            return Duration.between(start, end)
        }
    }
}
inline fun sayMyName(block:()->Unit) {


    block()
    println("hello from inline")
}


fun hashmaps(m:HashMap<Int,String>){

    for((key,value )in m){

        println("dataStructures.hashtable.Map[$key]=$value")
    }


}
fun factorial(n: Long): Long = if (n.toInt()==0 ) 1 else n * factorial(n - 1)
fun Collection<Int>.foreveryone(block: (e:Int) -> Unit){
    for ((index,value ) in this.withIndex()){
        if (index%2==0){//0%2==0
            block(value)
        }
    }
}



fun addtow(x:Int)=x+2

enum class Planet(var population: Int = 0){
    EARTH(7*100000000),
    MARS();

    override fun toString(): String ="$name[population =$population]"
}
enum class color(val rgb: Int,val colorname:String){
    RED(0xFF0000,"RED"),
    GREEN(0x00FF00,"GREEN"),
    BLUE(0x0000FF,"BLUE")
}

enum class zoo{
        COW {
            override val anmail: String
                get() = "cow"

        },FISH{
        override val anmail: String
            get() = "FISH"
    };

    abstract val anmail:String
}
enum class school(val studentname:String){
    PEN("yousif"),BOOK("omar"),CLASS("talb")
}

