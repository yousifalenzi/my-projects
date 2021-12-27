package JustTry

class bigO {




    fun Constant_O_1(){


        val i = 1  // O(1)
        print(i) // O(1)
    } // O(1)

    fun Log_n(array){
         var i = 0
        while (i<array.size){
            i+=2
            println(i)

        }
    } // O(LOG N )

    fun Big_N(vararg name:String){


        for(i in 0 until name.size){

            println(name[i])
        }
    } // O(N)


}
