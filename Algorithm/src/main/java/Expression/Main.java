package Expression;

import java.util.*;
public class Main {
//    public static void main(String[] args) {
//        Main minFixExpression = new Main();
//        Scanner scanner = new Scanner(System.in);
//        int solve = minFixExpression.solve("3.18.56.+*@");
//        System.out.println(solve);
//
//    }
//    public int solve(String Expression){
//        char[] chars = Expression.toCharArray();
//            Stack<Integer> stackNumber = new Stack<>();
//            int result = 0;
//        for (int i = 0; i < Expression.length(); i++) {
//
//            if (48<=chars[i] &&chars[i]<=57){
//                int temp=(int) chars[i]-48;
//                System.out.println(temp);
//                stackNumber.push(temp);
//            }
//            if (chars[i]==42||chars[i]==43||chars[i]==45||chars[i]==37){
//                    int var1=  stackNumber.pop();
//                    int var2=  stackNumber.pop();
//                    int temp = 0;
//                    if (chars[i]==42){
//                        temp=var2*var1;
//                    }
//                    if (chars[i]==43){
//                        temp=var2+ var1;
//                }
//                    if (chars[i]==45){
//                        temp=var2-var1;
//
//                }
//                    if (chars[i]==37){
//                        temp=var2%var1;
//                }
//                 stackNumber.push(temp);
//            }
//            if (chars[i]=='@'){
//                result = stackNumber.pop();
//            }
//        }
//        return result;
//    }
//

//    public static void readNumber(String str, int i,List result){
//        int index = i;
//        int count = 1;//记录扫描时倍数，如23：3是1倍，而2是十倍
//        int numberTarget = Integer.valueOf(String.valueOf(str.charAt(i)));//记录当前的数字
//        if (i == 0){//如果是字符串中的第一个数字
//            result.add(numberTarget);//直接加在结果列表中
//        }else {
//            if (result.size() != 0 && index > 0 && Character.isDigit(str.charAt(index - 1)))//如果结果列表非空且字符串前面的字符也是数字
//                result.remove(result.size() - 1);//移除结果列表中之前的数字
//            while (index > 0 && Character.isDigit(str.charAt(index - 1))){
//                count *= 10;//倍数加10倍
//                numberTarget = Integer.valueOf(String.valueOf(str.charAt(index - 1))) * count + numberTarget;//字符串前面的数字加倍后加上当前数字
//                index--;
//            }
//            result.add(numberTarget);//将最终结果加入结果集
//        }
//    }
//
//
//        public static List getNumberInString(String str) {
//            List result = new ArrayList();//记录最终结果
//            for (int i = 0; i < str.length(); i++) {
//                if (Character.isDigit(str.charAt(i))) {//如果是数字，执行方法
//                    readNumber(str, i, result);
//                }
//            }
//            return result;
//        }
//    public static void main(String[] args) {
//        String infix = "1246+7-90*100";
//        List postfix = getNumberInString(infix);
//        for (int i = 0; i < postfix.size(); i++){
//            System.out.print(postfix.get(i) + " | ");
//        }
//    }
public static void main(String[] args) {
    int sum=0;
    for (int i = 2; i < 1024; i++) {
        boolean flag=true;
        for (int j = 2; j < i; j++) {
            if (i%j==0){
                flag=false;
                break;
            }
        }
        if (flag){
            sum+=i;
            System.out.println(i+"   sum= "+sum);
        }
    }


    }


    public int getNumberInString(String Expresion){
        Stack<Integer> result = new Stack();
        int var1=0;
        int var2=0;
        int resultNum=0;
        for (int i = 0; i < Expresion.length(); i++) {
            if (Character.isDigit(Expresion.charAt(i))){
                readNumber(Expresion, i, result);
            }
            switch (Expresion.charAt(i)){
                case '+':
                    var1= (int) result.pop();
                    var2= (int) result.pop();
                    result.push(var2+var1);
                    continue;
                case '-':
                    var1= (int) result.pop();
                    var2= (int) result.pop();
                    result.push(var2-var1);
                    continue;
                case '*':
                    var1= (int) result.pop();
                    var2= (int) result.pop();
                    result.push(var2*var1);
                    continue;
                case '%':
                    var1= (int) result.pop();
                    var2= (int) result.pop();
                    result.push(var2%var1);
                    continue;
                case '@':
                    resultNum= (int) result.pop();
                    continue;
            }

        }
        return resultNum;
    }
    private void readNumber(String expresion, int i, Stack result) {
        int index=i;
        int coutn=1;
        int targetNumber=Integer.valueOf(String.valueOf(expresion.charAt(i)));
        if (index==0){
            result.push(targetNumber);
        }else {
            if (index!=0&&Character.isDigit(expresion.charAt(index-1))){
//                int pop = (int) result.pop();
                while (index!=0&&Character.isDigit(expresion.charAt(index-1))){
                    coutn *=10;
                    targetNumber=Integer.valueOf(String.valueOf(expresion.charAt(index-1)))*coutn+targetNumber;
                    index--;
                }

            }
            result.push(targetNumber);
        }
    }

}
