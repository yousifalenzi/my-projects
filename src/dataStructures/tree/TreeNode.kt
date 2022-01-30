package dataStructures.tree

import java.util.*


 data class TreeNode(var key:Int, var vaule:String){

    var leftTreeNode:TreeNode?=null
    var rightTreeNode:TreeNode?=null
}

class BinaryTreeSearch{

    private var root :TreeNode?=null


    fun InsertNode(key:Int,Vaule:String){ //O(log N)

        val newNode=TreeNode(key,Vaule)

        if (root==null){
            root = newNode
        }
        else{

            var currentNode=root
            var parent :TreeNode

            while (true){

                parent = currentNode!!
                if (key<currentNode.key){
                    currentNode=currentNode.leftTreeNode
                    if(currentNode==null){
                        parent.leftTreeNode = newNode
                        return
                    }

                }
                else{
                    currentNode=currentNode.rightTreeNode
                    if (currentNode==null){

                        parent.rightTreeNode = newNode
                        return
                    }
                }
            }
        }
    }
    fun getMax(): TreeNode? {//O(log N)
      var root_ = root
      var parent :TreeNode?=null

      while (root_!=null ){
          parent=root_
          root_ = root_.rightTreeNode

      }
      return parent
  }
    fun getMin(): TreeNode? {//O(log N)
        var root_ = root
        var parent :TreeNode?=null
        while (root_!=null ){

             parent=root_
            root_ = root_.leftTreeNode


        }
        return parent
    }

    fun DeleteNode(key: Int):Boolean{
        //Initialize variables
        var current :TreeNode?=root
        var parent :TreeNode? = root
        var isLeft =false



        //search the node has a key we want to remove it
          while (current?.key!=key){

               parent = current
              if (key<current!!.key){

                  isLeft = true
                  current=current.leftTreeNode
              }
              else{
                  isLeft=false
                  current=current.rightTreeNode
              }
              if (current==null) return false
          }



              //found the intended node
              val CurrentNode = current


              //Is Leaf Node_How Remove it From Tree
              if (CurrentNode.leftTreeNode==null&&CurrentNode.rightTreeNode==null){

                  if (CurrentNode==root){
                      root = null
                  }else if(isLeft){

                      parent?.leftTreeNode = null
                  }
                  else{
                      parent?.rightTreeNode = null

                  }

              }

              //Has One Child in leftnode
               else if(CurrentNode.rightTreeNode==null){
                    if (CurrentNode==root){

                        root = root!!.leftTreeNode
                    }
                  else if (isLeft){
                        parent?.leftTreeNode =CurrentNode.leftTreeNode
                  }
                  else{
                        parent?.rightTreeNode =CurrentNode.leftTreeNode

                    }


              }



              //Has One Child in RightNode
              else if(CurrentNode.leftTreeNode==null){
                  if (CurrentNode==root){
                      root = root!!.rightTreeNode
                  }

                  else if(isLeft){
                      parent?.leftTreeNode = CurrentNode.rightTreeNode
                  }
                  else{
                      parent?.rightTreeNode = CurrentNode.rightTreeNode
                  }
              }


              else{

                  val successor = getSuccessor(CurrentNode)
                  when {
                      CurrentNode==root -> {
                          root = successor
                      }
                      isLeft -> {

                          parent?.leftTreeNode = successor
                      }
                      else -> {
                          parent?.rightTreeNode= successor
                      }
                  }


               successor?.leftTreeNode = CurrentNode.leftTreeNode
              }




        return true
    }


    private fun getSuccessor(treeNode:TreeNode):TreeNode?{

        var parent :TreeNode? = treeNode

        var currentVAULE :TreeNode? = treeNode

        var pionter:TreeNode? = treeNode.rightTreeNode

        while (pionter!=null){
            parent = currentVAULE//81
            currentVAULE=pionter!!//null
            pionter=pionter.leftTreeNode//null

        }


        if (currentVAULE!=treeNode.rightTreeNode){

            parent?.leftTreeNode = currentVAULE?.rightTreeNode
            currentVAULE?.rightTreeNode = treeNode.rightTreeNode

        }

        return currentVAULE
    }
    private fun successor(treeNode:TreeNode):TreeNode{
        var successorParent = treeNode
        var successor=treeNode

        var current = treeNode.rightTreeNode

        while (current!=null){

            successorParent=successor
            successor=current
            current=current.leftTreeNode
        }

        //if successor not right child
        if (successor!=treeNode.rightTreeNode){
            successorParent.leftTreeNode=successor.rightTreeNode
            successor.rightTreeNode=treeNode.rightTreeNode
        }
        return successor
    }
    fun displayTree() {
        val globalStack: Stack<TreeNode> = Stack<TreeNode>()
        globalStack.push(root )
        var nBlanks = 32
        var isRowEmpty = false
        println("......................................................")


        while (isRowEmpty == false) {
            val localStack: Stack<TreeNode> = Stack<TreeNode>()
            isRowEmpty = true
            for (j in 0 until nBlanks) {
                print(" ")
            }


            while (globalStack.isEmpty() == false) {
                val temp = globalStack.pop() as TreeNode?
                if (temp != null) {
                    print(temp.vaule)
                    localStack.push(temp.leftTreeNode )
                    localStack.push(temp.rightTreeNode)
                    if (temp.leftTreeNode != null || temp.rightTreeNode != null) {
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



}






fun main() {
   val node = BinaryTreeSearch()
    node.InsertNode(50,"yousif")
    node.InsertNode(43,"mayram")
    node.InsertNode(73,"omar")
    node.InsertNode(40,"janan")
    node.InsertNode(48,"anfal")
    node.InsertNode(66,"lola")
    node.InsertNode(81,"muhmeed")
    node.DeleteNode(73)
    node.displayTree()


}