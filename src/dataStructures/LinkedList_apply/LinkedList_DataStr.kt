package dataStructures.LinkedList_apply

class node_data <T>(var data:T){

    var next:node_data<T>?=null
    var prev:node_data<T>?=null
    private var vaule = data
    var index:Int?=null



}
class LinkedList_DataStr {

    private var Head:node_data<Int>?=null//متغير يتم وضعه في اول عنصر في اللسته المترابطه ويسمى بالرأس
    private var Rear:node_data<Int>?=null//متغير يتم وضعه في اخر عنصر في اللسته المترابطه ويسمى الذيل


    fun isEmpty():Boolean=Head==null//داله لتحديد هل اللسته المترابطه فارغه

    fun getLast(): node_data<Int>? =Rear//داله لاسترجاع الذيل

    fun getFirst():node_data<Int>?=Head//داله لاسترجاع الراس

    //داله لاسترجاع عدد عناصر اللسته المترابطه
    fun getSize():Int{
        var count = 1//تهيئه متغير افتراضي بالرقم 1
        var newnode = Head // اخذنا عنوان الراس ووضعناه في متغير جديد يحمل صفاته

        if (newnode!=null){ // قمنا بعمل شرط هل القيمه التي تحمل قيمه الراس ليست فارغه


            while (newnode?.next!=null){//عمل لوب على القيم التي تلي الراس والتاكد انها ليست فارغه
                newnode=newnode.next//تغير المتغير بعنوانين التي تتبع الراس باستمرار حتى يصبح الشرط غير صحيح
                count++ // التزويد بواحد لكل عمليه اسناد حتى يتنسى لنا معرفه عدد العناصر الموجوده
            }

            //يتم اعادة 1 اذا كان لدينا قيمه واحده في المتغير الراس
            //يتم اعادة اكثر من 1 اذا كانت القيمه التاليه للراس ليست فارغه
            return count
        }
        //يتم اعادة صفر في حاله الراس لاتوجد فيه قيمه وفارغه
        return 0

    }

      //داله ترجع لك النود على حسب رقم الاندكس
    fun getByIndex(index:Int):node_data<Int>?{

         var k = 0 // متغير قابل للتغير في كل مره
         val count = getSize()-1 //متغير يتم اسناد اليه القيمه المسترده من داله الحصول على الحجم ناقص 1
         var head = Head // متغير للحصول على قيمه الرأس
        if (index>count)throw Exception("سقها يامعود")  // في حاله الاندكس المدخل اكبر من عدد حجم اللسته المترابطه يقوم بالغاء العمليه

            for (cou in 0..index-1){
                head=head?.next//6-2-22-87

                k++
            }

        head?.index= k
          return head
    }

    fun addData(i:Int){//O(1)
        var changable = Rear
        val newnode = node_data<Int>(i)
        if(Head==null){
            Head=newnode
            Rear=newnode
        }

        else{

            changable?.next=newnode
            newnode.prev=changable
            changable=newnode
            Rear=newnode

        }



    }
    fun removeAtIndex(index:Int):node_data<Int>?{
          // هنا نحصل على النود المراد حذفها عن طريق رقم الاندكس
        val getNode = getByIndex(index)//the node we want remove it
        val i = getNode?.index
        val nexthead= Head?.next// //خذ النكست حقها وعينه في متغير جديد

        val nextNode= getNode?.next//get the next node for the node we want remove it
        val prevNode= getNode?.prev//get the prev node for the node we want remove it

        //عندنا احتمالين ان تكون الهيد او مابعد الهيد
        //اذا كانت الهيد
        if (getNode==Head){
            //اجعل الهيد تساوي القيمه الجديده
             Head=nexthead
            //اجعل قيمه البرفرس تساوي null
             nexthead?.prev=null
            nextNode?.index= i
            return nextNode
        }

        else{
                       if (nextNode==null)Rear = prevNode
                   // next null
                   //prev =22
                    nextNode?.prev=prevNode
                    prevNode?.next=nextNode




            return getNode
        }
    }

     fun DisplayData(){
         var head = Head
         if (head!=null){

            while (head!=null){
                println("Vaule(${head.data})")
                println("*previous(${head.prev?.data}) \n *Next(${head.next?.data})")
                println("_______________________")

                head=head.next
            } } }


    //remove all
    fun removeAll() = {Head=null}
}

fun main(){


    val linked = LinkedList_DataStr()
    linked.addData(12)//
    linked.addData(6)
    linked.addData(2)
    linked.addData(22)
    linked.addData(87)
    linked.addData(54)

     val re = linked.removeAtIndex(5)

    linked.DisplayData()


    println("head ${linked.getFirst()?.data}")
    println("last ${linked.getLast()?.data}")
    println("size ${linked.getSize()}")
    println("the index remove it was ${re?.index}")



}