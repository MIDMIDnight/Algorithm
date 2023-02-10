package Searche;

import java.util.ArrayList;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arry=new int[]{1,1,1,1,1,1,1,5,6,7,8,9,15,16,17,28,29};
        BinarySearch binarySearch = new BinarySearch();
        int i = binarySearch.binarySearch(arry, 0, arry.length - 1, 28);
        System.out.println(i);
        System.out.println();
        ArrayList arrayList = binarySearch.binarySearchOptimize(arry, 0, arry.length - 1, 1);
        System.out.println(arrayList);
    }

    public int binarySearch(int[] arry,int low ,int high,int findVal){
        int mid=(low+high)/2;
        int midVal=arry[mid];
        if (low>high){
            return -1;
        }
        if (findVal>midVal){
            return binarySearch(arry,mid+1,high,findVal);
        }else if (findVal<midVal){
            return binarySearch(arry,low,mid-1,findVal);
        }else {
            return midVal;
        }
    }
    public ArrayList binarySearchOptimize(int[] arry, int low , int high, int findVal){
        int mid=(low+high)/2;
        int midVal=arry[mid];
        if (low>high){
            return null;
        }
        if (findVal>midVal){
            return binarySearchOptimize(arry,mid+1,high,findVal);
        }else if (findVal<midVal){
            return binarySearchOptimize(arry,low,mid-1,findVal);
        }else {
            ArrayList<Integer> integers = new ArrayList<>();
            int temp=mid-1;
            while (true){
                if (temp<0||arry[temp]!=findVal){
                    break;
                }
                integers.add(temp);
                temp--;
            }
            integers.add(mid);
            temp=mid+1;
            while (true){
                if (temp>arry.length-1||arry[temp]!=findVal){
                    break;
                }
                integers.add(temp);
                temp++;
            }

            return integers;
        }
    }

}
