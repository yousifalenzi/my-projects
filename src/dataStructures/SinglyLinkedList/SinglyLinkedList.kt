package dataStructures.SinglyLinkedList

class SinglyLinkedList {

    var first: Node?=null
    var last: Node?=null
    var count = 0


    fun getcount(): Int {
        return count
    }
     fun add(data:Int){

         val node= Node()
         node.data=data

         if (isEmpty()){
             first= node
             last=node
             count++
         }else{

            last?.Next=node
             last=node
             count++
         }
     }
    fun isEmpty():Boolean{

        return (first==null)
    }

    fun insertFirst(data:Int){

        val newnode= Node()
        newnode.data=data
        newnode.Next=first// newnode.next --> first =null
        first=newnode//first =newnode.next=null
        last=newnode
        count++
    }
    fun deleteFirst(){

        val temp = first//12 -- next = 13
        first = temp?.Next // first = 12 // first= 13
        count--
    }
    fun dispalyList(){

        var node = first
        while (node!=null){

            node.showInfo()
            node= node.Next
        }
    }
    fun insertLast(data :Int){

        var current = first

        while (current?.Next!=null){

            current = current.Next
        }
        val node = Node()
        node.data=data
        current?.Next=node
    }

}



