/*
* Given an integer A, you have to find the Ath Perfect Number.

A Perfect Number has the following properties:

It comprises only 1 and 2.
The number of digits in a Perfect number is even.
It is a palindrome number.
For example, 11, 22, 112211 are Perfect numbers, where 123, 121, 782, 1 are not.
* */

public class PerfectNumbers
{
    public String solve(int A)
    {
        Queue < String > q = new LinkedList < String > ();
        if (A == 1)
            return "11";
        else if (A == 2)
            return "22";
        q.add("1");
        q.add("2");
        int cur = 2;
        String ans = new String();
        while (q.size() < A) {
            StringBuilder sb = new StringBuilder(q.peek());
            q.remove();
            sb.append("1");
            q.add(sb.toString());
            cur++;
            if (cur == A)
                ans = sb.toString();
            sb.deleteCharAt(sb.length() - 1);
            sb.append("2");
            cur++;
            if (cur == A)
                ans = sb.toString();
            q.add(sb.toString());
        }
        // ans has the first half of our final answer
        StringBuilder sb = new StringBuilder(ans);
        return ans + sb.reverse().toString();
    }
}