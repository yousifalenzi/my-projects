package dataStructures.hashtable


import java.util.*


private  class Hashingnode<K,V>(val key: K, var vaule: V, val hashcode:Int) {
    //phone contact
    var next: Hashingnode<K, V>? = null
}



class Maping<K,V>{

    // bucketArray is used to store array of chains
    private var bucketArray = ArrayList<Hashingnode<K, V>?>()

    // Current capacity of array list
    private var numBucket :Int = 10

    // Current size of array list
    private var size :Int = 0


    init {

        for (i in 0 until numBucket){
            bucketArray.add(null)
        }

    }

    fun getsize () = size
    fun isEmpty():Boolean=size == 0

    fun hashcode(key:K):Int{

        return Objects.hashCode(key)
    }



    private fun getBucketIndex(key:K):Int{
        val hash = hashcode(key)//2365799
        var index = hash%numBucket // 2365799%10 = 1
        // key.hashCode() coule be negative.
        index = if (index < 0) index * -1 else index
        return index

    }



    fun remove(key:K):V?{
        var bucketIndex = getBucketIndex(key) // 5
        val hashCode = hashcode(key) // long number

        var head = bucketArray.get(bucketIndex) // [0] = hashNode<K, V>
        // Search for key in its chain

        // Search for key in its chain
        var prev: Hashingnode<K, V>? = null
        while (head != null) {
            // If Key found
            if (head.key == key && hashCode == head.hashcode) break

            // Else keep moving in chain
            prev = head
            head = head.next
        }

        // If key was not there

        // If key was not there
        if (head == null) return null

        // Reduce size

        // Reduce size
        size--

        // Remove key

        // Remove key
        if (prev != null) prev.next = head.next else bucketArray.set(bucketIndex, head.next)

        return head.vaule
    }
    fun add(key: K, value: V) {
        // Find head of chain for given key
        val bucketIndex = getBucketIndex(key)//5
        val hashCode = hashcode(key)
        var head = bucketArray[bucketIndex]//[5] = (null)
        val data=head?.vaule
        val newNodee = Hashingnode(key, value, hashCode)

        // Check if key is already present
        // Check if key is already present

        // Check if key is already present
        while (head != null) {
            if (head.next == null) {
                head.next = newNodee
                return
            }
            head = head.next
        }

        // Insert key in chain
        size++//1

        newNodee.next = head
        bucketArray[bucketIndex] = newNodee






        // If load factor goes beyond threshold, then
        // double hash table size
        if (1.0 * size / numBucket >= 0.7) {
            val temp = bucketArray
            bucketArray = ArrayList()
            numBucket = 2 * numBucket
            size = 0
            for (i in 0 until numBucket) bucketArray.add(null)
            for (headNode in temp) {
                var heading = headNode
                while (heading != null) {
                    add(heading.key, heading.vaule)
                    heading = heading.next
                }
            }
        }
    }

    // Returns value for a key
    fun get(key: K){
        // Find head of chain for given key
        val bucketIndex = getBucketIndex(key)
        val hashCode = hashcode(key)
        var head: Hashingnode<K, V>? = bucketArray[bucketIndex]

        // Search key in chain

        // Search key in chain
        while (head != null) {
            print("${head.hashcode}"+"( " + head.vaule + ") ")
            head = head.next
        }

        // If key not found

    }


}

fun main (args: Array<String>){

    val map = Maping<String,String>()

    map.add("yousif","maaden".trim())
    map.add("omar","almuhalub")
    map.add("aboody","hospatil")
    map.add("muhmmed","pc boy")
    map.add("maryam","hosptail")


   map.get("aboody")


}