package src.main.java;

import java.util.HashMap;
import java.util.Stack;

/*
* You are given a matrix A of size N x 2 which represents different operations.
Assume initially you have a stack-like data structure you have to perform operations on it.

Operations are of two types:

1 x: push an integer x onto the stack and return -1.

2 0: remove and return the most frequent element in the stack. This basically means the element which has the highest count among all the elements currently in the stack.

If there is a tie for the most frequent element, the element closest to the top of the stack is removed and returned.

A[i][0] describes the type of operation to be performed. A[i][1] describe the element x or 0 corresponding to the operation performed.


* */
public class MaximumFrequencyStack
{
    public int[] solve(int[][] A)
    {
        int n = A.length;
        int m = A[0].length;

        HashMap<Integer,Integer> freq = new HashMap<>(); // Frequency Map of each Value
        HashMap<Integer, Stack<Integer>> freqMap = new HashMap<>(); // Map for each freq

        int[] ans = new int[n];
        int maxFreq = 0;

        for(int i=0;i<n;i++)
        {
            int op = A[i][0];
            int val = A[i][1];

            if(op == 1) // Push Operation
            {
                int count = 0;

                if(freq.containsKey(val))
                {
                    count = freq.get(val);
                    count = count+1;
                    freq.put(val,count);  // Updating Freq Map of value as Key

                }
                else
                {
                    count = 1;
                    freq.put(val,1);
                }

                maxFreq = Math.max(maxFreq,count); // Taking the max freq

                if(freqMap.containsKey(count))  // If freqMap of freq as Key exists , we push the value
                {
                    freqMap.get(count).push(val);
                }
                else // insert map with new freq as key
                {
                    freqMap.put(count,new Stack<Integer>());
                    freqMap.get(count).push(val);
                }

                ans[i] = -1;
            }
            else // Pop Operation
            {
                // Take the maxFreq variable value as it stores max Frequency among all elemets
                if(freqMap.containsKey(maxFreq))
                {
                    int value = freqMap.get(maxFreq).pop();  // Pop the latest element from the top frequency stack
                    ans[i] = value; // Update in result array

                    int count = freq.get(value);
                    freq.put(value,count-1); // Decrement the frequency of popped element

                    if (freqMap.get(maxFreq).isEmpty()) // If the maxFreq stck is empty ..then make maxFreq decrement by 1
                        maxFreq--;
                }
            }
        }

        return ans;
    }
}
