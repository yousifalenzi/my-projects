package solvingProblems

    private var Total = Array<String?>(2) { "" }
    fun getAll():Array<String?> = Total
    fun knapsack(w:Array<Int>,p:Array<Int>,knapsack_size:Int):Array<IntArray>{

    val matrix = Array(w.size) { IntArray(knapsack_size+1) }

    for (i in w.indices){//1 -- 4

      var wight = 0

      while (wight<=knapsack_size){

        if (i==0||wight==0){

          matrix[i][wight] = 0
        }
        else if (w[i]<=wight) // 2+[1][4-1] 2+1=3 , [1][4] = 1
        {

          matrix[i][wight] = max( p[i]+matrix[i-1][wight-w[i]],matrix[i-1][wight])
        }
        else {

          matrix[i][wight] = matrix[i-1][wight]
        }

        wight++

      } } 
   
   return  matrix
   }
    fun includedOrNot(Bag:Array<IntArray>, w:Array<Int>, p:Array<Int>): Array<String?> {


       var row = Bag.size-1 // 4
       var column = Bag[0].size-1 //8
       val arrayOfObjects = Array<String?>(Bag.size) { "NotIncluded(0)" }
     var wi = 0
       var pr = 0
     while (row>0&&column>0){

        if (Bag[row][column]!=Bag[row-1][column]){
          arrayOfObjects[row] = "Included($row)"

          wi+=w[row]
          pr+=p[row]

          column -= w[row]
        }
        else{
          arrayOfObjects[row] = "NotIncluded($row)"

        }



        row--
      }


     Total[0]="All weight can be carried =${wi}"
     Total[1]="All profit can be carried =${pr}"

      return arrayOfObjects


   }
    private fun max(v1: Int,v2:Int):Int=if (v1>v2) v1 else v2


fun main (){

  val wi = arrayOf(0, 3, 1, 2, 5)
  val pr = arrayOf(0, 1, 2, 5, 6)


  val knapsack01 = knapsack(wi,pr, 8)
    for(arr1 in knapsack01.iterator()){
        for(arr2 in arr1.iterator()){

            print("$arr2 ")
        }
        println("\n")

    }

  val includedOrNot = includedOrNot(knapsack01, wi,pr)

  for (i in includedOrNot.iterator()){

    print("[$i],")
  }
  println("\n")
  for (i in getAll().iterator()){

    print("[$i],")
  }

}