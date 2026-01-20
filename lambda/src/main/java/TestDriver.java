import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestDriver {
    public static void main(String[] args) {

        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(5);
        ints.add(3);
        ints.add(10);
        ints.add(7);


        Collections.sort(ints, (i1, i2)->{
            return i2.compareTo(i1);
        });

        for(int i : ints){
            System.out.println(i);
        }

    }


}
