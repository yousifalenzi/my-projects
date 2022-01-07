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
fun reversString2(str:String): String {
    var name:String = ""
    val strSize = str.length-1
    var f = 0
    for (i in str.indices){
            f = strSize-i
           name+=str[f]


    }

    return name

}
fun reversString3(str:String): String = str.reversed()
fun reversString4(str:String): String {


    val toList = str.toList()
    var name =""

      for (i in toList.size-1 downTo 0){
          name+=toList[i]
      }


          return name

}

fun main(){

//  val SayHi = "Hi   StackOverFlow".filter { !it.toString().isBlank() }

    val str4 = "Hello Yousef"

      println( reversString2(str4))

}