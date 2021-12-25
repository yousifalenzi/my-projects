package dataStructures.Graphs




open class LinkGraph(private val Vertex :Int , private val TypeGraph:String) {



         // variables
        private var streetArray:Array<GraphLinkedList?>?=null
        private var edgesCount:Int = 0
        private var vertexNum = 0

            //Initialize the variables
            init {
           streetArray = Array(Vertex,{null})
           for (i in 0 until Vertex){
               val newNode = GraphLinkedList()
               streetArray!![i] = newNode
           }
       }


        //Additional functions
       fun addVertex(streets: String):Boolean{

          if (isEmpty()){//0 - 5

              streetArray?.get(vertexNum)?.setnameS(streets)
              vertexNum++
              return true

          }
          return false
      }
       fun addEdges(formStreet: String,toStreet:String):Boolean{

             val vertexName = filterString(formStreet)
             val tooStreet = filterString(toStreet)

             val newdistnation = GraphLinkedList()
             newdistnation.setnameS(toStreet)



            val findVertexIndex = findVertexIndex(vertexName) ?: return false


            var parent= streetArray!![findVertexIndex]
            var pointer=parent



           while (pointer!=null){

               parent=pointer
               pointer=pointer.NextStreet

              }

           parent?.NextStreet = newdistnation
           edgesCount++


           return true
       }


       //print functions
        fun printVertex(){streetArray?.forEach {
           println(it?.getNames()) }}
        fun printEdgesNames(VertexName:String):Boolean{

           val getIndex = findVertexIndex(VertexName)?: return false
           var parent = streetArray!![getIndex]
           var current = parent

           print("You can Go from ( ${parent?.getNames()} )street To ---> ")
           current=current?.NextStreet

           if (current==null)  print(" (There is no available destination) ")
           else{
               while (current!=null){

                   parent=current
                   print(" (${current.getNames()}) ")
                   current=current.NextStreet

               }
           }



         println()
         return true

    }
        fun printAllVertexWithEdges(){


             println("------${this.TypeGraph}------")
            streetArray?.forEach {
                println()
                var current = it
                print(" ( ${current?.getNames()} ) ---> ")
                 current=current?.NextStreet
                 if (current==null)print(" (There is no available destination) ")
                else{
                     while (current!=null){
                         print(" -(${current.getNames()})- ")
                         current=current.NextStreet }
                }



            }
            println()
            println("------o0o0o0o0o0o------")

        }


        //Get functions
        fun getEdgesLength():Int = edgesCount
        fun getVertexLength():Int = vertexNum


      // private functions
      private fun filterString(Str:String):String{

        Str.filter {!it.isWhitespace()}

        return Str
    }
      private fun isEmpty():Boolean=vertexNum<Vertex
      private fun findVertexIndex(VertexName:String):Int?{
        val vertexes = filterString(VertexName)
           for (arr in streetArray!!.indices){
               if (streetArray!![arr]?.getNames()==vertexes)return arr
           }
        return null
    }



    //internal class
     private class GraphLinkedList(){

        var NextStreet:GraphLinkedList?=null
        private var StreetName:String?=null


        fun setnameS(streetnameSet:String){
            streetnameSet.filter {!it.isWhitespace()}
            this.StreetName = streetnameSet

        }
        fun getNames()=this.StreetName
    }


}

fun main(args:Array<String>){

    val linkGraph = dataStructures.Graphs.LinkGraph(5, "directed")

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

    linkGraph.printAllVertexWithEdges()











}