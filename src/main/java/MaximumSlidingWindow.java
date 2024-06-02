package src.main.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.*;

/*
* Imagine you're an ice cream truck driver in a beachside town. The beach is divided into several sections, and each section has varying numbers of beachgoers wanting ice cream given by the array of integers A.

For simplicity, let's say the beach is divided into 8 sections. One day, you note down the number of potential customers in each section: [5, 12, 3, 4, 8, 10, 2, 7]. This means there are 5 people in the first section, 12 in the second, and so on.

You can only stop your truck in B consecutive sections at a time because of parking restrictions. To maximize sales, you want to park where the most customers are clustered together.

For all B consecutive sections, identify the busiest stretch to park your ice cream truck and serve the most customers. Return an array C, where C[i] is the busiest section in each of the B consecutive sections. Refer to the given example for clarity.

NOTE: If B > length of the array, return 1 element with the max of the array.
*
* */

public class MaximumSlidingWindow
{
    public int[] slidingMaximum(final int[] A, int B)
    {
        int n = A.length;

        if(B >= n)
        {
            int val = findMax(A);

            return new int[]{val};
        }

        Deque<Integer> que = new LinkedList<>();

        for(int i=0;i<B;i++)   // Finding First B Vallues Max Value and pushing into the queue
        {
            int val = A[i];

            while(!que.isEmpty() && que.peekLast()<= val)
            {
                que.removeLast();
            }

            que.add(A[i]);

        }

        ArrayList<Integer> arr = new ArrayList<>();

        arr.add(que.peek());

        for(int i=B;i<n;i++)  // From B index to end index
        {
            int val = A[i];

            if(que.peek() == A[i-B]) // If First is same as Peek ...Removing it as sliding window moves
            {
                que.remove();
            }

            while(!que.isEmpty() && que.peekLast()< val)
            {
                que.removeLast();
            }

            que.add(val);
            arr.add(que.peek());


        }

        int[] ans = new int[arr.size()];

        for(int i=0;i<arr.size();i++)
        {
            ans[i] = arr.get(i);
        }

        return ans;
    }

    public int findMax(int[] arr)
    {
        int n = arr.length;

        int maxval = Integer.MIN_VALUE;

        for(int i=0;i<n;i++)
        {
            maxval  =  Math.max(maxval,arr[i]);
        }

        return maxval;
    }
}
