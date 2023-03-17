package Demo;



import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> integers = new ArrayList<>();
        int var1=scanner.nextInt();
        if (var1!=0){
            for (int i = 0; i < var1; i++) {
                int var2=scanner.nextInt();
                integers.add(var2);
            }
        }

        int var3=scanner.nextInt();
        if (var3!=0){
            for (int i = 0; i < var3; i++) {
                int var4=scanner.nextInt();
                if (!integers.contains(var4)){
                    integers.add(var4);
                }
            }
        }
        if (var1==0&&var3==0){
            System.out.print(0);
        }else {
            for (int var5:integers
            ) {
                System.out.print(var5+" ");
            }
        }

    }
}
