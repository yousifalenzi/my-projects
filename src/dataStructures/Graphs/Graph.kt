package dataStructures.Graphs

import java.util.ArrayList

data class GraphsNode(var data :Int?=null){
    var adjacencyList= HashMap<Int,GraphsNode?>()
    var KeySet= HashSet<Int>()
    var Num =  0


    companion object Insider{

        var numbersOfNodes = 0

    }
     fun getNumOfEdge():Int=Num
}
class Graph {
        private val vertexes= ArrayList<GraphsNode?>()
        private var remove = 0


    //addition functions
      fun addVertex (value:Int):Graph{

        val newNode = GraphsNode(value)
        GraphsNode.numbersOfNodes++

        vertexes.add(newNode)
         return this
    }
      fun addEdge (indexStart:Int,indexEnd:Int):Boolean{

        if (indexStart<this.vertexes.size&&indexEnd<this.vertexes.size
                &&indexStart>-1&&indexEnd>-1){


            val startIndex = this.vertexes.get(indexStart)
            val EndtIndex = this.vertexes.get(indexEnd)

            if (startIndex != null) {
                startIndex.adjacencyList.put(indexEnd,EndtIndex)
                startIndex.Num++
                EndtIndex!!.KeySet.add(indexStart)
            }
            return true

        }
         return false
    }



      //delete functions
       fun removeEdge(Index:Int,target: Int):Int?{
             if (Index<this.vertexes.size&&Index>-1){
                 val graphsNode = this.vertexes[Index]
                 val contains = this.vertexes[Index]?.adjacencyList

                 if (contains?.contains(target)==true){
                     graphsNode!!.Num--
                     val data = contains.get(target)?.data

                     this.vertexes[Index]?.adjacencyList?.remove(target)
                     return data
                 }

             }
        return null
    }
       fun removeVertex(target: Int):Boolean{
        if (target<this.vertexes.size&&target>-1){
            remove = target
            this.vertexes[target]?.let { updateEdgeLinks(it) }
            this.vertexes.removeAt(target)
            GraphsNode.numbersOfNodes--
            return true

        }
          return false
    }



       //Adjustment functions
      fun editVertexValue(target: Int, value:Int){
          if (target<this.vertexes.size&&target>-1){
                 this.vertexes[target]!!.data = value



          }

      }



      //access functions
      fun printAll(){

          println("*------------------*")

           var i = 0
          for(data in this.vertexes.iterator()){

              println("${i++} / ${data?.data} ----->${data?.adjacencyList}")
          }
          println("NumOfVertex = "+getNumOfVertex())
          println("*------------------*")




     }
      fun getNumOfEdges(){
           println("*------------------*")
        for (num in this.vertexes.iterator()){

            println("$num is content {${num?.Num}} Edge")
        }
          println("*------------------*")

      }

    //private functions
    private fun updateEdgeLinks(node: GraphsNode) {

            for (data in node.KeySet.iterator()){
            if(this.vertexes[data]?.adjacencyList?.containsValue(node) == true){

                this.vertexes[data]?.adjacencyList?.remove(remove)
            }
        }
    }
    private fun getNumOfVertex():Int = GraphsNode.numbersOfNodes


}

fun main(){

       val gra = Graph()
      gra.addVertex(12)
      gra.addVertex(22)
      gra.addVertex(53)
      gra.addVertex(74)
      gra.addVertex(29)

    gra.addEdge(1,2)
    gra.addEdge(1,3)
    gra.addEdge(1,0)

    gra.addEdge(2,3)

    gra.addEdge(3,4)
    gra.removeEdge(2,3)
    gra.printAll()
    gra.getNumOfEdges()



}