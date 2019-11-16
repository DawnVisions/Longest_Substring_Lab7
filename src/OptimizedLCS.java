import java.util.Arrays;

public class OptimizedLCS {

    public static LCS_Object LCS(String s1, String s2)
    {
        //Initiate new LCS_Object
        //lcsLength = 0
        LCS_Object lcs = new LCS_Object();

        //Lengths of s1 and s2
        int length1 = s1.length();
        int length2 = s2.length();

        //2D Array, initialized to 0
        int[][] arr = new int[2][length1];

        //To save space, we will alternate between two rows
        //We need to keep track if we are in row 0 or row 1
        int currentRow = 0;

        for(int j = 0; j<length2; j++)
        {
            for(int i = 0; i<length1; i++)
            {
                arr[currentRow][i] = 0;
                //If there is a match
                if(s1.charAt(i) == s2.charAt(j)) {
                    //Put the length of the longest diagonal in the cell
                    //If we are not on a left edge, check the cell on the diagonal
                    if (i != 0) {
                        if (currentRow == 0) {
                            //Add 1 to the cell down and to the left
                            arr[currentRow][i] = arr[currentRow+1][i-1] + 1;}
                        else {
                            //Add 1 to the cell up and to the left
                            arr[currentRow][i] = arr[currentRow-1][i-1] + 1;
                        }
                    } else {
                        //On the left edge
                        // Put 1 in the current cell
                        arr[currentRow][i] = 1;
                    }

                    //If the diagonal length is greater than the current lcsLength
                    //Update the lcs
                    if(arr[currentRow][i] > lcs.lcsLength)
                    {
                        lcs.lcsLength = arr[currentRow][i];
                        lcs.startIndex_S2 = j-lcs.lcsLength+1;
                        lcs.startIndex_S1 = i-lcs.lcsLength+1;
                    }
                }
            }
            currentRow = (currentRow+1)%2;
        }

        lcs.createSubstring(s1);
        return lcs;
    }
}
