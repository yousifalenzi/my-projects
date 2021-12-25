package dataStructures.queue

fun main(){

    val arr = QueueArray(4)
    arr.EnQueue(23)
    arr.EnQueue(12)
    arr.EnQueue(5)
    arr.EnQueue(6)
    arr.printData()

    println("=======")
    arr.DeQueue()
    arr.DeQueue()
    arr.DeQueue()
    arr.DeQueue()

    arr.EnQueue(5)
    arr.EnQueue(6)
    arr.EnQueue(7)
    arr.EnQueue(8)
    arr.EnQueue(19)
    arr.EnQueue(82)
    arr.EnQueue(94)
    arr.EnQueue(18)
    arr.EnQueue(43)
    arr.EnQueue(32)
    arr.EnQueue(88)
    arr.DeQueue()
    arr.DeQueue()
    arr.EnQueue(12)
    arr.EnQueue(83)

    arr.printData()









}


class the_queue_collections(list:MutableList<Any?>){

      public val queue_list= list

     //add (store) an item to the dataStructures.queue.
    fun enqueue(i:Any?){

        this.queue_list.add(i)
    }

    //remove (access) an item from the dataStructures.queue.
    fun dequeue(){

         if (isEmpty()){
             throw Exception("IS EMPTY <NO DATA AV")

         }else{

             this.queue_list.remove(this.queue_list.first())

         }

    }

    // Gets the element at the front of the dataStructures.queue without removing it.
    fun Peek(): Any = (if (isEmpty())throw Exception("no data")else {this.queue_list.first()})!!

    //Get the number of elements in the Queue
    fun getsize():Int= this.queue_list.count()

    // Checks if the dataStructures.queue is empty

    fun isEmpty():Boolean = this.queue_list.isEmpty()

    //convert list to string for print it
    override fun toString(): String=this.queue_list.toString()

    //print data by index
    fun PrintDataByIndex(){

        for (items in queue_list.indices) println("$items / ${queue_list[items]}")//O(N)
    }

}
class the_queue_Arrays(){

     private var capcity = 6
     private var arr:IntArray=IntArray(this.capcity)
     private var front= 0
     private var rear=-1
     private var currentSize = 0

    //add (store) an item to the dataStructures.queue.
    fun enqueue(i:Int){

    if (isFull()){

        println("Is Full,")//size 4
       increaseDataCapaCity()

    }

        rear++//4

        if (rear>=arr.size&& currentSize==arr.size){
            rear=0
        }

        arr[rear]=i//rear = 0 , 1 , 2,3
        currentSize++//1,2,3,4
    }
     fun returnFront():Int=this.front

    private fun increaseDataCapaCity(){
         //حددنا الحجم الجديد وهو ضعف الحجم السابق
        val newcapacity = this.arr.size*2
        //عرفنا مصفوفه جديده واسندنا لها حجمها الجديد
        val newArray = IntArray(newcapacity)

        for (item in this.arr.indices){

            newArray[item] = this.arr[item]
        }

        this.arr=newArray

    }


    private fun increaseCapacity() {
        //create new array with double size as the current one.
        val newAarrCapcity=this.arr.size*2//12
        val newarray=IntArray(newAarrCapcity)//12

        //copy elements to new array, copy from rear to front
        var tempfront = front //0
        var index = -1

        while (true){
            newarray[++index] = this.arr[tempfront]//newarray[0] =arr[0] until new elment
            tempfront++

            if(tempfront==this.arr.size){//5=5
                tempfront=0
            }



            if(currentSize===index+1){
                break
            }



        }

        //make new array as dataStructures.queue
        this.arr = newarray
        this.front=0
        this.rear=index
    }

    //remove (access) an item from the dataStructures.queue.
    fun dequeue(){

      if (isEmpty()){
          println("Is Empty DATa")
      }
        else{
       front++//1

          if(front>arr.size-1){
              println("front become 0")
              println("removed=${arr[front-1]}")
              front= 0

          }else{
              println("removed=${arr[front-1]}")
          }

          currentSize--
        }

    }

    // Gets the element at the front of the dataStructures.queue without removing it.
     fun peek():Int?{
         if(isEmpty()){
             println("Is Empty DATa")
            return null
         }
        else{

            return this.arr[front]
        }
     }

    fun getsize():Int= currentSize
    // Checks if the dataStructures.queue is empty
    fun isEmpty():Boolean=currentSize==0
    // Checks if the dataStructures.queue is full
      fun isFull():Boolean=currentSize===this.arr.size

    //convert list to string for print it


    //print data by index
    fun PrintDataByIndex(){
       for (items in this.arr.indices)println("$items / ${arr[items]}")

    }



}


