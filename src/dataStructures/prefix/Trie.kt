package dataStructures.prefix

import JustTry.Higher_Order_Function_and_Lambda.plus
import dataStructures.stack.get

class TrieNode(){

       var children = arrayOfNulls<TrieNode?>(26)
       var isEndOfWord = false
       var word:String?=null
       var array: MutableList<Char>

       init {
           this.array = mutableListOf()
            for (i in 0 until 26){

                children[i] = null
            }
        }
   }
class Trie {

    var root:TrieNode?= dataStructures.prefix.TrieNode()

    fun insert(word:String){
        var level: Int
        val length: Int = word.length
        var index: Int

        var pCrawl = root!!


            level = 0
            while (level < length) {
                index = word[level]-'a'

                if (pCrawl.children[index] == null) {pCrawl.children[index] = dataStructures.prefix.TrieNode()
                    pCrawl.array.add(word[level])

                }
                pCrawl = pCrawl.children[index]!!

                level++
            }


        // mark last node as leaf

        // mark last node as leaf
        pCrawl.isEndOfWord = true
        pCrawl.word = word

        }
    fun serach (word:String):Boolean{

        var pCrawl = root!!
        val level: Int
        level = 0

        for (i in 0 until word.length){

            val index = word[i]-'a'
            if (pCrawl.children[index]==null)return false
            pCrawl= pCrawl.children[index]!!
        }
        return pCrawl.isEndOfWord


    }
    fun getAll(node:TrieNode){

               if (node.array.size==0)return

        for (i in 0 until  node.array.size ){ // 2
              val index = node.array[i]-'a' // 7
            var nody   = node.children[index]!!//t
            if (nody.isEndOfWord==true) println(nody.word)
            getAll(nody)
        }



    }












    }

