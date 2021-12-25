package dataStructures.stack

public class StackData<T> {
    //هنا لدينا اللسته التي نضع في بيانات الستاك
   var StackOfList:MutableList<T> = mutableListOf()

    fun push(i: T){

      this.StackOfList.add(i)

    }

    fun pop():kotlin.String?{

      if (IsEmpty()){

          println("NO DATA ON STACK!")
          return null
      }
        this.StackOfList.removeAt(this.StackOfList.size-1)
        return StackOfList.lastIndex.toString()

    }


    fun size ():Int= this.StackOfList.size



    fun printStackData(){

        for (stack in StackOfList.indices){

               println("i = $stack , data is :${StackOfList[stack]}")

        }

    }


    fun IsEmpty():Boolean=this.StackOfList.isEmpty()

    override fun toString(): String {
        return StackOfList.toString()
    }


}