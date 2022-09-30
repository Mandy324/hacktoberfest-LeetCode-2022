import java.util.*;

/*

2. Add Two Numbers
Medium

21782

4259

Add to List

Share
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.



Example 1:

(2) -> (4) -> (3)
(5) -> (6) -> (4)
____________________
(7) -> (0) -> (8)
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]



 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
        ListNode list=null,newnode,temp=null;
        int sum,add=0;
        while(l1!=null||l2!=null)
        {
            if(l1!=null&&l2!=null)
            {
                sum=l1.val+l2.val+add;
                add=sum/10;
                newnode=new ListNode(sum%10);
                
            }
            else if(l1!=null&&l2==null)
            {
                sum=l1.val+add;
                add=sum/10;
                newnode=new ListNode(sum%10);
            }
            else
            {
                sum=l2.val+add;
                add=sum/10;
                newnode=new ListNode(sum%10);
            }
            if(list==null)
            {
                    list=newnode;
                    temp=newnode;
            }
            else
            {
                    temp.next=newnode;
                    temp=temp.next;
            }
            if(l1!=null)
            {
                l1=l1.next;
            }
            if(l2!=null)
            {
                l2=l2.next;
            }
        }
        if(add==1)
        {
            temp.next=new ListNode(1);
        }
        return list;
    }
}