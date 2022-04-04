package dataStructures.Graphs

import java.util.ArrayList

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
        private val vertexes= ArrayList<GraphsNode?>()
        private var remove = 0


    //addition functions
      fun addVertex (value:Int):Graph{

        val newNode = GraphsNode(value)
        GraphsNode.numbersOfNodes++

        vertexes.add(newNode)
         return this
    }
      fun addEdge (vertexIndx:Int,TargetVertex:Int):Boolean{

           if (!verification(vertexIndx) || !verification(TargetVertex)) return false
              val startIndex = this.vertexes[vertexIndx]
              val endIndex = this.vertexes[TargetVertex]



          if (endIndex?.getSetKey()?.contains(vertexIndx) == true)return false
              if (startIndex != null&& endIndex != null) {
                  startIndex.adjacencyList()[TargetVertex] = endIndex

                  val numOfEdge = startIndex.getNumOfEdge()
                  startIndex.setNum(numOfEdge+1)
                  endIndex.getSetKey().add(vertexIndx)
                  return true

              }
              return false

      }



      //delete functions
       fun removeEdge(Index:Int,target: Int):Int?{
          if (!verification(target)) return null
          val graphsNode = this.vertexes[Index]
          val contains = graphsNode?.adjacencyList()

          if (contains?.contains(target)==true){
              val numOfEdge = graphsNode.getNumOfEdge()
              graphsNode.setNum(numOfEdge-1)

              val data = contains.get(target)?.data

              this.vertexes[Index]?.adjacencyList()?.remove(target)
              return data
          }
          return null
    }
       fun removeVertex(target: Int):Boolean{
           if (!verification(target)) {
               return false
           }
           remove = target
           this.vertexes[target]?.let { updateEdgeLinks(it) }
           this.vertexes.removeAt(target)
           GraphsNode.numbersOfNodes--
           return true
       }



       //Adjustment functions
      fun editVertexValue(target: Int, value:Int){
           if (!verification(target)) return
           this.vertexes[target]!!.data = value

       }




      //access functions
       fun printAll(){
          if (this.vertexes.size > 0) {
              println("*------------------*")

              var i = 0
              for(data in this.vertexes.iterator()){

                  println("${i++} / ${data?.data} ----->${data?.adjacencyList()}")
              }
              println("NumOfVertex = "+getNumOfVertex())
              println("*------------------*")
          }
      }
       fun getNumOfEdges(){
           if (this.vertexes.size > 0){
               println("*------------------*")
               for (num in this.vertexes.iterator()){

                   println("$num is content {${num?.getNumOfEdge()}} Edge ----{${num?.adjacencyList()?.keys}}")
               }
               println("*------------------*")
           }


      }


    //private functions && verification functions
    private fun updateEdgeLinks(node: GraphsNode) {

            for (data in node.getSetKey().iterator()){
            if(this.vertexes[data]?.adjacencyList()?.containsValue(node) == true){

                this.vertexes[data]?.adjacencyList()?.remove(remove)
            }
        }
    }
    private fun getNumOfVertex():Int = GraphsNode.numbersOfNodes
    private fun verification(target: Int): Boolean = (target<this.vertexes.size&&target>-1)

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
    gra.removeEdge(2,1)
    gra.addEdge(4,2)
    gra.addEdge(0,1)

    gra.printAll()
    gra.getNumOfEdges()



}