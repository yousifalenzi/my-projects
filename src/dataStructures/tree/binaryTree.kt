package treeNode

import java.util.*

data class TreeNode(val vaule:Int){
        var leftNode: TreeNode?=null
        var rightNode: TreeNode?=null


    @JvmName("getLeftNode1")
    fun getLeftNode1():TreeNode? = leftNode
    @JvmName("getRightNode1")
    fun getRightNode1():TreeNode? = rightNode
    @JvmName("setLeftNode1")
    fun setLeftNode1(node:TreeNode?){
        leftNode = node
    }
    @JvmName("setRightNode1")
    fun setRightNode1(node:TreeNode?){
        rightNode = node
    }

}

class DataTree {

     private var root: TreeNode? = null

    fun addNode(i: Int) {
        val newTreeNode = TreeNode(i)
        if (root == null) {
            root = newTreeNode
        } else {

            var currentnode = root
            var parent: TreeNode

            while (true) {

                parent = currentnode!!//root
                if (i < currentnode.vaule) {
                    currentnode = currentnode.leftNode
                    if (currentnode == null) {
                        parent.leftNode = newTreeNode
                        return
                    }
                } else {

                    currentnode = currentnode.rightNode
                    if (currentnode == null) {
                        parent.rightNode = newTreeNode
                        return
                    }
                }

            }

        }
    }
//    fun isValidBST(root: TreeNode?): Boolean {
//
//
//
//    }
    fun getRoot ():TreeNode? = root
    fun setRoot(node:TreeNode?){
        this.root = node
    }
     fun isValidBST(node: TreeNode): Boolean {
        val queue = LinkedList< TreeNode>()
        var isValidBST = true

        queue.add(node)

        while (!queue.isEmpty() && isValidBST) {
            if (queue.first==null)break

            val enqueue = queue.first
            queue.remove(queue.first)



            if (enqueue.getLeftNode1()!=null&&enqueue.getRightNode1()!=null){
                isValidBST = enqueue.getLeftNode1()!!.vaule<enqueue.vaule&&enqueue.getRightNode1()!!.vaule>enqueue.vaule
                queue.add(enqueue.getLeftNode1()!!)//13
                queue.add(enqueue.getRightNode1()!!)
            }

            else if(enqueue.getLeftNode1()!=null){

                isValidBST = enqueue.getLeftNode1()!!.vaule<enqueue.vaule
                queue.add(enqueue.getLeftNode1()!!)//13

            }
            else if(enqueue.getRightNode1()!=null){

                isValidBST = enqueue.getRightNode1()!!.vaule>enqueue.vaule
                queue.add(enqueue.getRightNode1()!!)

            }

        }
        return isValidBST
    }
    fun helper(node: TreeNode?, left: Int?, right: Int?): Boolean {
        if (node == null) {
            return true
        }
        if (left != null) {
            if (node.vaule <= left) {
                return false
            }
        }
        if (right != null) {
            if (node.vaule >= right) {
                return false
            }
        }
        return helper(node.leftNode, left, node.vaule) && helper(node.rightNode, node.vaule, right)
    }

}
fun main() {


    val no = DataTree()
    val node=TreeNode(14)
    val node1=TreeNode(22)
    val node2=TreeNode(8)
    val node3=TreeNode(5)
    val node4=TreeNode(80)

    no.setRoot(node)
    node.leftNode=node2
    node.rightNode=node4

    node2.leftNode = node3
    node2.rightNode=node1

    no.helper(no.getRoot(),node2.vaule,node4.vaule)




}