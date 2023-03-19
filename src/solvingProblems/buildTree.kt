package solvingProblems


//Given two integer arrays preorder and inorder where preorder
// is the preorder traversal of a binary tree and
// inorder is the inorder traversal of the same tree,
// construct and return the binary tree.




class construct{



    class TreeNode(var key: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }



    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {


        return build(0,0,inorder.size-1,preorder,inorder)
    }


    private fun build(preStart:Int, inStart:Int, inEnd:Int, preorder: IntArray, inorder: IntArray): TreeNode? {

        if (preStart>preorder.size-1||inStart>inEnd)return null

        val root = TreeNode(preorder[preStart])

        var inIndex = 0
        if (root.key==inorder[inEnd]){
            inIndex = inEnd

        }
        for (i in inStart until inEnd){
            if (root.key==inorder[i]){
                inIndex = i
                break
            }
        }

        root.left= build(preStart+1,inStart,inIndex-1,preorder,inorder)
        root.right= build(preStart+inIndex-inStart+1,inIndex+1,inEnd,preorder,inorder)


        return root


    }
     fun add(head: TreeNode?,key:Int): TreeNode? {

           if (head==null) {

               return TreeNode(key)
           }
        if (head.key<key){

            head.right = add(head.right,key)
        }
        else {

            head.left = add(head.left,key)
        }
        return head
    }


     fun preOrder(node: TreeNode?,arr:MutableList<Int>): MutableList<Int> {
        if (node != null) {
            arr.add(node.key)
            preOrder(node.left,arr)
            preOrder(node.right,arr)
        }
         return arr

     }
     fun inOrder(node: TreeNode?,arr:MutableList<Int>): MutableList<Int> {
        if (node != null) {
            inOrder(node.left,arr)
            arr.add(node.key)
            inOrder(node.right,arr)
        }
         return arr
    }
    fun postorder(node: TreeNode?,arr:MutableList<Int>): MutableList<Int> {
        if (node != null) {
            postorder(node.left,arr)
            postorder(node.right,arr)
            arr.add(node.key)

        }
        return arr
    }
}

fun main(){


    val con = construct()

    val preOrder = arrayOf(3,9,20,15,7)
    val inOrder = arrayOf(9,3,15,20,7)



}