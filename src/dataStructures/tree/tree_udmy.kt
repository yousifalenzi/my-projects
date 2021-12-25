package dataStructures.tree

import java.util.*


data class Node(var key:Int,var vaule:String){

    var LeftNode:Node?=null
    var rightNode:Node?=null
}

class BinaryTreeSearch{

    var root :Node?=null


    fun InsertNode(key:Int,Vaule:String){

        var newNode=Node(key,Vaule)

        if (root==null){
            root = newNode
        }
        else{

            var currentNode=root
            var parent :Node

            while (true){

                parent = currentNode!!//30
                if (key<currentNode.key){//17<25
                    currentNode=currentNode.LeftNode
                    if(currentNode==null){
                        parent.LeftNode = newNode
                        return
                    }

                }
                else{
                    currentNode=currentNode.rightNode
                    if (currentNode==null){

                        parent.rightNode = newNode
                        return
                    }
                }
            }
        }
    }
  fun getMax(): Node? {
      var root_ = root
      var parent :Node?=null

      while (root_!=null ){
          parent=root_
          root_ = root_.rightNode

      }
      return parent
  }
    fun getMin(): Node? {
        var root_ = root
        var parent :Node?=null
        while (root_!=null ){

             parent=root_
            root_ = root_.LeftNode


        }
        return parent
    }

    fun DeleteNode(key: Int):Boolean{
        //Initialize variables
        var current :Node?=root
        var parent :Node? = root
        var isLeft =false



        //search the node has a key we want to remove it
          while (current?.key!=key){

               parent = current
              if (key<current!!.key){

                  isLeft = true
                  current=current.LeftNode
              }
              else{
                  isLeft=false
                  current=current.rightNode
              }
              if (current==null) return false



              //found the intended node
              var CurrentNode = current


              //Is Leaf Node_How Remove it From Tree

              if (CurrentNode.LeftNode==null&&CurrentNode.rightNode==null){

                  if (CurrentNode==root){
                      root = null
                  }else if(isLeft){

                      parent?.LeftNode = null
                  }
                  else{
                      parent?.rightNode = null

                  }

              }


              //Has One Child in leftnode

               else if(CurrentNode.rightNode==null){
                    if (CurrentNode==root){

                        root = root!!.LeftNode
                    }
                  else if (isLeft){
                        parent?.LeftNode =CurrentNode.LeftNode
                  }
                  else{
                        parent?.rightNode =CurrentNode.LeftNode

                    }


              }

              //Has One Child in RightNode
              else if(CurrentNode.LeftNode==null){
                  if (CurrentNode==root){
                      root = root!!.rightNode
                  }

                  else if(isLeft){
                      parent?.LeftNode = CurrentNode.rightNode
                  }
                  else{
                      parent?.rightNode = CurrentNode.rightNode
                  }
              }


              else{

                  var successor = get_successor(CurrentNode)
                  if (CurrentNode==root){
                      root = successor
                  } else if (isLeft){

                      parent?.LeftNode = successor
                  }
                  else{
                      parent?.rightNode= successor
                  }


               successor?.LeftNode = CurrentNode.LeftNode
              }


          }

        return true
    }
    fun get_successor(node:Node):Node?{

        var parent :Node? = node
        var currentVAULE :Node? = node

        var pionter:Node? = node.rightNode

        while (currentVAULE!=null){
            parent = currentVAULE//30
            currentVAULE=pionter!!//24
            pionter=pionter.LeftNode//null

        }


             if (currentVAULE!=node.rightNode){

                 parent?.LeftNode = currentVAULE?.rightNode
                 currentVAULE?.rightNode = node.rightNode

             }

        return currentVAULE
    }


    fun displayTree() {
        val globalStack: Stack<Node> = Stack<Node>()
        globalStack.push(root )
        var nBlanks = 32
        var isRowEmpty = false
        println("......................................................")


        while (isRowEmpty == false) {
            val localStack: Stack<Node> = Stack<Node>()
            isRowEmpty = true
            for (j in 0 until nBlanks) {
                print(" ")
            }


            while (globalStack.isEmpty() == false) {
                val temp = globalStack.pop() as Node?
                if (temp != null) {
                    print(temp.key)
                    localStack.push(temp.LeftNode )
                    localStack.push(temp.rightNode)
                    if (temp.LeftNode != null || temp.rightNode != null) {
                        isRowEmpty = false
                    }
                } else {
                    print("--")
                    localStack.push(null)
                    localStack.push(null)
                }
                for (j in 0 until nBlanks * 2 - 2) {
                    print(" ")
                }
            }
            println()
            nBlanks = nBlanks / 2
            while (localStack.isEmpty() == false) globalStack.push(localStack.pop() )
        }
        println("......................................................")
    }


}


    private fun getsuccessor(node:Node):Node{
        var successorParent = node
        var successor=node

        var current = node.rightNode

        while (current!=null){

            successorParent=successor
            successor=current
            current=current.LeftNode
        }

        //if successor not right child
        if (successor!=node.rightNode){
            successorParent.LeftNode=successor.rightNode
            successor.rightNode=node.rightNode
        }
        return successor
    }


     //dataStructures.tree traversal functions
    fun PostOrder(){

        //right-left-root
    }
    fun PreOrder(){

        //root-left-right
    }
    fun InOrder(){

    //left/root/right

    }




fun main() {

    var outerloop = 20
    var innnerloop = 1

    while (outerloop>=1){

        outerloop=outerloop/2

        while (innnerloop<=outerloop){

            innnerloop++
            println("&")

        }
    }

    println(innnerloop)
}