package com.exam.test.sample;

import java.util.*;

public class TestCls {
/*
Long PK
int seq
char(5)
vchar(256?)

 */

//    private static final String strBase64 = "Gkbe_DizjyNwJPE4LrdUmhOpx235VgI-c0u9YMn6SqlftKsARvZCT7QB8H1aWoFX";
    private static final String BASE64_VERSION_220630 = "Gkbe_DizjyNwJPE4LrdUmhOpx235VgI-c0u9YMn6SqlftKsARvZCT7QB8H1aWoFX";

    public static void main(String[] args) {

        // getRandomBase64();
        // Gkbe_DizjyNwJPE4LrdUmhOpx235VgI-c0u9YMn6SqlftKsARvZCT7QB8H1aWoFX
//        String strBase64 = "Gkbe_DizjyNwJPE4LrdUmhOpx235VgI-c0u9YMn6SqlftKsARvZCT7QB8H1aWoFX";

        /*
         5 : 1.c      1073741824
         int         32bits    -2^31 ~ 2^31-1 (-2147483648 ~ 2147483647) 10 length
         */


        // 1073741824
//        String strCnt = Integer.toString((int)Math.pow(64, 5));

        int max = (int)Math.pow(64, 5);
//        System.out.println(max); // 16777216

        int namegi = 1073741824;
        int cnt = 0;
        while (64 < namegi) {
            namegi = namegi/64;
            cnt++;
//            System.out.println("cnt[{}][{}]" + cnt + "][" + namegi);
        }
//        System.out.println("cnt2[{}][{}]" + cnt + "][" + namegi);
//        System.out.println(max%64);


//        System.out.println(Math.pow(64, 2));


        for (int i = 0; i < 1073741824; i+=100000) {
            System.out.println(cvtIntToBase64(i));
        }



    }

    private static List<Integer> fromBase10(int n, int b) throws Exception {

        if(b < 2)
            throw new Exception("Base >= 2");

        if(n <= 0)
            throw new Exception("Number > 0");

        List<Integer> listInt = new ArrayList();

        while (n > 0) {
            int m = n % b;
            n = n / b;
            listInt.add(0, m);
        }

        return listInt;
    }

    private static List<Character> encode(List<Integer> listInt, String strBase64) {

        List<Character> listChar = new ArrayList<>();

        for (int baseIdx:listInt) {
            listChar.add(strBase64.charAt(baseIdx));
        }

        return listChar;
    }

    private static String cvtIntToBase64(int intSeq) {

        String strBase64 = null;
        try {
            List<Integer> listInt = fromBase10(intSeq, BASE64_VERSION_220630.length());
            System.out.println(listInt.toString());
            List<Character> listChar = encode(listInt, BASE64_VERSION_220630);
            System.out.println(listChar.toString());
            strBase64 = join(listChar);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strBase64;
    }

    private static String join(List<Character> listChar) {
        StringBuilder builder = new StringBuilder();
        for(char c:listChar) {
            builder.append(c);
        }
        return builder.toString();
    }

    private static String cvtLongToBase64(long longSeq) {

        return null;
    }

    private static String getRandomBase64() {

        // 0123456789
        for (int i = 48; i < 58; i++) {
            System.out.print((char)(i));
        }

        // ABCDEFGHIJKLMNOPQRSTUVWXYZ
        for (int i = 65; i < 91; i++) {
            System.out.print((char)(i));
        }

        // abcdefghijklmnopqrstuvwxyz
        for (int i = 97; i < 123; i++) {
            System.out.print((char)(i));
        }

        // -_
        System.out.println("-_");

        // 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz-_

        String strBase64 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz-_";

        List<Character> list = new ArrayList<>();
        for (int i = 0; i < strBase64.length(); i++) {
            list.add(strBase64.charAt(i));
        }

        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        for (int i = list.size()-1; i >= 0 ; i--) {
            int intRandom = random.nextInt(list.size());
            System.out.print(list.get(intRandom));
            builder.append(list.get(intRandom));
            list.remove(intRandom);
        }
        return builder.toString();
    }

}