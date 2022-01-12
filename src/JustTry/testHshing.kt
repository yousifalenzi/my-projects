package JustTry

import java.util.*


 fun hashfun(str:String,size:Int):Int{


     val hash = str.hashCode() //
     var index = hash%size // 2365799%10 = 1
     // key.hashCode() coule be negative.
     index = if (index < 0) index * -1 else index

     return index

 }
fun main(){

      var index = 0

      val stri = Array<String?>(5,{null})

          index = hashfun("yousif",stri.size)
          stri[index] = "yousif"

    index = hashfun("ali",stri.size)
    stri[index] = "ali"

    index = hashfun("goole",stri.size)
    stri[index] = "google"

    index = hashfun("hoolyg",stri.size)
    stri[index] = "hoolyg"


    index = hashfun("toto",stri.size)
    stri[index] = "toto"

    for (item in stri.iterator()){

         println(item)
     }
}