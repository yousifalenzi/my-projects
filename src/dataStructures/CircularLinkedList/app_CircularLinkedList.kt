package dataStructures.CircularLinkedList


data class node (val data:Any?){


    var next: node?=null
    var previous: node?=null
}

class CircularLinkedList_apply {


    private var Head :node ? = null
    private var tail :node ? = null
    private var index =-1



    fun append(data:Any){// add last
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

    }
    fun prepend(data:Any){
// add first
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


    }
    fun insert(i:Int,data:Any){//o(n)
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
    fun fromtail(){

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
    fun reverse(){


        var first = this.Head
        this.tail = this.Head

        var second = first?.next
        while (second!=null){

            val temp = second.next//null
            second.next = first//14
            first=second // 22
            second=temp //null

        }
        this.Head?.next = null
        this.Head = first
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

    linked.insert(4,12)
    linked.insert(4,14)
    linked.append(4)

    linked.printAll_fromHead()







}