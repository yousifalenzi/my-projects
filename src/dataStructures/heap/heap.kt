package dataStructures.heap
import kotlin.random.Random

 class heapnode (var key1:Int){

     fun setkey(i:Int){this.key1=i}
     fun getKey():Int = key1

}
class heap (val size:Int){

      private val array: IntArray =IntArray(size)
      private val maxsize:Int= size
      private var currentsize :Int = 0




     fun getsize ():Int = currentsize
     fun isEmpty ():Boolean = currentsize==0
     fun isFull ():Boolean = currentsize==maxsize

     fun insert_Maxway(key:Int):Boolean{

          if (isFull())return false

          val newnode = dataStructures.heap.heapnode(key)//77
          array[currentsize] =newnode.getKey()//77
            trickleup(currentsize)//1
            currentsize++

          return true
     }

     private fun trickleup( idx: Int) {

          var id = idx//5
          var parentId=(id-1)/2
          val node =array[id]

          while (id>0&&array[parentId]<node){ //array[parentId]=66  <node=100
                    // array[idx] [1]=100
                    // array[parentId] [0]=85

               array[id] = array[parentId]//34 transfer to index 1
               id = parentId//2
               parentId=(id-1)/2

          }
          array[id]=node
     }

     fun Int.Rand()=Random.nextInt(this/2,this-1)



    fun removeNode_yousifway():Int{

          //(1) remove the root(maxHeap-way)
          //(2) take last node inserted and replace the root
          //(3) Make a comparison on the two child (right,left), which one is bigger than root and replace the root by bigger one
          //(4) Keep comparing until the number is in the correct place
          var i = 0
          val firstvaule = array[0]

           array[i] = array[currentsize-1]//55
           val tem =  array[i]//55

        array[currentsize-1] = tem.Rand()

            var rightchild = (2*i)+2
            var leftchild = (2*i)+1
             var lastindex = false

            while (true){

                if (lastindex==true)break

                else{

                    if (tem<array[leftchild]&&array[leftchild]>array[rightchild]){//left win

                        array[i] = array[leftchild] // 30
                        i = leftchild//3
                        array[i] = tem //24

                        rightchild = (2*i)+2//8
                        leftchild = (2*i)+1//7

                        if (rightchild>=currentsize) lastindex=true
                    }
                    else if (tem<array[rightchild]&&array[rightchild]>array[leftchild]){//left win

                        array[i] = array[rightchild] // 30
                        i = rightchild//3
                        array[i] = tem //24


                        rightchild = (2*i)+2//8
                        leftchild = (2*i)+1//7

                        if (rightchild>=currentsize) lastindex=true
                    }
                    else break
                } }

         return firstvaule

     }
    fun remove_yousifNew():Int{

        val firstData = array[0]
        --currentsize
        array[0] = array[currentsize]
        removeHeap(0)
        return firstData


    }
    private fun removeHeap(indx:Int){
          var index = indx // تخزين رقم الاندكس فيها
          var LargeChild:Int //متغير لوضع اكبر قيمه بين الابناء فيه
          val root = array[index] // تخزين اول عنصر في الشجره او المصفوفه
          val level_for_heap_tree = currentsize/2 // لمعرفة كم مرحله تحتوي الشجره


        while (index<level_for_heap_tree){

            var leftchild = (2*index)+1 //طريقه تحديد الطفل في الجهه اليسار للاب
            var rightchild =leftchild+1 //طريقه تحديد الطفل في الجهه اليمين للاب

            if (rightchild<currentsize&&array[leftchild]<array[rightchild]){

                LargeChild = rightchild

            }
            else{
                LargeChild=leftchild
            }

            if (root>=array[LargeChild])break

            array[index] = array[LargeChild]
            index=LargeChild
        }
        array[index]= root
    }
    fun removeNode_ahmedway():Int{

        val first = array[0]
        currentsize--//6
        array[0] = array[currentsize] // array[0] = 13

        TrickleDown(0)


        return first
    }

    private fun TrickleDown( idx: Int) {
           var Idx = idx //0
           var largechild:Int
           val root = array[Idx]//13
           val y_table = currentsize/2

           while (Idx<y_table){

               var leftchildIdx = (2*Idx)+1 // 1
               var rightchildIdx = leftchildIdx+1 //2

               if (rightchildIdx<currentsize&&array[leftchildIdx]<array[rightchildIdx]){

                   largechild = rightchildIdx // 2

               }
               else{
                   largechild = leftchildIdx // 1
               }
               if (root>=array[largechild])break // 13 >


               array[Idx] = array[largechild]
               Idx = largechild//2

           }


           array[Idx] =root
    }

    fun printall(){
             var o =0
          for (arr in array.indices){
               println("($arr) = ${array[arr]}")
          }
     }

    fun print_like_tree (){

        var Vblanks = 32
        var itemPerRow = 1
        var column = 0
        var j = 0

        val dots = "..............................."
        println(dots+dots)

        while (currentsize>0){


            if (column==0){

                for (k in 0 until Vblanks){
                    print(" ")
                }
            }

            print(array[j])
            j++
            if (j==currentsize)break

            column++
            //end of row

            if (column==itemPerRow){

                Vblanks=Vblanks/2
                itemPerRow=itemPerRow*2
                column=0
                println()
            }
            else{

                for (k in 0 until Vblanks*2){

                    print(" ")
                }
            }
        }
       println("\n${dots+dots}")
    }


}

fun main(){


}
