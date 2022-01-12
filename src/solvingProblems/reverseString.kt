package solvingProblems

//revers String   example = "hi my name Yousef" = "fisuoy eman ym ih"
fun reversString1(str:String): String {
                   var name:String = ""
                   var index = str.length-1
            for (i in str.indices){

               name+=str[index]
               index--

           }

    return name

}

fun reversString2(str:String): Any {
       //if false
      val contentNull= StringContentNull(str).length
      if (contentNull<2)return false

      //if true
      var name =""
      val strSize = str.length-1

    for (i in strSize downTo 0){
          name+=str[i]
      }
          return name
}



//special functions
fun reversString_kotlinWay(str:String): String = str.reversed()
fun StringContentNull(Str:String): String = Str.filter { !it.isWhitespace() }


fun main(){

//  val SayHi = "Hi   StackOverFlow".filter { !it.toString().isBlank() }
//     val str = "hello guys !".split(" ").toTypedArray()
     val str = "hello guys !".split(" ").toTypedArray()


}