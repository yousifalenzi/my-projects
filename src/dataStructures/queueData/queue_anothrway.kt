package dataStructures.queueData

class queue_anothrway (val arraysize:Int){


    var size:Int
    var front:Int
    var rear:Int
    var capcity:Int
    var array:IntArray
    var top :Int = 0


    init {
        //اسناد الحجم المدخل الى متغير الكابستي لحفظه واستخدامه
        this.capcity = arraysize
        //جعل موشر الفورنت يشير الى القيمه صفر كقيمه بدائيه
        front = 0
        rear=capcity-1
        size=0
        array=IntArray(this.capcity)

    }

    fun isFull(queue:queue_anothrway):Boolean{
         return queue.size==queue.capcity

    }

    fun isEmpty(queue:queue_anothrway):Boolean{

        return queue.size==0
    }

    fun enqueue(data:Int){
          if (isEmpty(this)){this.top  =data}
        if (isFull(this))return//if full ,stop fun
        this.rear=(this.rear+1)%this.capcity
        this.array.set(this.rear,data)
        this.size=this.size+1

    }
    fun dequeue():Int{
        if (isEmpty(this))return Int.MIN_VALUE
        val item =this.array.get(this.front)
        this.front =(this.front+1)%this.capcity
        this.size=this.size-1//4-1=3
        this.top=array[front]
        return item
    }
    fun get_Front():Int{
        if (isEmpty(this))return Int.MIN_VALUE
        return this.array.get(this.front)

    }
    fun get_Rear():Int{
        if (isEmpty(this))return Int.MIN_VALUE
        return this.array.get(this.rear)
    }
    fun showData(){

        this.array.forEach {
            println(it)
        }
    }
    fun getsize():Int{return this.size}
    fun get_the_rear():Int{return this.rear}
}