package util;

import java.util.Arrays;

public class Arry {
    public static int[] getArryInt(int length){
        int[] a=new int[length];
        while (length > 1){
            int num = (int)(1000* Math.random());
            a[--length] =num;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getArryInt(10)));
    }

}
