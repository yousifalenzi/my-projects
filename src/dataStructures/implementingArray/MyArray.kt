package dataStructures.implementingArray

class MyArray (var size:Int){

    private var index = -1 //O(1)SPACE
    private var data:Array<Any?>?=null
    private val theSize = this.size-1
    private var indexwasRemove = -1 //O(1)SPACE


    init {
        this.data= Array(this.size,{null})
        this.size = this.data!!.size // o(1)
    }

      //get data
      fun get (i:Int):Any {

            if (i>this.index||i<0) return "Not found!" // O(1)
            else{
                return data?.get(i)!! // O(1)

            }

      }

      //push item
      fun push(item:Any) :Boolean{// O(1)
          if (this.index>=theSize)return false
          index++

          this.data?.set(this.index,item)

              return true
      }
      fun isNull(): Any? {
          val filterIndexed = this.data?.getOrNull(0)
          return filterIndexed
      }
     //o(N)
    fun printAllData()=this.data?.forEach {println(it)}

    //pop item
    fun pop(): Any? {// O(1)
        val item = this.data?.get(index)
        this.data?.set(this.index,null)
        this.index--
        return item

    }

//    //delete
//    fun remove(index:Int): Any? {
//        indexwasRemove = index
//        val item = this.data?.get(index)
//
//        //set
//        this.data?.set(index,null)
//        this.index--
//
//
//        //return
//        return item
//
//
//    }

}