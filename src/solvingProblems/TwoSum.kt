package solvingProblems

fun twoSum1(nums: IntArray, target: Int): IntArray {
         val array = IntArray(2){-1}
    for (i in nums.indices){
        var ind=i

        while (array[0]==-1&&ind<nums.size-1){
            if (nums[i]+nums[ind+1]==target){
                array[0]=i
                array[1]=ind+1
                break

            }
            ind++

        }
    }





    return array
}

fun twoSum2(nums: IntArray, target: Int): IntArray {
    val hash = HashMap<Int, Int>()
    hash.put(nums[0], 0)
    for(i in 1..(nums.size - 1)) {
        val temp = hash.get(target - nums[i])
        if(temp != null) {
            return intArrayOf(temp, i)
        } else {
            hash.put(nums[i], i)
        }
    }
    return intArrayOf()
}
fun twoSu3(nums: IntArray, target: Int): IntArray {
   val hash =HashMap<Int,Int>()
    hash[nums[0]] = 0

    for (i in 1 until nums.size) {
        val getVal = hash[target-nums[i]]
        if (getVal==null){
            hash[nums[i]] = i
        }
        else{
            return intArrayOf(getVal,i)

        }
    }

    return intArrayOf()
}


fun main(){

    val twoSum2 = twoSu3(intArrayOf(2, 3, 3,4), 7) //
}