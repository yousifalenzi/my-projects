package dataStructures.Graphs



class LinkGraph_ByAhmeed (val Vcount:Int,val GraphType:String){


     private var vertexaraay:Array<Vertex?>?=null // array of vertex
     private var Counter:Int=0 // count a number of vertex add it
     private var undirected:Boolean=true // Clarify whether the array is direct or indirect
     private  data class Vertex (val name:String, var adjLis: NodeVertex?)//internal class to hold vertex data
     private data class NodeVertex(val vertexIndex:Int, val next: NodeVertex?)//internal class to hold vertex data
     init {
         if (undirected)undirected=false
          vertexaraay=Array(Vcount,{null})

     }



      //Additional functions
     fun addVertex(vertexes:String){
            val vertex = Vertex(vertexes,null) // new object form vertex class
            vertexaraay?.set(Counter, vertex)// add a object in vertex array
            Counter++// increase (+1) Each time it is vertex added
     }
     fun addEdges(startPoint:String, endPoint:String){
              val startpoint = findVertexIndex(startPoint)//get main vertex index
              val endpoint = findVertexIndex(endPoint)//get index connected by vertex


              val node = NodeVertex(endpoint!!, vertexaraay!![startpoint!!]?.adjLis)



              vertexaraay!![startpoint]?.adjLis = node
     }

     //print functions
      fun print (){

          for(xX in 0..vertexaraay!!.size-1){
              print("${vertexaraay!![xX]?.name}")//sta
               var current =vertexaraay!![xX]?.adjLis
               while (current!=null){
                   print("--->${vertexaraay!![current.vertexIndex]?.name}")
                   current=current.next
               }
              println("\n")
          }
      }



    private fun findVertexIndex(VertexName:String):Int?{
        VertexName.filter {!it.isWhitespace()}

        for (arr in vertexaraay!!.indices){
            if (vertexaraay!![arr]?.name==VertexName)return arr
        }
        return null
    }
}
fun main(args:Array<String>){


      val linkGraph = dataStructures.Graphs.LinkGraph_ByAhmeed(5, "directed")

    linkGraph.addVertex("State")
    linkGraph.addVertex("Avenel")
    linkGraph.addVertex("Elm")
    linkGraph.addVertex("Pocono")
    linkGraph.addVertex("William")

    //state
    linkGraph.addEdges("State","Avenel")
    linkGraph.addEdges("State","Elm")
    linkGraph.addEdges("State","William")

    //Elm
    linkGraph.addEdges("Elm","Avenel")
    linkGraph.addEdges("Elm","William")

    //William
    linkGraph.addEdges("William","State")
    linkGraph.addEdges("William","Pocono")

    //mixed
    linkGraph.addEdges("Avenel","Pocono")
    linkGraph.addEdges("Avenel","William")
    linkGraph.addEdges("William","Elm")
    linkGraph.addEdges("Pocono","Elm")


    linkGraph.print()

}
