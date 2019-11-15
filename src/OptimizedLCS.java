public class OptimizedLCS {

    public static String LCS(String s1, String s2)
    {
        String substring = "";
        int lcsLength = 0;

        for (int i = 0; i<s1.length(); i++)
        {
            for(int j = 0; j<s2.length(); j++)
            {
                for (int k = 0; k< Math.min(s1.length()-i, s2.length()-j); k++)
                {
                    if ( s1.charAt(i+k) != s2.charAt(j+k))
                    {
                        break;
                    }
                    if (k> lcsLength)
                    {
                        lcsLength = k;
                        substring = s1.substring(i,i+k+1);
                    }
                }
            }
        }

        return substring;
    }
}
