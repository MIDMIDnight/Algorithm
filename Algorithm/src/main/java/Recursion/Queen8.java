package Recursion;

public class Queen8 {
    int MAX=8;
    int[] arry=new int[8];//记录皇后位置
    int count=0;
    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        queen8.printCount();
    }
    //打印数组
    public void print(){
        for (int i = 0; i < arry.length; i++) {
            System.out.print(arry[i]+"  ");
        }
        count++;
        System.out.println();
    }
    //判断n个皇后之前的是否和前面所摆放的皇后冲突
    public boolean judge(int n){
        for (int i = 0; i < n; i++) {
            if (arry[i]==arry[n]||Math.abs(n-i)==Math.abs(arry[n]-arry[i])){
                return false;
            }
        }
        return true;
    }
    //编写方法放置皇后
    public void check(int n){
        if (n==MAX){
            print();
            return;
        }else {
            for (int i = 0; i < MAX; i++) {
                arry[n]=i;
                if (judge(n)){
                    check(n+1);
                }
            }
        }

    }
    public void printCount(){
        System.out.println(count);
    }

}
