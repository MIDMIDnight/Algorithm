package Sort;

public class mergeSort {
    //2 1 2 3 8 9 0 4
    //T(n)=2*T(n/2)+o(n)
    public void process(int[] arr,int l,int r){
        if (l==r){
            return;
        }
        int mid =l+((r-l)>>2);
        process(arr,l,mid);
        process(arr,mid+1,r);
        merge(arr,l,mid,r);
    }

    private void merge(int[] arr, int l, int mid, int r) {
        int[] help=new int[r-l+1];
        int i=0;
        int p1=l;
        int p2=mid+1;
        while (p1 <= mid && p2 <= r ){
            if (arr[p1]<=arr[p2]){
                help[i++]=arr[p1++];
            }else {
                help[i++]=arr[p2++];
            }
        }
        while (p1 <= mid){
            help[i++]=arr[p1++];
        }
        while (p2 <= r){
            help[i++]=arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[l+j]=help[j];
        }


    }
}
