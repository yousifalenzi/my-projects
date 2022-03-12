package dataStructures.avl_kotlin

import java.util.*

// AVL tree implementation in Kotlin
 open class Node23(var item: Int) {
    var height = 1
    var left: Node23? = null
    var right: Node23? = null
}
class avl_kotlin {

     var root :Node23? = null




     fun insert( node :Node23?,item:Int):Node23{
         /* 1.  Perform the normal BST insertion */
        if (node==null){
            val newed = Node23(item)
          return newed
        }
        when {
            item<node.item -> {

                node.left = insert(node.left,item)
            }
            item>node.item -> {
                node.right = insert(node.right,item)

            }
            else -> return node
        }


         /* 2. Update height of this ancestor node */
         updateHeight(node)



         /* 3. Get the balance factor of this ancestor
               node to check whether this node became
               unbalanced */
         val balance = getBalanceFactor(node)




         // If this node becomes unbalanced, then there
         // are 4 cases Left Left Case
         //or /* return the (unchanged) node pointer */
         return rbalance(balance,item,node)!!


    }
     fun printTree(currPtr: Node23?, indent: String?, last: Boolean) {
        var indent1 = indent
        if (currPtr != null) {
            print(indent1)
            indent1 += if (last) {
                print("R----")
                "   "
            } else {
                print("L----")
                "|  "
            }
            println(currPtr.item)
            printTree(currPtr.left, indent1, false)
            printTree(currPtr.right, indent1, true)
        }
    }
    fun displayTree(){

        val globalStack = Stack<Node23?>()
        globalStack.push(this.root)
        var nBlanks = 2
        var isRowEmpty = false
        println("......................................................")

        while (isRowEmpty==false){
            val localStack: Stack<Node23?> = Stack<Node23?>()
            isRowEmpty=true
            for(i in 0 until nBlanks) print("   ")


            //**************************************//

            while (globalStack.isEmpty()==false){

                val temp = globalStack.pop() as Node23?// global = null ,temp = root
                if (temp!=null){

                    print(temp.item)
                    localStack.push(temp.left)
                    localStack.push(temp.right)
                    if (temp.left!=null ||temp.right!=null ){
                        isRowEmpty=false
                    }
                    else{
                        print("--")
                        localStack.push(null)
                        localStack.push(null)

                    }

                    for (j in 0 until nBlanks * 2 - 2){
                        print(" ")

                    }

                }
            }

            println()
            nBlanks=nBlanks/2

            while (localStack.isEmpty()==false)globalStack.push(localStack.pop())

        }

        println("......................................................")



    }
    //root -> left -> right
    fun preOrder(node: Node23?) {
        if (node != null) {
            print(node.item.toString() + " ")
            preOrder(node.left)
            preOrder(node.right)
        }
    }

    //left -> root -> right
    fun Inorder(node: Node23?) {
        if (node == null) return

        Inorder(node.left)

        print(node.item.toString() + " ")

        Inorder(node.right)
    }

    //left -> right -> root
    fun Postorder(node: Node23?) {
        if (node == null) return

        Postorder(node.left)
        Postorder(node.right)
        print(node.item.toString() + " ")


    }



    //private functions
    private fun rbalance(balance:Int,item: Int,node:Node23): Node23? {
        if (balance > 1 && item < node.left!!.item)
            return rotateRight(node)!!

        // Right Right Case
         else if (balance < -1 && item > node.right!!.item)
            return rotateLeft(node)!!;


        // Left Right Case
        else if (balance > 1 && item > node.left!!.item) {
            node.left = rotateLeft(node.left);
            return rotateRight(node)!!;
        }
        // Right Left Case
        else if (balance < -1 && item < node.right!!.item) {
            node.right = rotateRight(node.right);
            return rotateLeft(node)!!;
        }
        else
        return node
    }
    private fun height(node :Node23?): Int {
        return node?.height ?: 0
    }

    private fun max(a: Int, b: Int): Int {
        return if (a > b) a else b
    }

    // A utility function to right rotate subtree rooted with y
    private fun rotateRight(y :Node23?):Node23?{

            val x = y?.left
            val t2 = x?.right
        // Perform rotation
            x?.right = y
            y?.left = t2
        // Update heights
           updateHeight(y)
           updateHeight(x)

        // Return new root
           return x
    }

    // A utility function to left rotate subtree rooted with x
    private fun rotateLeft(x :Node23?):Node23?{

        val y = x?.right
        val t2 = y?.left

        // Perform rotation
        y?.left = x
        x?.right = t2

        //  Update heights
        updateHeight(x)
        updateHeight(y)

        // Return new root
        return y
    }

    private fun getBalanceFactor(node :Node23?): Int {
        return if (node == null) 0 else height(node.left) - height(node.right)
    }

    private fun  updateHeight(node :Node23?){

        node?.height = max(height(node?.left),height(node?.right))+1
    }

}



fun main (){

      val avl = avl_kotlin()
      avl.root =  avl.insert(avl.root,12)
      avl.root = avl.insert(avl.root,13)
      avl.root = avl.insert(avl.root, 15)

   avl.Postorder( avl.root)

}