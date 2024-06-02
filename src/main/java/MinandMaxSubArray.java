package src.main.java;

/*
* Given an array A of both positive and negative integers.

Your task is to compute the sum of minimum and maximum elements of all sub-array of size B.

NOTE: Since the answer can be very large, you are required to return the sum modulo 109 + 7.
*
* */

import java.util.*;

public class MinandMaxSubArray
{
    public int solve(ArrayList<Integer> A, int B)
    {
        int n = A.size();
        long sum = 0;

        int mod = 1000000007;

        Deque<Integer> minn = new LinkedList<>();
        Deque<Integer> maxx = new LinkedList<>();

        for(int i=0;i<B;i++)
        {
            while(!minn.isEmpty() && A.get(minn.peekLast())>=A.get(i))
            {
                minn.removeLast();
            }

            while(!maxx.isEmpty() && A.get(maxx.peekLast())<=A.get(i))
            {
                maxx.removeLast();
            }

            minn.addLast(i);
            maxx.addLast(i);
        }

        sum = A.get(minn.getFirst()) + A.get(maxx.getFirst());

        for(int i=B;i<n;i++)
        {
            while(!minn.isEmpty() && A.get(minn.getLast())>=A.get(i))
            {
                minn.removeLast();
            }

            while(!maxx.isEmpty() && A.get(maxx.getLast())<=A.get(i))
            {
                maxx.removeLast();
            }
            minn.addLast(i);
            maxx.addLast(i);

            while (i - minn.getFirst() >= B)
            {
                minn.removeFirst();
            }
            while (i - maxx.getFirst() >= B)
            {
                maxx.removeFirst();
            }

            sum += A.get(maxx.getFirst()) + A.get(minn.getFirst());
            sum %= mod;
        }

        sum += mod;
        sum %= mod;
        return (int) sum;
    }
}
