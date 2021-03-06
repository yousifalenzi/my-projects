package dataStructures.Graphs

import java.util.LinkedList
import java.util.Stack
import kotlin.collections.ArrayList

data class GraphsNode(var data :Int?=null){
    private var adjacencyList= HashMap<Int,GraphsNode?>()
    private var key= HashSet<Int>()
    private var num =  0

    fun getNumOfEdge():Int=num
    fun setNum(num1: Int){ this.num = num1 }

    fun getSetKey()=key
    fun adjacencyList()=adjacencyList
    companion object { var numbersOfNodes = 0 }

}
class Graph {
    private val vertexes = ArrayList<GraphsNode>()
    private var remove = 0
    private var Edges = 0


    //addition functions
    fun addVertex(value: Int): Graph {

        val newNode = GraphsNode(value)
        GraphsNode.numbersOfNodes++

        vertexes.add(newNode)
        return this
    }

    fun addEdge(vertexIndx: Int, TargetVertex: Int): Boolean {

        if (!verification(vertexIndx) || !verification(TargetVertex)) return false
        val startIndex = this.vertexes[vertexIndx]//13
        val endIndex = this.vertexes[TargetVertex]//12



        if (endIndex.getSetKey().contains(vertexIndx) == true) return false



        startIndex.adjacencyList()[TargetVertex] = endIndex
        val numOfEdge = startIndex.getNumOfEdge()
        startIndex.setNum(numOfEdge + 1)
        endIndex.getSetKey().add(vertexIndx)
        return true


    }


    //delete functions
    fun removeEdge(Index: Int, target: Int): Int? {
        if (!verification(target)) return null
        val graphsNode = this.vertexes[Index]
        val contains = graphsNode.adjacencyList()

        if (contains.contains(target) == true) {
            val numOfEdge = graphsNode.getNumOfEdge()
            graphsNode.setNum(numOfEdge - 1)

            val data = contains.get(target)?.data

            this.vertexes[Index].adjacencyList().remove(target)
            return data
        }
        return null
    }

    fun removeVertex(target: Int): Boolean {
        if (!verification(target)) {
            return false
        }
        remove = target
        this.vertexes[target].let { updateEdgeLinks(it) }
        this.vertexes.removeAt(target)
        GraphsNode.numbersOfNodes--
        return true
    }


    //Adjustment functions
    fun editVertexValue(target: Int, value: Int) {
        if (!verification(target)) return
        this.vertexes[target].data = value

    }


    //access functions
    fun printAll() {
        if (this.vertexes.size > 0) {
            println("\n*------------------*")

            var i = 0
            for (data in this.vertexes.iterator()) {

                println("${i++} / ${data.data} ----->${data.adjacencyList()}")
            }
            println("NumOfVertex = " + getNumOfVertex())
            println("*------------------*")
        }
    }

    fun getNumOfEdges() {
        if (this.vertexes.size > 0) {
            println("*------------------*")
            for (num in this.vertexes.iterator()) {
                Edges += num.getNumOfEdge()

                println("$num is content {${num.getNumOfEdge()}} Edge ----{${num.adjacencyList().keys}}")
            }
            println("*------------------*")
            println("time complexity (${Edges}+${getNumOfVertex()})")
        }


    }


    //private functions && verification functions
    private fun updateEdgeLinks(node: GraphsNode) {

        for (data in node.getSetKey().iterator()) {
            if (this.vertexes[data].adjacencyList().containsValue(node) == true) {

                this.vertexes[data].adjacencyList().remove(remove)
            }
        }
    }

    private fun getNumOfVertex(): Int = GraphsNode.numbersOfNodes
    private fun verification(target: Int): Boolean = (target < this.vertexes.size && target > -1)
    val visit = HashMap<Int, Boolean>()//to cheek vertexes

     fun dfsTraversalRecursion(vertexIndex: Int) {

        visit[vertexIndex] = true
        println(vertexes[vertexIndex].data)

        val iterator = vertexes[vertexIndex].getSetKey().iterator()

        while (iterator.hasNext())
        {
            val n = iterator.next()
           if (!visit.contains(n)){
               dfsTraversalRecursion(n)
           }

        }


    }
    fun dfsTraversalIterator(vertexIndex: Int) {

        visit[vertexIndex] = true
        println("DFS")

        println(vertexes[vertexIndex].data)

        var iterator = vertexes[vertexIndex].getSetKey().iterator()
        val stack = Stack<Int>()
        stack.add(vertexIndex)
           while (!stack.empty()){

               while (iterator.hasNext())
               {
                   val n = iterator.next()

                   if (!visit.contains(n)){
                       stack.add(n)
                       println(vertexes[n].data)

                       visit[n] = true
                       iterator = vertexes[n].getSetKey().iterator()
                   }



               }
               stack.pop()
               if (!stack.empty()){
                   iterator = vertexes[stack.lastElement()].getSetKey().iterator()

               }

           }



    }
    fun bfsTraversalIterator(vertexIndex: Int): ArrayList<Int> {

        val queue = LinkedList<Int>()//to add vertexes
        val visit = HashMap<Int, Boolean>()//to cheek vertexes
        val output = ArrayList<Int>()
        println("BFS")

        queue.add(vertexIndex)
        visit[vertexIndex] = true

        while (!queue.isEmpty()) {
            val i = queue.first
            queue.remove(queue.first)
            vertexes[i].data?.let { output.add(it) }
            println("${vertexes[i].data}")


            for (data in vertexes[i].adjacencyList().keys) {

                if (!visit.contains(data)) {

                    queue.add(data)
                    visit[data] = true
                }
            }


        }


        return output

    }

    val queue = LinkedList<Int>()//to add vertexes
    val cheek = HashMap<Int, Boolean>()//to cheek vertexes

    fun bfsTraversalRecursion(vertexIndex: Int) {

            if (!queue.isEmpty())queue.remove(queue.first)

           cheek[vertexIndex] = true
           println(vertexes[vertexIndex].data)


        for (data in vertexes[vertexIndex].adjacencyList().keys){

            if (!cheek.contains(data)){
                queue.add(data)
                cheek[data] = true
            }
        }
        if (!queue.isEmpty()){
            bfsTraversalRecursion(queue.first)
        }



    }

}

fun main(){

    val gra = Graph()
    gra.addVertex(13)//0
    gra.addVertex(12)//1
    gra.addVertex(1)//2

    gra.addVertex(15)//3
    gra.addVertex(2)//4
    gra.addVertex(7)//5
    gra.addVertex(6)//6
    gra.addVertex(3)//7
    gra.addVertex(5)//8


    gra.addEdge(0,1) // 13 -- 12 , 1
    gra.addEdge(0,2)

    gra.addEdge(1,0)// 12-- 13 , 2, 15
    gra.addEdge(1,4)
    gra.addEdge(1,3)

    gra.addEdge(2,0)// 1-- 13 , 2, 3
    gra.addEdge(2,4)
    gra.addEdge(2,7)

    gra.addEdge(3,1)// 15-- 12 ,7
    gra.addEdge(3,5)

    gra.addEdge(4,1)// 2-- 12 ,1,6,3
    gra.addEdge(4,2)
    gra.addEdge(4,6)
    gra.addEdge(4,7)

    gra.addEdge(5,3)// 7-- 15

    gra.addEdge(6,4)// 6-- 2


    gra.addEdge(7,2)// 3-- 5,2,1
    gra.addEdge(7,4)
    gra.addEdge(7,8)

    gra.addEdge(8,7)

    gra.dfsTraversalIterator(8)
    gra.bfsTraversalIterator(8)



    gra.printAll()
    gra.getNumOfEdges()

   gra.bfsTraversalRecursion(0)




}