/*
1. Two Sum
Easy

38190

1221

Add to List

Share
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 

Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.


*/

// Approach 1
class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        var first: Int = 0
        var second: Int = 0
        
        val ht = HashMap<Int, Int>()
        
        for(i in 0 until nums.size) {
            val diff: Int = target - nums[i]
            if(ht.containsKey(diff)) {
                first = i
                second = ht[diff]!!
                break
            } else {
                val currValue = nums[i]
                ht.put(currValue, i)
            }
        }
        return intArrayOf(first, second)
    }
}

//Approach 2. 
fun twoSum(nums: IntArray, target: Int): IntArray {
    tailrec fun go(checked: Map<Int, Int> = emptyMap(), index: Int = 0): IntArray {
        val other = target - nums[index]
        if (checked.containsKey(other)) return intArrayOf(checked.getValue(other), index)
        else return go(checked + (nums[index] to index), index + 1)
    }

    return go()
}