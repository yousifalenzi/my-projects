package dataStructures.CircularLinkedList


data class node (val data:Any?){


    var next: node?=null
    var previous: node?=null
}

class CircularLinkedList_apply {


    private var Head :node ? = null
    private var tail :node ? = null
    private var index =-1



    fun append(data:Any){
      val newnode = node(data)

        if (tail==null){
            this.tail = newnode
            this.Head = newnode

            index++
        }
         else{

            this.tail!!.next = newnode
            newnode.previous = this.tail
            this.tail = newnode


            index++

        }

    } // add last
    fun prepend(data:Any){

        val newnode = node(data)

        if (this.Head==null){
            this.Head = newnode
            this.tail = newnode

            index++
        }
        else{
            newnode.next = this.Head
            this.Head = newnode
             newnode.next?.previous = this.Head
            index++
        }


    } // add first
    fun insert(i:Int,data:Any){
        val newnode = node(data)

        if (i>=index&&this.tail!=null&&this.Head!=null){

            this.tail!!.next = newnode
            newnode.previous = this.tail
            this.tail = newnode
            index++

        }
        else{


            if (this.tail==null&&this.Head==null){
                this.tail = newnode
                this.Head = newnode
                index++
            }
            else{
                if (i==0){prepend(data)}
                else{
                    val position = getPosition(i-1)

                    newnode.next = position?.next
                    position?.next?.previous = newnode


                    position?.next = newnode
                    newnode.previous = position
                    index++
                }



            }

        }



    }


    fun remove(ind:Int): Any ?{

        var head= this.Head
        for (i in 0 until  ind){
            head=head?.next
        }

        val pointer_value=head?.data


        head?.previous?.next = head?.next
        head?.next?.previous =head?.previous
         index--

        return "data was remove it #(${pointer_value})"
    }
    fun printAll_fromHead(){

        println("START PRINT FROM HEAD  ")

        var head= this.Head

        for (i in 0 .. index){
            print("[${head?.data}]")
            head=head?.next
        }
        println("\n")


    }
    fun reverse(){

        println("START PRINT FROM TAIL ")

        var tail= this.tail

        for (i in 0 .. index){
            print("[${tail?.data}]")
            tail=tail?.previous
        }

        println("\n")

    }
    fun print_info(){

        var head= this.Head
       println("PRINT ALL INFORMATION ")
        for (i in 0 .. index){
            print("INDEX/[${i}]..VALUE/[${head?.data}]..PREVIOUS_VALUE[${head?.previous?.data}]")
            println()
            head=head?.next
        }
        println("\n")

    }
    fun getSize():Int= index+1
    fun getHead():Any?= this.Head?.data
    fun getTail():Any?= this.tail?.data
    fun getPrevious(i:Int): Any? {

         var ind = 0
        var counter = this.Head

        while (ind!=i){

            counter = counter?.next
            ind++
            if (ind==i)return counter?.previous?.data
        }

        return  null

    }

    private fun getPosition(i: Int): node? {

        var counter =this.Head
        var ii = 0

        while (ii!=i&&i!=-1){

            ii++
            counter = counter?.next
        }
        return counter
    }

}
fun main(){

   val linked = CircularLinkedList_apply()

    linked.prepend(14)
    linked.prepend("google")
    linked.prepend("hello")
    linked.prepend(22.4f)
    linked.prepend(25.1)
    linked.append(false)
    val no = node("cold")
    linked.append(no)

    linked.insert(2,23)
    linked.insert(0,11)
    linked.insert(11,21)

    linked.prepend(27)

    linked.insert(8,132)
    linked.insert(4,112)

   linked.printAll_fromHead()







}