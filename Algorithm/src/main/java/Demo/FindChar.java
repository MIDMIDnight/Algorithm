package Demo;


import java.util.HashMap;
import java.util.HashSet;

public class FindChar {
    int index=0;

    public static void main(String[] args) {
        FindChar findChar = new FindChar();
        HashMap<Character, Integer> caculate = findChar.caculate("A2(A2(SU8)4D9(A4I7)7D2)2A3".toCharArray());
        System.out.println(caculate);
    }


    public void process(String str){

    }

    public HashMap<Character,Integer> caculate(char[] str){
        int num=0;
        HashMap<Character, Integer> result = new HashMap<Character, Integer>();
        while (index<str.length-1){
            if (str[index]==')'){
                num=Integer.parseInt(String.valueOf(str[++index]));
                for (Character value: result.keySet()
                     ) {
                    Integer var = result.get(value);
                    var*=num;
                    result.put(value,var);
                }
                index++;
                break;
            }else {
                if (str[index]=='('){
                    index++;
                    HashMap<Character, Integer> result2 = caculate(str);
                    for (Character var:result2.keySet()
                         ) {
                        if (result.containsKey(var)){
                            Integer integer = result.get(var);
                            result.put(var,integer+result2.get(var));
                        }else {
                            result.put(var,result2.get(var));
                        }
                    }
                }
                if (str[index+1]>48&&str[index+1]<58){
                    if (result.containsKey(str[index])){
                        Integer integer = result.get(str[index]);
                        result.put(str[index],integer+Integer.parseInt(String.valueOf(str[index+1])));

                    }else {
                        result.put(str[index],Integer.parseInt(String.valueOf(str[index+1])));
                    }
                    index+=2;
                }else {
                    if (result.containsKey(str[index])){
                        Integer integer = result.get(str[index]);
                        result.put(str[integer],integer+1);

                    }else {
                        result.put(str[index],1);
                    }
                    index+=1;
                }
            }

        }
        return result;
    }
}
