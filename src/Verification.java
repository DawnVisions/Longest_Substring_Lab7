public class Verification {

    public static boolean verification(LCS lcsMethod)
    {
        boolean correct = true;

        String s1 = "abc";
        String s2 = "cabc";
        LCS_Object common = lcsMethod.LCS(s1,s2);
        if(common.substring.compareTo("abc") != 0)
            correct = false;
        System.out.println(common.substring);

        s1 = "baaaaaaaaaa";
        s2 = "aaaaaaaaaab";
        common = lcsMethod.LCS(s1,s2);
        if(common.substring.compareTo("aaaaaaaaaa") != 0)
            correct = false;
        System.out.println(common.substring);

        s1 = "aaaaaaaaaa";
        s2 = "cbacbacdefiaaaaaaaaaaa";
        common = lcsMethod.LCS(s1,s2);
        if(common.substring.compareTo("aaaaaaaaaa") != 0)
            correct = false;
        System.out.println(common.substring);

        s1 = "aabbccddaabbccdd";
        s2 = "eeffggeeffggeeffgg";
        common = lcsMethod.LCS(s1,s2);
        if(common.substring.compareTo("No substring found") != 0)
            correct = false;
        System.out.println(common.substring);

        s1 = "bacbadefgaacc";
        s2 = "cbacbacdefian";
        common = lcsMethod.LCS(s1,s2);
        if(common.substring.compareTo("bacba") != 0)
            correct = false;
        System.out.println(common.substring);

        s1 = "aabbccddaabbccdd";
        s2 = "eeffggeeffggeeffgg";
        common = lcsMethod.LCS(s1,s2);
        if(common.substring.compareTo("No substring found") != 0)
            correct = false;
        System.out.println(common.substring);

        s1 = "ABC123456qwerty";
        s2 = "456";
        common = lcsMethod.LCS(s1,s2);
        if(common.substring.compareTo("456") != 0)
            correct = false;
        System.out.println(common.substring);

        s1 = "qwertqwertyqwe";
        s2 = "abc890qwertypppqwe";
        common = lcsMethod.LCS(s1,s2);
        if(common.substring.compareTo("qwerty") != 0)
            correct = false;
        System.out.println(common.substring);

        s1 = "789qwemnbasdfghjkl;";
        s2 = "asdfghjklg";
        common = lcsMethod.LCS(s1,s2);
        if(common.substring.compareTo("asdfghjkl") != 0)
            correct = false;
        System.out.println(common.substring);

        return correct;
    }
}
