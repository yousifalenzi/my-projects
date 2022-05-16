package dataStructures.queueData

class queue <T>(size:Int){

    var front :Int
    var rear :Int
    var sizequeue :Int
    var arrayqueue:IntArray
    var toList:MutableList<Int>

    init {
        this.sizequeue = size
        front =0
        rear = -1
        arrayqueue =IntArray(this.sizequeue!!)
        toList= this.arrayqueue.toMutableList()

    }

   //add
    fun enqueue (data:Int){

       if (isfull()){
           println("Is Full.")
       }
       else{
           rear++//size 3 == rear
           toList.set(rear,data)
       }


    }


   //remove
    fun dequeue(){
       if (isempty()){
           println("EMPTY")
           rear=-1
       }
       else{
           toList.removeAt(front)
           front++
           rear--
       }

   }
    fun display(){
        var i = -1


        toList.forEach {
            i++
            println("$it .. index = $i")
        }
    }
    fun peek():Int{
        return arrayqueue.get(front)
    }
    fun isempty():Boolean{

        return rear==0

    }
    fun isfull():Boolean{

        return toList.size == rear+1//3
    }

}