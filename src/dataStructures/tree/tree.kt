package dataStructures.tree


class treeNode<T>(v:T){

    var vaule= v
    var parent :treeNode<T>?=null

    var children:MutableList<treeNode<T>> = mutableListOf()

    fun addchild(node:treeNode<T>){
        children.add(node)
        node.parent=this

    }

    override fun toString(): String {
        val s ="${vaule}"
        if (!children.isEmpty()){
            s+"{"+children.map { it.toString()+"}" }
        }
        return s
    }

}
fun main(){
    val milk =treeNode<String>("milk")
    val Beverages =treeNode<String>("Beverages")
    val Curd =treeNode<String>("Curd")

    milk.addchild(Beverages)
    milk.addchild(Curd)

    val teaNode = treeNode<String>( "tea")
    val coffeeNode = treeNode<String>( "coffee")
    val milkShakeNode = treeNode<String>( "Milk Shake")

    Beverages.addchild(teaNode)
    Beverages.addchild(coffeeNode)
    Beverages.addchild(milkShakeNode)

    val gingerTeaNode = treeNode<String>( "ginger tea")
    val normalTeaNode = treeNode<String>( "normal tea")

    teaNode.addchild(gingerTeaNode)
    teaNode.addchild(normalTeaNode)

    val yogurtNode = treeNode<String>( "yogurt")
    val lassiNode = treeNode<String>( "lassi")

    Curd.addchild(yogurtNode)
    Curd.addchild(lassiNode)


    println(milk.children)


}