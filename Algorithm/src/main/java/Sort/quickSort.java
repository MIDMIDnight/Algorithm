package Sort;

import util.Arry;

import java.util.Arrays;

public class quickSort {

    public static void main(String[] args) {
        int[] arryInt = Arry.getArryInt(15);
        System.out.println(Arrays.toString(arryInt));
        quickSort quickSort = new quickSort();
        quickSort.quickSort(arryInt);
        System.out.println(Arrays.toString(arryInt));
    }


    public void quickSort(int[] arr){
        if (arr==null&&arr.length<2){
            return;
        }
        quickSort(arr,0,arr.length-1);
    }

    public void quickSort(int[] a,int l,int r){

        if (r>l){
            int flagl=l;
            int flagr=r;

            int temp=a[l];
            while (r > l){
                while (l < r && temp < a[r] ){
                    r--;
                }
                if (r > l){
                    a[l++] = a[r];
                }
                while (l < r && temp >= a[l]){
                    l++;
                }
                if (r > l){
                    a[r--]= a[l];
                }
                a[l] = temp;
            }
            quickSort(a,flagl,l);
            quickSort(a,l+1,flagr);

        }

    }



}
