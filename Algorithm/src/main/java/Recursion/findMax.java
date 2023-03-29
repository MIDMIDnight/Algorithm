package Recursion;

public class findMax {
    public static void main(String[] args) {
        int arr[]=new int[]{1,2,3,4,5,6,7,8,9};
        findMax findMax = new findMax();
        int max = findMax.getMax(arr);
        System.out.println(max);
    }

    public int getMax(int[] arry ){
        return process(arry,0,arry.length-1);

    }

    private int process(int[] arry, int L, int R) {
        if (L==R){
            return arry[L];
        }
        int mid= L+(R-L)/2;
        int leftMax=process(arry,L,mid);
        int rightMax=process(arry,mid+1,R);

        return Math.max(leftMax,rightMax);
    }


}
