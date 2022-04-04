package threads

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun log(start: Long, msg: String) {
    println("$msg " +
            "(on ${Thread.currentThread().name}) " +
            "after ${(System.currentTimeMillis() - start)/1000F}s")
}
//  2 -  4  -  6
suspend fun main(){

    val start = System.currentTimeMillis()
    coroutineScope {

        for (i in 0 until 10){
            launch {

                delay(3000L - i * 300)
                log(start, "Countdown: $i")
            }

        }


    }
    // Execution continues when all coroutines in the scope have finished
    log(start, "Liftoff!")


}