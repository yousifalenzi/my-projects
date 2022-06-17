package solvingProblems

 private var totalwightandProfit = Array<String?>(2) { "" }
    fun getAll():Array<String?> = totalwightandProfit
   fun KnapSack0_1(w:Array<Int>,p:Array<Int>,KnapSack_size:Int):Array<IntArray>{

    val Matrix = Array(w.size) { IntArray(KnapSack_size+1) }

    for (i in w.indices){//1 -- 4

      var wight = 0

      while (wight<=KnapSack_size){

        if (i==0||wight==0){

          Matrix[i][wight] = 0
        }
        else if (w[i]<=wight)
        {

          Matrix[i][wight] = max( p[i]+Matrix[i-1][wight-w[i]],Matrix[i-1][wight])
        }
        else {

          Matrix[i][wight] = Matrix[i-1][wight]
        }

        wight++

      } } 
   
   return  Matrix
   }
   fun IncludedOrNot(Bag:Array<IntArray>,w:Array<Int>,p:Array<Int>): Array<String?> {

       var row = Bag.size-1 // 4
       var column = Bag[0].size-1 //8
       val arrayOfObjects = Array<String?>(Bag.size,{ "NotIncluded(0)"})
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


     totalwightandProfit[0]="All weight can be carried =${wi}"
     totalwightandProfit[1]="All profit can be carried =${pr}"

      return arrayOfObjects


   }
   private fun max(v1: Int,v2:Int):Int=if (v1>v2) v1 else v2


fun main (){


  val knapsack01 = KnapSack0_1(arrayOf(0, 2, 3, 4, 5), arrayOf(0, 1, 2, 5, 6), 13)

  val includedOrNot = IncludedOrNot(knapsack01, arrayOf(0, 2, 3, 4, 5),arrayOf(0, 1, 2, 5, 6))

  for (i in includedOrNot.iterator()){

    print("[$i],")
  }
  println("\n")
  for (i in getAll().iterator()){

    print("[$i],")
  }

}