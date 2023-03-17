package KMP;

public class KMPbrand {

    public static void main(String[] args) {


    }

    public int getIndexOf(String s,String m){
        if (s==null||m==null||m.length()<1 ||s.length()<1){
            return -1;
        }
        char[] str1=s.toCharArray();
        char[] str2=m.toCharArray();
        int i1=0;
        int i2=0;
        int[] next=getIndexNext(str2);
        while (i1<str1.length&&i2<str2.length){
            if (str1[i1]==str2[i2]){
                i1++;
                i2++;
            }else if (next[i2]==-1){
                i1++;
            }else {
                i2=next[i2];
            }
        }
        return i2==str2.length?i1-i2:-1;
    }


    public int[] getIndexNext(char[] ms){
        if (ms.length==1){
        return new int[]{-1};
        }
        int[] next=new int[ms.length];
        next[0]=-1;
        next[1]=0;
        int i=2;
        int cn=0;
        while (i< next.length){
            if (ms[i-1]==ms[cn]){
                next[i++]=++cn;
            }else if (cn > 0){
                cn=next[cn];
            }else {
                next[i++]=0;
            }
        }
        return next;
    }
}
