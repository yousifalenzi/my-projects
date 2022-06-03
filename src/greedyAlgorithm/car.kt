package greedyAlgorithm

interface vehicle {

     fun start()
     fun stop()
}

class car :vehicle{
     override fun start() {
        println("start")
    }

    override fun stop() {
        println("stop")
    }


    private fun apply(v:vehicle){

        v.start()
    }
    fun print (){
        apply(this)
    }
}

fun main(){

    val c = car()
    c.print()
}