package JustTry

class bigO {




    fun Constant_O_1(){


        val i = 1  // O(1)
        print(i) // O(1)
    } // O(1)

    fun Log_n(){
         var i = 0
        while (i<10){
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