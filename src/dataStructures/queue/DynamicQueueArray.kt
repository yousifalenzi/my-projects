package dataStructures.queue

class DynamicQueueArray {
    private val capacity = 6
    private var queueArr: IntArray = IntArray(this.capacity)
    private var front = 0
    private var rear = -1
    private var currentSize = 0


    fun enqueue(item: Int) {

        if (isQueueFull()) {
            println("Queue is full, increase capacity...")
            increaseCapacity()
        }
        rear++//6
        if (rear >= queueArr.size && currentSize !== queueArr.size) {
            rear = 0
        }
        queueArr[rear] = item
        currentSize++
    }

    fun dequeue() {
        if (isQueueEmpty()) {
            // you can raise an exception if you want
            println("Underflow ! Unable to remove element from Queue")
        } else {
            front++
            if (front > queueArr.size - 1) {
                System.out.println("removed: " + queueArr[front - 1])
                front = 0
            } else {
                System.out.println("removed: " + queueArr[front - 1])
            }
            currentSize--
        }
    }
    fun peek():Int? {
        if (isQueueEmpty()) {
            // you can raise an exception if you want
            println("Underflow ! Unable to remove element from Queue")
            return null
        } else {
            return queueArr[front]
        }
    }

    fun size():Int {
        return currentSize
    }

    private fun isQueueFull(): Boolean {
        var status = false
        if (currentSize === queueArr.size) {
            status = true
        }
        return status
    }

    fun isQueueEmpty(): Boolean {
        var status = false
        if (currentSize === 0) {
            status = true
        }
        return status
    }

    private fun increaseCapacity() {

        //create new array with double size as the current one.
        val newCapacity = this.queueArr.size * 2
        val newArr = IntArray(newCapacity)


        //copy elements to new array, copy from rear to front
        var tmpFront = front
        var index = -1


        while (true) {
            newArr[++index] = this.queueArr[tmpFront]
            tmpFront++

            if (tmpFront == this.queueArr.size) {
                tmpFront = 0
            }


            if (currentSize === index + 1) {
                break
            }
        }
        //make new array as dataStructures.queue
        this.queueArr = newArr
        System.out.println("New array capacity: " + this.queueArr.size)
        //reset front & rear values
        this.front = 0
        this.rear = index
    }

    fun printall(){
        for (item in this.queueArr.indices){
            println("($item / ${queueArr[item]})")

        }
    }
}