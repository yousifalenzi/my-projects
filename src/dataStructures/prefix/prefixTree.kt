package dataStructures

import dataStructures.refresh_queue.pr
import java.util.*

data class Node(var word: Char?) {

   val children  =Hashtable<Char,Node>()
    var isWord = false

}
class prefixTree {

      val root = Node(' ')
      var makenode :Node?=null

    fun insert (str:String,node1: Node){
        val toCharArray = str.toCharArray() //convert to char
        val get = node1.children.get(toCharArray[0]) // cheek first char

         if (get==null){
             val node = Node(toCharArray[0])
             node1.children[node.word]= node
             makenode = MakeWord(node, toCharArray.copyOfRange(1, toCharArray.size))
         }
        else {
             val toString = toCharArray.copyOfRange(1, toCharArray.size)
             val concatToString = toString.concatToString(0, toCharArray.size-1)
             insert(concatToString,get)
        }


    }

      fun getword(letter:String):Boolean?{
          val array = letter.toCharArray()
          var get = this.root.children.get(array[0]) // cheek first char
          if (get==null) return false


               var i =1
               var getnode = get
              while (get!=null&&i<array.size){
                  get = get.children.get(array[i])
                  getnode = get

                  i++


              }
              if (get==null) return false
              return getnode?.isWord



      }


    fun getall(node1:Node?){




        for (values in node1?.children!!.iterator()){
            println(values.key)
            val node = node1.children[values.key]
            getall(node)


        }





    }
    private fun MakeWord(node:Node,array:CharArray):Node{

             var newNode = node

        for (i in 0 .. array.size-1){

            val newnode =Node(array[i])
            newNode.children[array[i]] = newnode
            newNode = newnode
        }
        newNode.isWord = true
        return newNode

    }

}

