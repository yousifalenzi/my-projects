package treeNode

private data class TreeNode(val vaule:Int){
        var leftNode: TreeNode?=null
        var rightNode: TreeNode?=null

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
                }else {

                    currentnode = currentnode.rightNode
                    if (currentnode == null) {
                        parent.rightNode = newTreeNode
                        return
                    }
                }

            }

        }
    }

}

fun main() {





}