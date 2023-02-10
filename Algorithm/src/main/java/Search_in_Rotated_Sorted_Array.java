public class Search_in_Rotated_Sorted_Array {
    public int search(int[] nums, int target) {
    /**
    1.题解一 ： 先用二分查找法找到两个升序数组（以数组最小值为分界点）再通过二分法找到target     */


    return 1;
    }
    //找到最小值的下标
    public int searchMinIndex(int[] nums){
        int left=0;
        int right=nums.length-1;
        int mid;
        while (left>right){
            mid=left+(right-left)/2;//取地板值更加靠近mid值
            if (nums[mid]>nums[right]){//中值大于右值则最小值在右边界
                left=mid+1;//为什么加1；因为中值大于右边值的时候最小值时肯定不会为最小值
            }
            if (nums[mid]<nums[right]){
                right=mid;//为什么不减1，因为中值小于右边值的时候最小值在左边其中还可能包括中值自己
            }
        }
        return left;

    }
}
