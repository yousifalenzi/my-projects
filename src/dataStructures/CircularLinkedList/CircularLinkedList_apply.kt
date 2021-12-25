package dataStructures.CircularLinkedList

class CircularLinkedList_apply <T> {
    private var First:Node<T>?=null
    private var Last:Node<T>?=null
    fun isEmpty():Boolean{

        return (First==null)
    }
    fun AddFirst(data:T){
        val new_Node = Node<T>(data)


        if (isEmpty()){
            Last=new_Node
        }
        new_Node.Next = First
        First= new_Node

    }
    fun addLast(data:T){
        val new_Node = Node<T>(data)

        if (isEmpty()){

           First=new_Node
        }
        else{
            Last?.Next=new_Node
            Last=new_Node
        }




    }
    fun deleteFirst():T?{

        val tem = First?.data //6
        if (First?.Next==null){

            Last= null
        }
        First=First?.Next

        return tem
    }
    fun dispalyList(){

        var node = First
        while (node!=null){

            node.showInfo()
            node= node.Next
        }
    }
}