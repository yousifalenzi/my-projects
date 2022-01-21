package dataStructures.yousif_projects

private data class node (val data:Int){


    var LeftNode:node?=null
    var RightNode:node?=null

}


class TreeLinkedList(){


    private var Head :node?=null
    private var Iflag = false
    private var NumberOfNode = 0




    fun add (data:Int){

        val newNode = node(data)
        var getHead = this.Head
        var current = this.Head

        if (this.Head==null){
            Head=newNode
            NumberOfNode++
        }
        else if (newNode.data< this.Head!!.data&& this.Head !!.LeftNode==null) {
            this.Head !!.LeftNode = newNode
            NumberOfNode++
        }
        else if (newNode.data> this.Head!!.data&& this.Head !!.RightNode==null) {

            this.Head !!.RightNode = newNode
            NumberOfNode++
        }




        //------------------------------------//
        else{

            while (getHead!=null){//10 == null no
                if (newNode.data< getHead!!.data){
                     current = getHead
                    getHead=getHead.LeftNode
                    Iflag =true

                }
                else if (newNode.data> getHead!!.data){
                    current = getHead
                    getHead=getHead.RightNode
                    Iflag =false

                }

            }
            if (Iflag){
                current?.LeftNode = newNode
                NumberOfNode++
            }
            else if (!Iflag){

                current?.RightNode = newNode
                NumberOfNode++
            }


        }

    }
    fun get_Maximal_Value():Int{
        var big = 0
        var head_ =this.Head

        while (head_!=null){
            big = head_.data
            head_=head_.RightNode

        }

        return big
    }
    fun get_Minimum_Value():Int{
        var small = 0
        var head_ =this.Head

        while (head_!=null){
            small = head_.data
            head_=head_.LeftNode

        }

        return small
    }
    fun get_size ():Int = NumberOfNode
    fun print_all(){

        var head_ =this.Head
        var head_left =this.Head?.LeftNode
        var head_right =this.Head?.RightNode

        while (head_!=null&&head_left!=null&&head_right!=null){


        }
    }
}

fun main (){



    val node = TreeLinkedList()
    node.add(15)
    node.add(10)
    node.add(20)
    node.add(12)
    node.add(14)
    node.add(16)
    node.add(26)
    node.add(4)
    println("Bigger Value ${node.get_Maximal_Value()}")
    println("Smallest Value ${node.get_Minimum_Value()}")
    println("size =  ${node.get_size()}")


}