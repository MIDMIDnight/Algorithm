package Searche;

public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr=new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i]=i+1;
        }
        InsertValueSearch insertValueSearch = new InsertValueSearch();
        int i = insertValueSearch.insertValueSearch(arr, 0, 99, 2);
        System.out.println(i);
    }

    public int insertValueSearch(int[] arry,int low,int high,int findVal){
        if (low>high||arry[0]>findVal||arry[arry.length-1]<findVal){
            return -1;
        }
        //
        int mid=low+(findVal-arry[low])/(arry[high]-arry[low])*(arry[high]-arry[low]);


        int midVal=arry[mid];
        if (midVal<findVal){
            return insertValueSearch(arry,mid+1,high,findVal);
        }else if (midVal>findVal){
            return insertValueSearch(arry,low,mid-1,findVal);
        }else {
            return midVal;
        }
    }
}
