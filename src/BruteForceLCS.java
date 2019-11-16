public class BruteForceLCS {

    public static LCS_Object LCS(String s1, String s2)
    {
        //Initiate new LCS_Object
        //lcsLength = 0
        LCS_Object lcs = new LCS_Object();

        //Lengths of s1 and s2
        int length1 = s1.length();
        int length2 = s2.length();

        for (int i = 0; i<length1; i++)
        {
            for(int j = 0; j<length2; j++)
            {
                for (int k = 0; k< Math.min(length1-i, length2-j); k++)
                {
                    //If characters do not match, break
                    if ( s1.charAt(i+k) != s2.charAt(j+k))
                    {
                        break;
                    }
                    //If the length of the matches is greater than the current lcs
                    //Save the lcsLength and starting index
                    if (k+1> lcs.lcsLength)
                    {
                        lcs.lcsLength = k+1;
                        lcs.startIndex_S1 = i;
                        lcs.startIndex_S2 = j;
                    }
                }
            }
        }
        lcs.createSubstring(s1);
        return lcs;
    }
}
