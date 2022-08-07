package solvingProblems


fun maxTaxiEarnings(n: Int, rides: Array<IntArray>): Long {

   val startToEndAndEarns  = Array<ArrayList<Pair<Int,Int>>?>(n+1) {null}
    // dp[i] := max dollars you can earn starting at i

    val dp = Array<Long?>(n+1) { 0 }

    for(i in 1 .. n){
        startToEndAndEarns[i] = ArrayList()

    }

       for (ride in rides){

           val start = ride[0]
           val end = ride[1]
           val tip = ride[2]
           val earn = end - start + tip
           val pair = Pair<Int,Int>(end,earn)
           startToEndAndEarns[start]?.add(pair)


       }

    for (i in n - 1 downTo 1) {
        dp[i] = dp[i + 1]
        for (pair in startToEndAndEarns[i]!!) {
            val end: Int = pair.first
            val earn: Int = pair.second
            dp[i] = (dp[i]!!).coerceAtLeast(dp[end]!! + earn)
        }
    }
    return dp [1]!!

}





fun main (){
        val arr = Array<Int?>(7){null}
    for(i in 6 downTo  0){

           arr[arr.size-i-1] = i
    }

        val rides = Array<IntArray>(11){IntArray(3) }
                  rides[0][0]=1 //start
                  rides[0][1]=3 //end
                  rides[0][2]=4 //tip


                 rides[1][0]=1
                 rides[1][1]=4
                 rides[1][2]=1


                 rides[2][0]=1
                 rides[2][1]=5
                 rides[2][2]=2

                 rides[3][0]=2
                 rides[3][1]=3
                 rides[3][2]=6

                 rides[4][0]=2
                 rides[4][1]=5
                 rides[4][2]=6

                 rides[5][0]=3
                 rides[5][1]=4
                 rides[5][2]=4

                 rides[6][0]=4
                 rides[6][1]=5
                 rides[6][2]=2

                 rides[7][0]=6
                 rides[7][1]=7
                 rides[7][2]=1

                 rides[8][0]=7
                 rides[8][1]=8
                 rides[8][2]=7

                 rides[9][0]=7
                 rides[9][1]=9
                 rides[9][2]=6

                 rides[10][0]=8
                 rides[10][1]=10
                 rides[10][2]=4


         maxTaxiEarnings(10,rides)

  }