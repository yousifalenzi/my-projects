package dataStructures.LinkedList_apply


class Node<T>(vall:T){
    var vaule :T=vall
    var nextNode:Node<T>?=null
    var previousNode:Node<T>?=null
}


class LinkedApp<T>{
    //متغير يحمل في داخله اول قية في اللسته
    private var head:Node<T>?=null

    //متغير يحمل في داخله اخر قيمة باللسته
    private var last:Node<T>?=null

    //داله لتاكد من ان اللسته فاضيه او لاا
    //وهي هل اول قيمة باللسته فاضيه /اذا فاضيه يعني لاتوجد قيم وبذلك تكون فارغه والعكس صحيح
     fun isEmpty():Boolean=head==null

    //دالة استرجاع اخر قيمه باللسته
     fun Last_():Node<T>?  = last


    //داله استرجاع اول قيمة باللسته
    fun getfirst():Node<T>? = head



    //داله الحصول على حجم اللسته
    fun getSize():Int{

        var newnode = head//تعريف متغير يحمل قيمه اول عنصر باللسته
        var count =1//البداية من واحد على افتراض انه يوجد قيمه واحده وهي اول قيمه
        if (newnode!=null){//هنا نتاكد ان اول قيمه ماهي فاضيه

            while (newnode?.nextNode !=null ){//لوب على شرط ان القيمه التي تلي اول قيمه ليست فارغه لان اذا فارغه نرجع 1
                 newnode=newnode?.nextNode // اسناد القيمه التي تلي اول قيمه للمتغير وتغير قيمته للعنصر التالي
                 count+=1//زيادة العدد بواحد
            }

         return count // ارجاع العدد الجديد بعد الانتهاء من اللوب او ارجاع واحد اذا كان شرط ان  القيمه التي تلي العنصر الاول فارغه
        }
        return 0//بحاله ان اول قيمه فاضيه نرجع صفر ونتجاهل الواحد
    }

    //get index

    fun getIndex(Index:Int): Node<T>? {//2

        val getCount = this.getSize()-1//3
        var node = head



        if (Index>getCount) throw Exception(" Out Of Lenght ")//1


             for (i in 0..Index-1){//3--3

                 node = node?.nextNode //12
                                       //6
                                       //2
                                       //22

             }
             return node
    }
    //retrun last node
    fun GetLast():Node<T>?{
        var newnode = head

        if (newnode!=null){

            while (newnode?.nextNode!=null){

                newnode=newnode?.nextNode
            }
            last=newnode
            return newnode
        }
        return null

    }
   //set vaule
    fun setVaule(value: T){

        //set new node
       val newnode = dataStructures.LinkedList_apply.Node<T>(value)
       val getlast = this.GetLast()

         if (getlast!=null){

             getlast?.nextNode = newnode
             newnode.previousNode=getlast
             last=newnode

         }
       else{
       head = newnode

       }

       }



    //remove all
    val removeAll = {head=null}

    //remove Node
    fun removeNode(Index: Int):Node<T>?{//2
        //get the index we want to remove
        val getnode = this.getIndex(Index)
             if (getnode==getfirst()) head=head?.nextNode

           else{
                 //get next and previous node for this node
                 var next=getnode?.nextNode//3
                 var previous=getnode?.previousNode//1

                 //start remove them

                 previous?.nextNode=next

                 next=null
                 previous=null

                 //تحديث قيمة اخر عنصر
                 this.GetLast()
           }


      return getnode

    }
    //remove last
//print all node data
    fun printallData(){

        var node =head
                while (node!=null){
                    print("[${node?.vaule}],")
                    node=node?.nextNode
                }

    }
    fun removelast():T?{

       var getcount = this.getSize()-1
        if (getcount<0)throw Exception("No Last AnyMore...")
        val removeNode =  removeNode(getcount)
        return removeNode?.vaule
    }


}
class LinkedList_applation<T>{
    private var head :Node<T>?=null

    var isempty:Boolean = head==null

    fun first():Node<T>?=head

    fun last() :Node<T>?{
        var node = head
        if (node!=null){
            while (node?.nextNode!=null){ node=node?.nextNode }
            return node
        }
        else return null
    }

    fun count ():Int {
        var node = head
        var counter= 1
        if (node!=null){
            while (node?.nextNode!=null){

                node=node?.nextNode
                counter++
            }
            return counter

        }else return 0

    }

    fun nodeAtIndex(index:Int):Node<T>?{
        if (index>=0){//3
            var node = head
            var i = index

            while (node!=null){
                if (i==0)return node
               i-=1
                node=node.nextNode
            }
        }
      return null

    }

    fun append(value: T){
        val newnode = dataStructures.LinkedList_apply.Node<T>(value)
        val lastnode = this.last()

        if (lastnode!=null){

            newnode.previousNode = lastnode
            lastnode.nextNode=newnode
        }
        else{

            head = newnode
        }
    }


    fun removeAll(){head=null}
    fun removeNode(node: Node<T>?): T {
        var next = node?.nextNode
        var previousnode = node?.previousNode

        if (previousnode!=null){

            previousnode.nextNode = next
        }else{

            head=next
        }

        next?.previousNode=previousnode
        node?.previousNode=null
        node?.nextNode=null

        return node?.vaule!!


    }

    fun removeLast(): T? {

        var last = this.last()
        if (last!=null ){

            return removeNode(last)
        }
        else return null
    }

    fun removeAtIndex(index:Int): T? {
        val node =nodeAtIndex(index)
        if (node!=null){

            return removeNode(node)
        }
        else return null
    }

      fun printallData(){

          var node = head
             while (node!=null){
                 print("[${node?.vaule}],")
                 node=node?.nextNode
             }

      }
}


fun main (){















}