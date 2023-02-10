package Expression;


import java.util.Stack;
public class SubInt {


    public static void main(String[] args) {

        SubInt subInt = new SubInt();
        int numberInString = subInt.getNumberInString(" ");
        System.out.println(numberInString);

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
                int pop = (int) result.pop();
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

