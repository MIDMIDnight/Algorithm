package JUC;

public class ThreadLocalTest {
   public static ThreadLocal<Integer> LOCAL=new ThreadLocal<>();
   public static void set(int a){
    LOCAL.set(a);
   }
   public static void get(){
       LOCAL.get();
   }
   public static void remove(){
       LOCAL.remove();
   }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
         new Thread(() -> System.out.println(1));

        }


    }



}
