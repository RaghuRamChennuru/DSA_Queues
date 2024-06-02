package src.main.java;

/*
*
* Imagine you're a teacher. You ask students to call out a letter one by one. After each letter, you jot down the very first letter that's only been called out once. If all letters have been repeated, you write "#".

Here's a scenario:

A student says "a". It's the first letter. You write "a".
Next, a student says "b", "a" is still unique, so you add "a". Now it's "aa".
A student says "a" again. Now, "b" is the unique one. You add "b", making it "aab".
A student says "b". All letters so far are repeated. You add "#". It becomes "aab#".
A student says "c". "c" is unique. You add "c". The final is "aab#c".
Your task? Given the sequence the students call out A, determine the string on the board.
* */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class UniqueLetter
{
    public String solve(String A)
    {
        int n = A.length();

        if(n ==  1)
        {
            return A;
        }

        StringBuilder sb = new StringBuilder();
        Queue<Character> que =  new LinkedList<>();
        HashMap<Character,Integer> hm=  new HashMap<>();


        for(int i=0;i<n;i++)
        {
            char c = A.charAt(i);

            if(hm.containsKey(c))
            {
                hm.put(c,2);
            }
            else
            {
                hm.put(c,1);
                que.add(c);
            }

            while(!que.isEmpty() && hm.get(que.peek())>1 )
            {
                que.remove();
            }

            if (que.size() > 0)
                sb.append(que.peek());
            else
                sb.append('#');
        }

        return sb.toString();
    }
}
