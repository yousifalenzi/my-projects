package dataStructures.Graphs

import java.util.ArrayList

class MyGraph (val vcount:Int) {// length of array


    private var NumberOf_E_Count:Int=0// edges
    private var adjacents :Array<ArrayList<Int>?>?=null



      init {
            adjacents = Array(vcount,{null})//Initialize the variables

          for (i in 0 until vcount){// 0 - vCount
             val newarray= ArrayList<Int>() // new object from arraylist

              adjacents!![i] =newarray
          } }

        fun getVertexCount():Int = vcount
        fun getEdgesCount():Int = NumberOf_E_Count

       fun addEdges(Vertex:Int,des:Int){

           adjacents?.get(Vertex)?.add(des)
           NumberOf_E_Count++
       }

       fun adj (scr:Int): Array<out Any> {

           return adjacents!![scr]!!.toArray()
       }
       fun findpath(from:Int , to:Int):Boolean{

           val adj = adj(from)//2

             for (a in adj){

                 if (a.equals(to)) return true
             }
           return false
       }

      fun findsize(scr:Int): Int {


          return adjacents!![scr]?.size!!
      }


}


fun main(args:Array<String>){



}