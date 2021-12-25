package dataStructures.stack

class StackArrays<T>(var A:Array<T>) {

      private val arraystack=A
      var i = 0 //3

    fun push(value:T){
        if (IsFull()){

            println("full")
        }
        else arraystack.set(i,value)
        i++
    }

    fun pop(v:T){
        if (IsEmpty()){

            println("full")

        }


        else {
            arraystack.set(i,v)

        }

    }

    fun IsEmpty() :Boolean= this.arraystack.size==0
    fun IsFull() :Boolean= this.arraystack.size==A.size-1


     fun print(): Array<T> {
        return arraystack
    }




  }


