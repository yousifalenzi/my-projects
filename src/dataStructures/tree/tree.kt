package dataStructures.tree


class dataTreeNode<T>(v:T){

    var vaule= v
    var parent :dataTreeNode<T>?=null

    var children:MutableList<dataTreeNode<T>> = mutableListOf()

    fun addchild(node:dataTreeNode<T>){
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
    val milk =dataTreeNode<String>("milk")
    val Beverages =dataTreeNode<String>("Beverages")
    val Curd =dataTreeNode<String>("Curd")

    milk.addchild(Beverages)
    milk.addchild(Curd)

    val teaNode = dataTreeNode<String>( "tea")
    val coffeeNode = dataTreeNode<String>( "coffee")
    val milkShakeNode = dataTreeNode<String>( "Milk Shake")

    Beverages.addchild(teaNode)
    Beverages.addchild(coffeeNode)
    Beverages.addchild(milkShakeNode)

    val gingerTeaNode = dataTreeNode<String>( "ginger tea")
    val normalTeaNode = dataTreeNode<String>( "normal tea")

    teaNode.addchild(gingerTeaNode)
    teaNode.addchild(normalTeaNode)

    val yogurtNode = dataTreeNode<String>( "yogurt")
    val lassiNode = dataTreeNode<String>( "lassi")

    Curd.addchild(yogurtNode)
    Curd.addchild(lassiNode)


    println(milk.children)

    for (item in milk.children.iterator()){
        println(item.parent)
    }


}