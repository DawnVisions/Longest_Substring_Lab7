public class Verification {

    public static boolean verification()
    {
        boolean correct = true;

        String s1 = "bacbadefgaacc";
        String s2 = "cbacbacdefian";
        if(OptimizedLCS.LCS(s1,s2).compareTo("cdef") != 0)
            correct = false;
        System.out.println(OptimizedLCS.LCS(s1,s2));

        return correct;
    }
}
