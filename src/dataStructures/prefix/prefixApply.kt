package dataStructures.prefix

import java.util.ArrayList

fun main (){

   val makeword = dataStructures.prefix.Trie()

    val keys = arrayOf("cat","car","cold","food","yousif","you","yours")

    makeword.root = dataStructures.prefix.TrieNode()
    var i: Int

        i = 0


    while (i < keys.size) {
        makeword.insert(keys[i])
        i++
    }

    val node = makeword.root!!.children['y'-'a']
    if (node != null) {
        makeword.getAll(node)
    }



}

