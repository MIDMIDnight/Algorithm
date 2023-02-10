package Sort;

public class SelectSort {
    public static void main(String[] args) {
    }
    public void selectSort(int[] a){
        for (int i = 0; i < a.length-1; i++) {
            int minIndex= i;
            int min=a[i];
            for (int j = i+1; j <a.length ; j++) {
                if (min >a[j] ){
                    min = a[j];
                    minIndex = i;
                }
            }
            if (minIndex != i){
                a[minIndex] = a[i];
                a[i]=min;
            }
        }
    }
}
