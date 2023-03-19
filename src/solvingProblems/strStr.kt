package solvingProblems
fun strStr(haystack: String, needle: String): Int {

      var index = 0
      var partOfWord = -1
    for (i in haystack.indices){
       var inner = i


        while (index<needle.length&&inner<haystack.length&&needle[index]==haystack[inner]){

            if (partOfWord==-1){
                partOfWord=inner
            }
            index++
            inner++


        }

        if (index==needle.length-1||index<needle.length){
            partOfWord=-1
            index=0
        }

    }
    val result = needle.length
    return if (index==result) partOfWord
    else -1
}




fun main (){


 println( strStr("aaa","aaaa"))


  }
