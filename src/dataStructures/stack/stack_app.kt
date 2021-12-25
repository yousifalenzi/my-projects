package dataStructures.stack

fun main(){
  val s = stack<String>()
    s.push("yousif")
    s.push("hello")
    s.pop()
    s.push("adres")

    println( s.toString())
    println( s.peek())
    s.pop()
    s.pop()
    s.pop()
    println( s.toString())
    s.push("google")
    println( s.toString())

}

class stack<T>(){

    var list:MutableList<T> = mutableListOf()

     //pop an element of the Stack, i.e. the Top element
    fun pop(): T? {
        if (isEmpty()){
            println("IsEmpty")
        }else{

            list.removeAt(list.size-1)
        }
         return list.lastOrNull()
    }
    //push an element onto the Stack
    fun push (i:T){

        list.add(i)
    }

    //"peek" at the very top element, i.e. return the Top element
    fun peek(): T? = list.lastOrNull()

    //return a boolean that determines whether the Stack is currently empty or not
    fun isEmpty()=list.isEmpty()

    //return the current size of our Stack
    fun getSize():Int=list.size


    override fun toString(): String = list.toString()
}