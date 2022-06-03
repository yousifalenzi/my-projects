package greedyAlgorithm

// Java program to solve fractional Knapsack Problem


// Greedy approach
object FractionalKnappSack {
    // function to get maximum value
     fun getMaxValue(wt: IntArray, cost: IntArray, capacity: Int): Double {
          var cap = capacity

        val iVal = arrayOfNulls<ItemValue>(wt.size)
        for (i in wt.indices) {
            iVal[i] = ItemValue(wt[i], cost[i])
        }

        sort(iVal)
        var total = 0.0

        iVal.forEach {

                  val curWt = it?.wt
                  val curVal= it?.value
              if (cap - curWt!! >= 0) {
                  // this weight can be picked while
                  cap -= curWt
                  total += curVal!!.toDouble()
              } else {
                  // item can't be picked whole
                  val fraction = cap.toDouble() / curWt.toDouble()
                  total += curVal!! * fraction
                  cap = (cap - curWt * fraction).toInt()

              }

          }

        return total
    }



    // item value class
    class ItemValue(var wt: Int, val value: Int) {

        var cost :Double?=null
        // item value function
        init {

            cost = value.toDouble() / wt.toDouble()
        }



    }


    fun sort(array: Array<ItemValue?>) {


        var step = array.size-1

        while (step>0){

            for (i in 0 until  step){

                if (array[i]?.cost!! < array[i+1]?.cost!!){
                    //store data
                    val data =  array[i+1]

                    //swap
                    array[i+1] = array[i]
                    array[i]   = data

                }


            }
            step--


        }

    }


}
fun main(args: Array<String>) {
    val wt = intArrayOf(10, 40, 20,30)
    val values = intArrayOf(60, 40, 100,120)
    val capacity = 50

    val maxValue = FractionalKnappSack.getMaxValue(wt, values, capacity)

    // Function call

    // Function call
    println(
        "Maximum value we can obtain = "
                + maxValue.toInt()
    )
}