package dataStructures.tree

import java.util.*

class NodeTree(val key1:Int,val data1:String){


    var leftNode:NodeTree?=null
    var rightNode:NodeTree?=null

}
class TreeData  {

    private var Root:NodeTree?=null

     //اسناد قيمه للشجره
    fun setData(key1:Int,Data:String){

         val newNode=NodeTree(key1,Data)

            if (Root==null) Root = newNode


            else{

                var current = Root
                var parent:NodeTree


                 while (true){
                     parent= current!!

                     if (key1< current.key1!!){

                         current=current.leftNode

                         if (current==null){
                            parent.leftNode=newNode
                             return
                         }

                     }
                     else{

                         current=current.rightNode
                         if (current==null){
                             parent.rightNode=newNode
                             return
                         }
                     }

                 }



            }
    }

    //ايجاد الاصغر
    fun findMin(): NodeTree? {
           var min = Root
           var parent_min:NodeTree?=null
        while (min!=null){
            parent_min=min
            min=min.leftNode
        }
        return parent_min
    }

    //ايجاد الاكبر
    fun findMax(): NodeTree? {
        var max = Root
        var parent_max:NodeTree?=null
        while (max!=null){
            parent_max=max
            max=max.rightNode
        }
        return parent_max
    }

    //حذف نود
    fun removeNode(key:Int):Boolean{
           //start from root of the dataStructures.tree
           var currentNode = Root
           var parentNode = Root
           var IsLeftChild = false


         // Find the intended node

           while (currentNode?.key1!=key){
               parentNode=currentNode//3
               if (key<currentNode!!.key1){
                   IsLeftChild = true
                   currentNode=currentNode.leftNode//2
               }
               else {
                   currentNode=currentNode.rightNode
                   IsLeftChild=false
               }
               if (currentNode==null )return false
           }


          //found node to remove
            val NodeFound = currentNode


           //is Leaf Node (no children) Scenario
        if(NodeFound.rightNode==null&&NodeFound.leftNode==null){

              if (NodeFound==Root)Root=null
              else if (IsLeftChild)parentNode?.leftNode= null
              else  parentNode?.rightNode=null

        }


           //has one child on the left

           else if(NodeFound.rightNode==null){
               if (NodeFound==Root)Root= NodeFound.leftNode
               else if (IsLeftChild) parentNode?.leftNode=NodeFound.leftNode
               else parentNode?.rightNode=NodeFound.leftNode

           }

           //has one child on the right

           else if(NodeFound.leftNode==null){
               if (NodeFound==Root)Root= NodeFound.rightNode
               else if (IsLeftChild) parentNode?.leftNode=NodeFound.rightNode
               else parentNode?.rightNode=NodeFound.rightNode

           }

           //has tow child
            else{


               val Successor = getSuccessor(NodeFound)// عثرنا على الوريث حفظه ورعاه

               when {
                   NodeFound==Root -> Root= Successor
                   IsLeftChild -> parentNode?.leftNode=Successor
                   else -> parentNode?.rightNode = Successor
               }

                Successor.leftNode = NodeFound.leftNode

               //connect parent of NodeFound to Successor instead
            }




        return true
    }

    private fun getSuccessor(nodeFound: NodeTree): NodeTree {
           var GodFather = nodeFound//الاب الشرعي
           var Successor = nodeFound//خليفه العائله
           var currentNode = nodeFound.rightNode//موشر للبحث في شجرة العائله

        while (currentNode!=null){

            GodFather = Successor//3
            Successor=currentNode//2
            currentNode=currentNode.leftNode//1
        }

          if (Successor!=nodeFound.rightNode){

              GodFather.leftNode = Successor.rightNode
              Successor.rightNode = nodeFound.rightNode

          }


        return Successor

    }

    fun getData(key: Int):String?{

           var fromRoot = Root
         while (true){
             if (key< fromRoot!!.key1) fromRoot = fromRoot.leftNode
             else fromRoot=fromRoot.rightNode

             if (fromRoot?.key1==key)break
             else if(fromRoot==null)break

         }
        return fromRoot?.data1
    }

      fun displayDataTree(){

          val generalStack =Stack<NodeTree>()
           generalStack.push(Root)
          var blanks = 31
          var isRowEmpty = false
          println("*******************************")

          while (isRowEmpty==false){
              val InsiderStack:Stack<NodeTree>  = Stack<NodeTree>()

               isRowEmpty= true
               for (i in 0 until blanks){
                   print("  ")
               }

               while (generalStack.isEmpty()==false){

                   val catchNode = generalStack.pop()
                   if (catchNode!=null){
                       print(catchNode.key1)
                       print("(${catchNode.data1})")
                       InsiderStack.push(catchNode.leftNode)
                       InsiderStack.push(catchNode.rightNode)
                       if (catchNode.leftNode!=null||catchNode.rightNode!=null){
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

      fun displayTree(){

        val globalStack = Stack<NodeTree>()
         globalStack.push(Root)
        var nBlanks = 2
        var isRowEmpty = false
        println("......................................................")

        while (isRowEmpty==false){
            val localStack:Stack<NodeTree>  = Stack<NodeTree>()
            isRowEmpty=true
            for(i in 0 until nBlanks) print("")


            //**************************************//

            while (globalStack.isEmpty()==false){

                val temp = globalStack.pop() as NodeTree? // global = null ,temp = root
                if (temp!=null){

                    print(temp.key1)
                    localStack.push(temp.leftNode)
                    localStack.push(temp.rightNode)
                    if (temp.leftNode!=null ||temp.rightNode!=null ){
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


}

fun main(){

    val trree = TreeData()
    //right
    trree.setData(50,"yousif")
    trree.setData(55,"fahad")
    trree.setData(57,"naif")
    trree.setData(53,"mansor")
    trree.setData(60,"amire")
    trree.setData(56,"bandar")
    //left
    trree.setData(30,"badr")
    trree.setData(32,"majeed")
    trree.setData(29,"samiy")
    trree.setData(33,"bayan")
    trree.setData(31,"omar")
    trree.setData(40,"hony")

    trree.setData(28,"soma")
    trree.setData(12,"anfal")
    trree.setData(16,"moath")
    trree.setData(11,"shhanni")

    println(trree.getData(39))


    trree.displayDataTree()




}




