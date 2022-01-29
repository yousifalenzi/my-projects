package dataStructures.stackarray

class StackArrayList<T>{

    private var top :T?=null
    private var bottom :T?=null
    private var stackArray = ArrayList<T?>()
    fun getFirstIn():T?= this.bottom
    fun getLastIn():T?= this.top

    fun push(data:T?){

        if (stackArray.isEmpty()){

            stackArray.add(data)
            this.top = stackArray[stackArray.size-1]
            this.bottom = this.top
        }
        else{
            stackArray.add(data)
            this.top = stackArray[stackArray.size-1]
        }

    }

    fun pop():T?{
        return if (stackArray.isNotEmpty()){
             val data = stackArray[stackArray.lastIndex]
            stackArray.removeAt(stackArray.lastIndex)
            this.top = stackArray[stackArray.lastIndex]
            data
        }else
         null
    }

    fun peek():Boolean{
        var leg = stackArray.size
         return if (stackArray.isNotEmpty()){
             for (item in stackArray.reversed()){
                 println(" (${leg})[${item}] ")
                 leg--
             }
             true
         }else false

    }
}