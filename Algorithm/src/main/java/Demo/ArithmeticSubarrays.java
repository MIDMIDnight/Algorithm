package Demo;

import util.Arry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArithmeticSubarrays {

    public static void main(String[] args) {

    }
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
    int numsLength=nums.length;
    int rangeLength=l.length;
    List<Boolean> answer=new ArrayList<>();
        for (int i = 0; i < rangeLength; i++) {
            int[] tempArry= Arrays.copyOfRange(nums,l[i],r[i]+1);
            Arrays.sort(tempArry);
            boolean answer1 = isArithmetic(tempArry, tempArry.length, tempArry[tempArry.length - 1], tempArry[0]);
            answer.add(answer1);
        }
    return answer;
    }

    public boolean isArithmetic(int[] subarry, int length,int max,int min){
        if ((max-min)%length != 0 ){
            return false;
        }
        int d=(max+min)/length;
        boolean isFlag=true;
        for (int i = 0; i < length; i++) {
            int index =min+d*i;
            if (subarry[i]!=index){
                isFlag=false;
                break;
            }


        }
        return isFlag;

    }

    public List<Boolean> checkArithmeticSubarrays1(int[] nums, int[] l, int[] r) {
        List<Boolean> ans=new ArrayList<>();
        for(int i=0;i<l.length;i++){
            int arr[]=Arrays.copyOfRange(nums,l[i],r[i]+1);
            Arrays.sort(arr);
            int d=arr[1]-arr[0];
            boolean ch=true;
            for(int j=2;j<=r[i]-l[i];j++){
                if(d!=arr[j]-arr[j-1]){
                    ch=false;
                    break;
                }
            }
            ans.add(ch);
        }
        return ans;
    }
}
