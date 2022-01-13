package dataStructures.hash_youssef

import java.util.*
import kotlin.collections.ArrayList


private data class HshNod<K,V>(val key:K,val value:V)


public class LinearProbing<K,V>(private val size:Int) {
    private var HashArry: Array<HshNod<K,V>?>
    private var Null_Position:ArrayList<Int>
    private var numberOfDataExits = 0
    private val sizearray = this.size-1
    private var Save_Keys_In_List = HashSet<K>()

    init {

        HashArry=Array(this.size,{null})
        Null_Position= ArrayList<Int>()
    }
    //--------------------------public functions--------------------------------------//

     //add value to array
      public fun add(key:K,vaule:V): String { // O(N)

        if (IsFull()||Key_Is_Exist(key))return "Key Is Exist or Is Full !!"
            else{
            //new object
            val HshNod_=HshNod<K,V>(key,vaule)
            val data  = IsDataHavespeace()
              if (data!=null){
                  HashArry[data] = HshNod_
                  Save_Keys_In_List.add(HashArry[data]!!.key)
                  numberOfDataExits++
                  return "Added Successfully"
              }
            else{
                  //select index
                  val index = HashFunc(HshNod_.key)
                  val linearProbing = LinearProbing(index)

                  //add value to array
                  HashArry[linearProbing] = HshNod_
                  Save_Keys_In_List.add(HashArry[linearProbing]!!.key)

                  numberOfDataExits++
                  return "Added Successfully"
            }

        }

    }
     //remove data from array by key
      public fun remove(key:K):Boolean{
        if (Key_Is_Exist(key)){


            var index = HashFunc(key)
            while (key!=HashArry[index]?.key){
                index++
                if (index==sizearray+1) index=0

            }
            Save_Keys_In_List.remove( HashArry[index]?.key)
            HashArry[index] = null
            Null_Position.add(index)
            numberOfDataExits--
            return true
             }
        return false
    }
      //get value and return it by insert key
       public fun getValue(key:K): V? {
          if (Key_Is_Exist(key)){

              var index = HashFunc(key)
              while (HashArry[index]?.key !=key&&index<this.size-1){
                  index++
                  if (HashArry[index]?.key==key)return HashArry[index]?.value
                  if (index==this.sizearray) index = 0
              }
              return HashArry[index]?.value
          }
         return null
       }
      //return all key exits
       public fun getKeys(): HashSet<K> =Save_Keys_In_List
        //print all data exits
       public fun show_All(){for(item in HashArry.iterator()) println(item)}
        //return size
       public fun getSize():Int = this.HashArry.size
      //return current values
      public fun current_values():Int = this.numberOfDataExits

  //--------------------------private functions--------------------------------------//
    //print functions and cheek
    private fun IsFull():Boolean =numberOfDataExits==this.size

    //hashing and key generation
     private fun HashFunc(key:K):Int{

        val hash = hashcode(key)
        var index1 = hash%this.size
        index1 = if (index1 < 0) index1 * -1 else index1

       return index1


    }

    //cheek key is there / return true or false
     private fun Key_Is_Exist(key:K): Boolean {

        return Save_Keys_In_List.contains(key)
    }

    //save null position
    private fun IsDataHavespeace():Int?{

        if (Null_Position.size>0){
            val index2 = Null_Position[0]
            Null_Position.removeAt(0)

            return index2

        }
        return null
    }

    //if no-null position exist / this func swap item to right position
    private fun LinearProbing(i:Int):Int{
               var index2 = i
               while (index2<=sizearray+1&&HashArry[index2]!=null){
                   index2++
                   if (index2==sizearray+1) index2=0
               }

               return index2
    }

     //hash code func
     private fun hashcode(key:K):Int{

        return Objects.hashCode(key)
    }

}
fun main(){


    val linear=LinearProbing<String,Int>(15)
    linear.add("yousif",337664489)
    linear.add("ali",887441149)
    linear.add("naif",124544267)
    linear.add("mousa",234567654)
    linear.add("bader",343535366)
    linear.add("amjeed",44789900)
    linear.add("fahad",111133456)
    linear.add("ahmed",337664489)
    linear.add("nawf",887441149)
    linear.add("lafy",124544267)
    linear.add("muhmeed",234567654)
    linear.add("noor",343535366)
    linear.add("google",343535366)

    println("size all array"+linear.getSize())
    println(linear.getValue("fahad"))
    println(linear.remove("bader"))
    println()
    linear.add("mayram",343535366)
    linear.add("saud",343535366)
    linear.add("kaka",343535366)
    linear.remove("naif")
    linear.add("cold",343535366)

    linear.show_All()


    println("current_values "+linear.current_values())



}