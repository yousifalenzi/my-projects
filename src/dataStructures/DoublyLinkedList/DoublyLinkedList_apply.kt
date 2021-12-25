package dataStructures.DoublyLinkedList

class DoublyLinkedList_apply<T> {

    private var First: Node<T>?=null
    private var Last: Node<T>?=null
    private var NumberOfData=0
    private var sizeLinked = 0
    private var index = 0



    fun size():Int = NumberOfData
    private fun isEmpty():Boolean{

        return (First==null)
    }



    fun addFirst(data:T){
        sizeLinked++//1

        var newNode=Node<T>()
        newNode.data=data
        newNode.index=index
        if (isEmpty()){ Last=newNode}
        else{ First?.previous=newNode }

        newNode.Next=First
        First=newNode
        index++
        NumberOfData++


    }
    fun addFirst2(data: T){

        val newNode=Node<T>()
        newNode.data = data

        if (isEmpty()){
            Last=newNode
        }
        else{
            First?.previous = newNode
        }

        newNode.Next=First
        First=newNode
    }
    fun insertlast(data:T){

        val newNode=Node<T>()
        newNode.data = data
          if (isEmpty()){

              First=newNode
              sizeLinked++
          }
        else{
              sizeLinked++

              Last?.Next=newNode
              newNode.previous = Last


          }
        Last=newNode
        newNode.index=sizeLinked

    }
    fun dispalyList_Previous(){


        var node = Last
        while (node!=null){

            node.showInfo(sizeLinked)
            node= node.previous

        }
        println("")
        println("")

        println("size for all is $sizeLinked")
        println("______________________________")

    }

    fun dispalyList_Next(){

        var node = First
        while (node!=null){

            node.showInfo(sizeLinked)

            node= node.Next
        }
        println("")

        println("size for all is $sizeLinked")
    }
    fun RemoveFirst():Node<T>{

           var current =First
            if (current?.Next==null){

                Last = null
            }
        else{
                First = current?.Next
            }
        First?.previous = null

          return current!!

    }

    fun RemoveByIndex(index:Int){


        var tem = Last
        var ind = index
        if (ind<size()){

            while (tem!=null){

                if (ind==tem.index){

                    tem.previous

                }
                else{

                    tem.previous?.Next = tem.Next

                }
            }

        }else{
            println("OUT OF MEMORY")
        }






    }





    fun RemoveLast():Node<T>{

        val last_data = Last

        if (First?.Next==null){

            Last =null
            First=null
        }
        else{
            Last?.previous?.Next=null



        }

        Last = Last?.previous
         last_data?.previous=null
        return last_data!!

    }
    fun insertAfter(key :T,data:T):Boolean{//key = 4 , data =8

        var current = First
        var currentper =current?.previous
        val newnod = Node<T>()


        while (current?.data!=key){//data {34,53,23,46} , key = 53
            currentper=current

            current= current?.Next

            if (current==null){
                sizeLinked++
                newnod.data = data
                currentper?.Next=newnod
                newnod.previous=currentper
                newnod.index=index
                Last=newnod

                println("LAST =  ${Last?.data}")

                return false
            }



        }

        sizeLinked++

        var newNode=Node<T>()
        newNode.data = data

        if (current==Last){
            current?.Next=null
            Last = newNode
            newNode.index=index

        }
        else{

            newNode.Next=current?.Next
            current?.Next?.previous=newNode
        }

        newNode.previous=current
        current?.Next=newNode

        newNode.index=newNode.previous?.index

        return true

    }
    fun deleteKey(key: Int) : Node<T>? {
        var tem = First

        while (key!=tem?.data&&tem!=null ){//الشرط الاول=ان القيمه الاولى ماتساوي الثانيه.
            // .الشرط الثاني=ان حامل القيمه مايكون فارغ

            tem=tem?.Next
            if (tem==null){
                return null
            }

        }
        sizeLinked--
         if (tem?.previous!=null){

            tem.previous!!.Next=tem.Next
            tem.Next?.previous=tem.previous
            if (tem==Last){

                Last=tem.previous
            }

        }
        else{

            First=First?.Next


        }



return tem
}


}