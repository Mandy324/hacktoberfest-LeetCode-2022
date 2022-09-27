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

// Approach 1. HashTable method
typedef struct {
	int num;
	int idx;
	// Makes structure hashable
	UT_hash_handle hh;
} num_t;

int* twoSum(int* nums, int numsSize, int target, int* returnSize){
	int* res = calloc((*returnSize = 2), sizeof(int));
	num_t *numsHash = NULL, *num = NULL, *tmp = NULL;

	for(int i = 0; i < numsSize; ++i){
		int toFind = target - nums[i];
		HASH_FIND_INT(numsHash, &toFind, num);

		if (num != NULL){
			res[0] = num->idx;
			res[1] = i;

			break;
		} else {
			num = malloc(sizeof(num_t));
			num->num = nums[i]; num->idx = i;

			HASH_ADD_INT(numsHash, num, num);
		}
	}

	HASH_ITER(hh, numsHash, num, tmp) {
		HASH_DEL(numsHash, num); free(num); 
	}

	return res;
}