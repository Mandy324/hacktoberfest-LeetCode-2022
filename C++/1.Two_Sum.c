#include<stdio.h>

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

// Approach 1. Two Pointer Method
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        // using two pointer method to check if two numbers
        // exist which sum up to a specific target.
        int n = nums.size();
        vector<int> ans;
        vector<pair<int,int>> p;
        for(int i = 0; i < n; i++){
            p.push_back(make_pair(nums[i], i));
        }
        // we sort the pair of int, index.
        sort(p.begin(), p.end());
        // sorting will happen in ascending order based on the value which is p[i].first
        //  now we declare two ptrs.
        // pointer 1 at the start and pointer 2 and the end,
        int low = 0, high = n-1;
        while(low < high){
            int curr = p[low].first + p[high].first;
            // case 1 : when the sum is equal to the target.
            if(curr == target){
                ans.push_back(p[low].second);
                ans.push_back(p[high].second);
                return ans;
            }
            // case 2 : when the sum is less than the target. 
            // we need to increase the current sum hence we increment low.
            else if(curr < target){
                low++;
            }
            // case 3 : the current sum is more than the target sum.
            // we need to reduce the current sum, hence we decrement high.
            else if(curr > target){
                high--;
            }
        }
        
        return ans;
    
    }
};