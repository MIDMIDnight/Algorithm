package Stream;

import java.util.ArrayList;
import java.util.List;

public class MetaState {
    public static void main(String[] args) {

        List<Integer> integers=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            integers.add(i);
        }

        integers.stream().map(integer -> integer=10).forEach(integer -> System.out.println(integer));
        System.out.println("------------------------------------");
        integers.forEach(integer -> System.out.println(integer));


    }

}
