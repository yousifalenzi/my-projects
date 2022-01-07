package dataStructures.implementingArray

fun main(){



    val myarr = MyArray(5)

     myarr.push(12)
     myarr.push(23)
     myarr.push(24)
     myarr.push(76)
     myarr.push("yousif")


    myarr.printAllData()

    println("============================")
   println( myarr.isNull())


}