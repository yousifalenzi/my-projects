package dataStructures.refresh


class stack(size :Int) {

    var size :Int // the size of dataStructures.stack
    var dataarray:IntArray // array that hold all numbers
    var top: Int  //array out of memory


    init {

        this.size=size //init the size
        this.dataarray=IntArray(this.size!!) // Assignment the size to array
        this.top=-1
    }




     infix fun push(value:Int){

         if (isfull()){

             println("Full data")
         }else{

           dataarray.set(++top,value)
         }

     }
     fun pop():Int{
        val t = top
         if (isempty()){

             println("empty data")
         }
         else{


             top--
         }
         return dataarray.get(t)
     }
    fun isfull():Boolean{

        return top==dataarray.size-1//4-1=3 ,, top 3


    }
    fun isempty():Boolean{
        return top==-1
    }
    fun print(){
        for (i in 0 until dataarray.size){
            println("index=$i = ${dataarray.get(i)}")
        }
    }

}