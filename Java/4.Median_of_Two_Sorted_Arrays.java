import java.util.;


/*
4. Median of Two Sorted Arrays
Hard

19799

2262

Add to List

Share
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

 

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 

Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106


 */

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size = nums1.length + nums2.length;
        if(size%2 == 1) {
            return (double)getMedian(nums1, nums2, size/2);
        } else {
            int x = getMedian(nums1, nums2, size/2);
            int y = getMedian(nums1, nums2, size/2-1);
            return ((double)(x+y)/2);
        }
    }
    
    int getMedian(int[] nums1, int[] nums2, int k) {
        int i=0, j=0;
        int median=0;
        while(i<nums1.length && j<nums2.length) {
            if(nums1[i] < nums2[j]) {
                median = nums1[i];
                i+=1;
            } else {
                median = nums2[j];
                j+=1;
            }
            if(k==0)
                return median;
            k-=1;
        }
        
        while(i<nums1.length) {
            median = nums1[i];
            if(k==0)
                return median;
            k-=1;
            i+=1;
        }
        
        while(j<nums2.length) {
            median = nums2[j];
            if(k==0)
                return median;
            k-=1;
            j+=1;
        }
        return 0;
    }
}