package dataStructures.hashtable

class DoubleHashTable(val noOfSlot:Int){

    var StringArray:Array<Cars?> // المصفوفه المارد تعبئتها
    var arraysize:Int?=null // حجم المصفوفه
    var counter = 0 // الحجم الحالي الذي يزيد مع كل اضافه

        init {
        if (isPrime(noOfSlot)){

            StringArray = Array(noOfSlot,{null})
            arraysize = noOfSlot

        }
        else{

            val getnextprime = getNextPrime(noOfSlot)
            StringArray = Array(getnextprime,{null})
            arraysize = getnextprime

            println("the size was given before($noOfSlot) not equal prime number " )
            println("the new size changed to $getnextprime equal prime number" )

        }
    }

       private fun isPrime (n:Int):Boolean{
             val nn = n/2
          for (i in 2 until nn){

              if (n%i==0)return false
          }
          return true
      }
       private fun getNextPrime(noOfSlot:Int):Int{
        var nextPrimeNumber = noOfSlot+1
        while (true){

            if (isPrime(nextPrimeNumber)) {
                return nextPrimeNumber
            }
            nextPrimeNumber++
        }
    }

    //return preferred index

    private fun hashfunc1(word:String): Int {
        var hashcode = word.hashCode()
        hashcode%=arraysize!!
        if (hashcode<0) hashcode+=arraysize!!
        return hashcode//ideal index position we'd like insert or search in
    }
    //return step size
    private fun hashfunc2(word:String):Int{
        var hashcode = word.hashCode()
        hashcode%=arraysize!!
        if (hashcode<0) hashcode+=arraysize!!



        return 3-hashcode%3 // step size


    }



    fun findWord(word:String):Cars?{

        var hashVal = hashfunc1(word) // 2
        val getStepSize = hashfunc2(word)//3

        while (StringArray[hashVal]!=null){//[2,4,null,5]
          if (StringArray[hashVal]?.name.equals(word))return StringArray[hashVal]!!

            hashVal += getStepSize//2+3 = 5
            hashVal %= arraysize!!//5%15 = 5

        }
        return null
    }

    fun printAll(){

        for (arr in StringArray.indices) {

              println(StringArray.get(arr)?.printCarInfo())
        }
    }
    fun insertWord(word:String,model:Int,comp:String){

        var hashVal = hashfunc1(word)
        val getStepSize = hashfunc2(word)

        while (StringArray[hashVal]!=null){//[2,4,null,5]

            hashVal += getStepSize//4+3 = 7
            hashVal %= arraysize!!//4%15 = 7

        }

        StringArray[hashVal] = object : Cars(word,model,comp){}
        counter++
    }

     fun findIndex(word: String):Int?{

         var hashVal = hashfunc1(word) // 2
         val getStepSize = hashfunc2(word)//3

         while (StringArray[hashVal]!=null){

             if (StringArray[hashVal]?.name.equals(word))return hashVal

             hashVal += getStepSize//2+3 = 5
             hashVal %= arraysize!!//5%15 = 5
         }
         return null
     }
}
open class Cars(val name:String?=null,val Model:Int?=null,val Company:String?=null){

    fun printCarInfo(){

        println("CAR NAME IS ($name) ,  COMPANY NAME IS ($Company),  MODEL CAR IS ($Model)")
    }


}
fun main(args:Array<String>){



     val hash = dataStructures.hashtable.DoubleHashTable(6)
    hash.insertWord("Corvette",1953,"Chevrolet")
    hash.insertWord("Testarossa",1984,"Ferrari")
    hash.insertWord("Viper",1992,"Dodge")
    hash.insertWord("Veyron",2006,"Bugatti")
    hash.printAll()





}