package Sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] ints = new int[]{1,6,3,4,5,6,8};
        BubbleSort bubbleSorting = new BubbleSort();
        bubbleSorting.bubbleSorting(ints);
        for (int a:ints
             ) {
            System.out.print(a+"   ");
        }
    }
    public void bubbleSorting(int[] arry){
        for (int i = arry.length-1; i >0; i--) {
            for (int j = 0; j < i; j++) {
                if (arry[j]>arry[j+1]){
                    int temp=arry[j];
                    arry[j]=arry[j+1];
                    arry[j+1]=temp;
                }
            }
        }
    }
}
