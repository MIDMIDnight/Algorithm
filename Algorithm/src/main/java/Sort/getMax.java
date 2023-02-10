package Sort;

public class getMax {
     public int getMaxNum(int[] arry,int l,int r){
          if (l==r){
               return arry[l];
          }
          int mid=l+((r-l) >> 2);
          int maxNum = getMaxNum(arry, l, mid);
          int maxNum1 = getMaxNum(arry, mid + 1, r);
          return Math.max(maxNum,maxNum1);

     }

     //递归时间复杂度master公式 ： T(N) =a*T（n/b）+o（nd） a是母问题被划分多少个子问题 n/b是指母问题长度在子问题当中的占比
     //                       T（n）=2*T(n/2)+o(1)
}
