package com.github.idouzi.util;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
public class UuidUtils {
    public static List<String> text0 = Arrays.asList("0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f");
    public static List<String> text1 = Arrays.asList("0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f");
    public static Random random = new Random();
    public static String get64uuid(){
        StringBuffer stringBuffer = new StringBuffer();
        for (int i=0;i<64;i++){
            int index = random.nextInt(16);
            stringBuffer.append(text0.get(index));
        }
        return stringBuffer.toString();
    }

    public static String getuuid(int size){
        StringBuffer stringBuffer = new StringBuffer();
        for (int i=0;i<size;i++){
            int index = random.nextInt(16);
            stringBuffer.append(text0.get(index));
        }
        return stringBuffer.toString();
    }
    public static String genRandomNum(){
        int  maxNum = 36;
        int i;
        int count = 0;
        char[] str = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
                'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
                'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        StringBuffer pwd = new StringBuffer("");
        Random r = new Random();
        while(count < 22){
            i = Math.abs(r.nextInt(maxNum));
            if (i >= 0 && i < str.length) {
                pwd.append(str[i]);
                count ++;
            }
        }
        return pwd.toString();
    }

    public static String getItemName( int length ){
        String base = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for ( int i = 0; i < length; i++ )
        {
            int number = random.nextInt( base.length() );
            sb.append( base.charAt( number ) );
        }
        return sb.toString();
    }


    public static void main(String[] args){
        System.out.println(getItemName(33));
    }
}
