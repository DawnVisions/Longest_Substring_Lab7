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

        s1 = "poi234lkj789789qwemnfindmeinthestring;";
        s2 = "789yui23poijkfindmeinthestring23";
        common = lcsMethod.LCS(s1,s2);
        if(common.substring.compareTo("findmeinthestring") != 0)
            correct = false;
        System.out.println(common.substring);

        /*Also for much larger strings:
        create test data of 2 random strings randomly select a substring of random size from the first string…
        …and insert it to a random location in the second string
        (this insures that there is a decent sized common substring to search for) */

        String substring = Testing.randomStringOfSize(40);
        StringBuilder sb1 = new StringBuilder(Testing.randomStringOfSize(100));
        sb1.insert(49, substring);
        StringBuilder sb2 = new StringBuilder(Testing.randomStringOfSize(150));
        sb2.insert(2, substring);
        common = lcsMethod.LCS(sb1.toString(),sb2.toString());
        if(common.substring.compareTo(substring) != 0)
            correct = false;
        System.out.println(common.substring);

        substring = Testing.randomStringOfSize(40);
        sb1 = new StringBuilder(Testing.randomStringOfSize(100));
        sb1.insert(20, substring);
        sb2 = new StringBuilder(Testing.randomStringOfSize(150));
        sb2.insert(129, substring);
        common = lcsMethod.LCS(sb1.toString(),sb2.toString());
        if(common.substring.compareTo(substring) != 0)
            correct = false;
        System.out.println(common.substring);
        return correct;
    }
}
