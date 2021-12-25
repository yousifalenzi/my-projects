package dataStructures.refresh_queue


fun main(){
val anonymousclass = object :shop{


    override fun invoke(i: Int) {
        println(i)
    }

}

Test({ anonymousclass(3) })
}
fun pr(){
    println("Hello number")
}
fun Test(name:()->Unit){
    name()
}

interface shop:(Int)->Unit{
    override fun invoke(i:Int)
}