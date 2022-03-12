package dataStructures.tree


 private data class TreeNode(val key:Int){
    var left: TreeNode?=null
    var right: TreeNode?=null
    var height:Int?=null

}
class AVL_tree {

    private var root:TreeNode?=null

    private fun updateHeight(node:TreeNode){

        node.height = 1+Math.max(height(node.left),height(node.right))
    }
    private fun height(n: TreeNode?): Int {
        return n?.height ?: -1
    }
    private fun getBalance(n:TreeNode): Int {
        return height(n.right) - height(n.left)
    }
    private fun rotateRight(y: TreeNode): TreeNode? {
        val x: TreeNode? = y.left
        val z: TreeNode?= x?.right
        x?.right = y
        y.left = z
        updateHeight(y)
        updateHeight(x!!)
        return x
    }
    private fun rotateLeft(y: TreeNode): TreeNode? {
        val x: TreeNode? = y.right
        val z: TreeNode? = x?.left
        x?.left = y
        y.right = z
        updateHeight(y)
        updateHeight(x!!)
        return x
    }
    private fun balance(z: TreeNode?): TreeNode? {
        var z1: TreeNode? = z
        updateHeight(z1!!)
        val balance = getBalance(z1)
        if (balance > 1) {
            if (height(z1.right?.right) > height(z1.right?.left)) {
                z1 = rotateLeft(z1)
            } else {
                z1.right = rotateRight(z1.right!!)
                z1 = rotateLeft(z1)
            }
        } else if (balance < -1) {
            if (height(z1.left?.left) > height(z1.left?.right)) z1 = rotateRight(z1) else {
                z1.left = rotateLeft(z1.left!!)
                z1 = rotateRight(z1)
            }
        }
        return z1
    }
    private fun preOrder(node: TreeNode?) {
        if (node != null) {
            print(node.key.toString() + " ")
            preOrder(node.left)
            preOrder(node.right)
        }
    }

    fun insert(key:Int){
        val newnode=TreeNode(key)
        insert(newnode)
    }
    private fun insert(node: TreeNode?): TreeNode? {
        if (node != null) {
            var parent = this.root

                    when {
                this.root == null -> {
                    this.root = node
                }
                node.key > this.root!!.key -> {
                    parent = parent?.right
                    insert(node.right)
                }
                node.key < this.root!!.key -> {
                    node.right = insert(node.right)
                }
                else -> {
                    throw RuntimeException("duplicate Key!")
                }
            }
        }
        return balance(node)
    }

     fun preOrder(){
        preOrder(this.root)
    }




}