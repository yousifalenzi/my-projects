package solvingProblems




  fun main (){
       val i1 = IntArray(4)
       val i2 = IntArray(3)
       val i3 = IntArray(3)

      i1[0] = 1
      i1[1] = 2
      i1[2] = 8

      i2[0] = 2
      i2[1] = 3
      i2[2] = 4

      i3[0] = 1
      i3[1] = 3
      i3[2] = 23


      val array = Array(4) { IntArray(3) }
      array[0] = i1
      array[1] = i2



        for ( d in 0 until array.size){
            for ( r in 0 until array[d].size){

                println("[${array[d].get(r)}]")
            }


        }



  }