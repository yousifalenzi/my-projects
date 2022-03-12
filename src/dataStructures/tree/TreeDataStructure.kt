package dataStructures.tree

import java.util.*


private data class nodetree<T>(val i:Int, val value:T?){
    var rightChild:nodetree<T>?=null
    var leftChild:nodetree<T>?=null
    var height = 1
}
class treeDataStructure <T>{

    private var root:nodetree<T>?=null
    private var count = 0
    private var HeightLeft = 0
    private var HeightRight = 0




    fun insert1(i:Int,value:T){
        val newNode = nodetree<T>(i,value)

        if(empty()) this.root = newNode


            else{
                 var parent = this.root
                 var current = parent
                 var isLeft = false

            while (current!=null){
                   parent=current
                     if (newNode.i< parent.i){
                          current=current.leftChild
                          isLeft = true

                     }
                     else{
                         current=current.rightChild
                         isLeft = false

                     }
                 }

            if (isLeft){parent?.leftChild=newNode }else{parent?.rightChild=newNode}


            }
       this.count++



    }
    fun insert2(i:Int,value:T): T? {

        val newNode = nodetree<T>(i,value)
        var current = this.root

        if (empty()){
            this.root = newNode
            this.count++

        }
        else{
            while (true){
                if (i< current!!.i){

                    if (current.leftChild ==null){

                        current.leftChild = newNode
                        this.count++

                        return current.value
                    }
                    current= current.leftChild

                }else{
                    if (current.rightChild ==null){

                        current.rightChild = newNode
                        this.count++

                        return current.value
                    }
                    current= current.rightChild

                }


            }

        }
        return root?.value

    }
    fun lookup(index:Int): Any? {

        if (!empty()){

            var current = this.root


            if (index==this.root?.i)return this.root!!.value

            else{

                while (current!=null){
                    if (index<current.i){

                        current=current.leftChild
                    }
                    else{

                        current=current.rightChild
                    }
                    if (current != null) {
                        if (index== current.i)return current.value
                    }

                }
            }
            return false

        }
        return false


    }
    fun nodeCount():Int=this.count
    fun getNext(i:Int){

    }
    fun remove (index:Int){
          var CurrentNode = this.root
          var parent = CurrentNode
          var isleft =false


           while (index!=CurrentNode?.i){
               parent = CurrentNode
               if (index<CurrentNode!!.i){
                   CurrentNode=CurrentNode.leftChild
                   isleft = true
               }
               else{
                   CurrentNode=CurrentNode.rightChild
                   isleft = false

               }
           }


        //leaf node
        if (CurrentNode.rightChild==null&&CurrentNode.leftChild==null){
            when {
                CurrentNode==this.root -> {this.root=null}
                isleft -> {parent?.leftChild=null}
                else -> {parent?.rightChild=null}
            }

        }


        //single node
        else if (CurrentNode.rightChild==null){
            when {
                CurrentNode==root -> {this.root = this.root!!.leftChild}
                isleft -> {parent?.leftChild = CurrentNode.leftChild }
                else -> {parent?.rightChild = CurrentNode.leftChild }
            }
        }
        else if (CurrentNode.leftChild==null){
            when {
                CurrentNode==root -> {this.root = this.root!!.rightChild}
                isleft -> {parent?.leftChild = CurrentNode.rightChild }
                else -> {parent?.rightChild = CurrentNode.rightChild }
            }
        }



        //tow child

        else{



                             val Successor = getSuccessor(CurrentNode)
                                 when{

                                     CurrentNode==root ->root = Successor
                                     isleft->parent?.leftChild=Successor
                                     else->parent?.rightChild=Successor
                                 }
                               Successor?.leftChild = CurrentNode.leftChild

        }
    }
    private fun getSuccessor(node_weWantDelete:nodetree<T>?): nodetree<T>? {
           var parent = node_weWantDelete
           var Successor= node_weWantDelete
           var current = node_weWantDelete?.rightChild

          while (current!=null){
               parent = Successor
              Successor = current
              current=current.leftChild
          }
        if (Successor!=node_weWantDelete?.rightChild){

            parent?.leftChild = Successor?.rightChild
            Successor?.rightChild = node_weWantDelete?.rightChild

        }

        return Successor
    }
    private fun empty():Boolean=this.root==null
    fun displayDataTree(){

        val generalStack = Stack<nodetree<T>?>()
        generalStack.push(this.root)
        var blanks = 31
        var isRowEmpty = false
        println("*******************************")

        while (isRowEmpty==false){
            val InsiderStack: Stack<nodetree<T>?> = Stack<nodetree<T>?>()

            isRowEmpty= true
            for (i in 0 until blanks){
                print("  ")
            }

            while (generalStack.isEmpty()==false){

                val catchNode = generalStack.pop()
                if (catchNode!=null){
                    print(catchNode.i)
                    print("(${catchNode.value})")
                    InsiderStack.push(catchNode.leftChild)
                    InsiderStack.push(catchNode.rightChild)
                    if (catchNode.leftChild!=null||catchNode.rightChild!=null){
                        isRowEmpty = false
                    }
                }
                else{
                    print("_ _")
                    InsiderStack.push(null)
                    InsiderStack.push(null)

                }

                for (i in 0 until blanks*2-2){
                    print("   ")
                }
            }
            println()
            blanks=blanks/2
            while (!InsiderStack.isEmpty()){
                generalStack.push(InsiderStack.pop())
            }

        }

        println("*******************************")

    }
    fun preOrder(){
        preOrder(this.root)
    }

    private fun preOrder(node: nodetree<T>?) {
        if (node != null) {
            print(node.i.toString() + " ")
            preOrder(node.leftChild)
            preOrder(node.rightChild)
        }
    }


}

fun main (){

    val tr =treeDataStructure<String>()
    tr.insert1(20,"yousif")
    tr.insert1(18,"yousif")
    tr.insert1(22,"yousif")
    tr.insert1(15,"yousif")
    tr.insert1(12,"yousif")

    tr.preOrder()

}