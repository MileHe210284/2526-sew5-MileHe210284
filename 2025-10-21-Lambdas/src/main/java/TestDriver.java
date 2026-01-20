import java.util.function.Predicate;

public class TestDriver {
    public static void main(String[] args) {

        String s = "This is a string";


        // transform to upper case!
            System.out.println(new StringTransformer() {
                @Override
                public String transform(String s) {
                   return s.toUpperCase();
                }
            });


        //ohne lambda. mit anonymous inner class
        printTransformString(s, new StringTransformer() {
            @Override
            public String transform(String s) {
                return s.toUpperCase();
            }
        });

        //mit lambda
        printTransformString(s, s1 -> s1.toUpperCase());

        printTransformString(s, s1 -> s1.replaceAll(" ", "_"));

        //with method reference
        printTransformString(s, String::toUpperCase);

        //funktion die true oder false zurück gibt
        filter(s, str -> {return !str.isEmpty(); });
    }

    //test with predicate test not empty string



    public static void printTransformString(String s, StringTransformer t) {
        System.out.println(t.transform(s));
    }

    public static void filter (String s, Predicate<String> p){
        System.out.println("Test result: " + p.test(s));
    }

}
