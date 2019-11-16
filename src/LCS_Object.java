public class LCS_Object {
    //Attributes
    String substring;
    Integer lcsLength;
    Integer startIndex_S1;
    Integer startIndex_S2;

    //Constructor
    public LCS_Object() {
        this.lcsLength = 0;
        startIndex_S1 = 0;
        startIndex_S2 = 0;
    }

    public void createSubstring(String s1)
    {
        if (lcsLength == 0)
            substring = "No substring found";
        else
            substring = s1.substring(startIndex_S1, startIndex_S1+ lcsLength);
    }
}
