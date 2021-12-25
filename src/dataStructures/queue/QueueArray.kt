package dataStructures.queue

class QueueArray(var cap:Int) {

    private var capcity=cap
    public var Qarray:IntArray=IntArray(capcity)
    private var front = 0
    private var rear = -1
    private var currentsize= 0
    private var data:Int? =null
    private var realsize=cap


    fun EnQueue(i:Int){

        if (IsFull()) IncreaseSize()

        rear++
        Qarray[rear] = i
        currentsize++

    }
    private fun IncreaseSize() {
         //انشاء المصفوفه واسناد الحجم
            val Arr =IntArray(realsize++*2)
        //لوب لجمع القيم القديمه مع الجديده
        for (item in Qarray.indices){

            Arr[item]=Qarray[item]
        }
        //تغير تعريف المصفوفه في الذاكره بالمصفوفه الجديده
        this.Qarray = Arr
    }
    private fun IncreaseCapCity(){
        val size = this.Qarray.size*2
        var newArray = IntArray(size)


        var temfront = front
        var index = -1

        while (true){
            newArray[++index] = this.Qarray[temfront]//Qarray = 4

            //0
            //1
            //2
            //3
            //4
            temfront++

            if (temfront==this.Qarray.size){
                temfront = 0
            }
            if (currentsize==index+1){//current = 4 , index =1 ,2,3,4
                break
            }


        }

        this.Qarray = newArray
        front = 0
        rear = index


    }

    fun DeQueue():Int?{


        if(IsEmpty()) throw Exception("Array is Empty")

        else
        {
             removeData(front)




            currentsize--//3,2,1,0,-1
            if (currentsize==0)
                front=0


        }

      return data
    }

    fun peek():Int?{
        if (!IsEmpty())return this.Qarray[front]
        else return null
    }
    fun removeData(inx:Int){

        val toList =this.Qarray.toMutableList()//2,4,5,7
         toList.removeAt(inx)//index(0),4,5,7
         val newArr = toList.toIntArray()
         this.Qarray = newArr
        rear--

    }
    fun IsEmpty():Boolean = this.currentsize==0
    fun IsFull():Boolean = this.Qarray.size==currentsize
   fun getSize():Int=this.Qarray.size
     fun printData() {
        for (data in Qarray.indices){

            println("($data) = [${this.Qarray[data]}]")
        }
    }



}