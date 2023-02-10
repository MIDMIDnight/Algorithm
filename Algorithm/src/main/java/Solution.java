import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
       int[] a = new int[]{4, 5, 6, 7, 0, 1, 2};
        int search = solution.search(a, 0);
        System.out.println(search);
    }
    public int search(int[] nums, int target) {
/**
 解题思路：
 首先根据时间复杂度可得使用二分法
 而直接使用二分法没有办法确定target的范围，但是这个数组是一个旋转数组可以分成两段
 两端都是单调递增，这个时候就可以根据left与mid还有target来确定target所在的区间，
 然后缩小边界，
 1234 5 6789

 7891 2 3456
 mid<target<left   左边  8

 5678 9 1234
 left<mid<target   左边   6

 3456 7 8912
 left<mid<target   右边   8
 target<left<mid    右边   2



 left<mid<target   左边

 left<target<mid   右边
 {4, 5, 6, 7, 0, 1, 2}


 mid<target<left   左边

 target<left<mid   右边

 */
    int left=0;
    int right=nums.length-1;
    int flag=0;
    int mid;
//int a[]= new int[]{4, 5, 6, 7, 0, 1, 2};
    while (left<=right){
        mid=left + (right - left) / 2;
        if (target==nums[mid]){
            flag=1;
        }
        if (target>left){
            if (target>nums[mid]){
                left=mid+1;
            }else {

                right =mid-1;
            }
        }else{

        }

//        {
//            left=mid+1;
//        }
//        {
//            if (target>nums[mid]){
//                left=mid+1;
//        }else {
//                right=mid+1;
//            }
//        }


    }
return flag;
}

}