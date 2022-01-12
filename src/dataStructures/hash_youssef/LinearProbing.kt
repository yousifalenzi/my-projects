package dataStructures.hash_youssef

import java.util.*
import kotlin.collections.ArrayList


private data class HshNod<K,V>(val key:K,val value:V)


public class LinearProbing<K,V>(val size:Int) {
    private var array: Array<HshNod<K,V>?>
    private var listOfIndex:ArrayList<Int>
    private var numberOfData = 0


    init {

        array=Array(this.size,{null})
        listOfIndex= ArrayList<Int>()
    }

    //operation's
    fun add(key:K,vaule:V): Boolean { // O(N)

        if (IsFull())return false
            else{
            //new object
            val HshNod_=HshNod<K,V>(key,vaule)

            //select index
            val index = HashFunc(HshNod_.key)
            val linearProbing = LinearProbing(index)

            //add value to array
            array[linearProbing] = HshNod_
            numberOfData++
            return true
        }

    }
    fun remove(key:K){

        var index = HashFunc(key)
         if (key==array[index]?.key) {
             array[index] = null
             listOfIndex.add(index)
             numberOfData--

         }

          else{
             while (key!=array[index]?.key){
                 index++

             }
             listOfIndex.add(index)
             array[index] = null
             numberOfData--

         }


    }
    fun getValue(key:K): V? {

        var index = HashFunc(key)
          if (array[index]?.key==key)return array[index]?.value

         while (array[index]?.key !=key&&index<this.size-1){
             index++
             if (array[index]?.key==key)return array[index]?.value

         }


          return null


    }

      //return values and keys
       fun getKeys():List<K>{
             val listOfKeys = ArrayList<K>()
          for(key in array.iterator()){

              listOfKeys.add(key!!.key)
          }

         return listOfKeys
      }
       fun getValues():List<V>{
           val listOfValues = ArrayList<V>()

           for (key in getKeys().listIterator()){

               listOfValues.add(getValue(key)!!)
           }
           return listOfValues
       }

    //print functions and cheek
    fun show_All(){for(item in array.iterator()) println(item)}
    fun IsFull():Boolean =numberOfData==this.size

    //hashing func

     private fun HashFunc(key:K):Int{

        val hash = hashcode(key)
        var index1 = hash%this.size
        index1 = if (index1 < 0) index1 * -1 else index1

       return index1


    }
     private fun LinearProbing(i:Int):Int{
        var index2 = i
           if (listOfIndex.size>0){
               index2 = listOfIndex[0]
               listOfIndex.removeAt(0)

               return index2

           }
        else{

               while (index2<=this.size-1&&array[index2]!=null){

                   index2++
               }

               return index2

           }


    }
     private fun hashcode(key:K):Int{

        return Objects.hashCode(key)
    }

}
fun main(){


    val linear=LinearProbing<String,Int>(7)
    linear.add("yousif",337664489)
    linear.add("ali",887441149)
    linear.add("naif",124544267)
    linear.add("mousa",234567654)
    linear.add("bader",343535366)
    linear.add("amjeed",44789900)
    linear.add("fahad",111133456)


    println(linear.getKeys())
    println(linear.getValues())

    linear.show_All()




}