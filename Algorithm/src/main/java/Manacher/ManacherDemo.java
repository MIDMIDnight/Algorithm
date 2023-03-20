package Manacher;

public class ManacherDemo {
    public static void main(String[] args) {
        ManacherDemo manacherDemo = new ManacherDemo();
        char[] chars = manacherDemo.preProcess("abba");
        int i = manacherDemo.maxLcp(chars);
        System.out.println(i);

    }



    public char[] preProcess(String str){
        int length = str.length();
        char[] chars = new char[length * 2 + 1];
        char[] chars1 = str.toCharArray();
        int index=0;
        for (int i = 0; i < chars.length; i++) {
        if (i%2==0){
            chars[i]='#';
        }else {
            chars[i]=chars1[index++];
        }
        }
        return chars;
    }

    public int maxLcp(char[] str){
        int[] preArry=new int[str.length];
        int C=-1;//"中心"
        int R=-1;//回文右边界的再往右一个位置，最右的有效区域是R-1；
        int max=0;
        for (int i = 0; i < str.length; i++) {
            preArry[i]=R > i ? Math.min(preArry[2*C-1],R-i) :1;
            //求出三种情况最基本的半径
            //第一种i小于R，初始化R
            //第二种
            // 1）i‘ 的回文半径小于R-i，直接赋值
            // 2）i’的回文半径大于R-i，直接赋值R-i，映射的时候超过原来R
            // 3) i‘的回文半径与R-I相等，暴力在I中心扩展
            while (i+preArry[i]<str.length
                    && (i-preArry[i])>=0
            ){
                if (str[i+preArry[i]]==str[i-preArry[i]]){
                    preArry[i]++;
                }else {
                    break;
                }
            }
            if (i+preArry[i] >R){
                R=i+preArry[i];
                C=i;
            }
            max=Math.max(max,preArry[i]);
        }
        return max;
    }
}


