package core;

public class PropertyKey<T> {

    private String name;
    private Class<T> type; //zur laufzeit kann typ hinterlegt werden (beim T) das objekt kann sich selber betrachten und sehen von welcher klasse es is

    public PropertyKey(String name, Class<T> type){
        this.name = name;
        this.type=type;
    }

    public String name(){
        return name;
    }
    public Class<T> type(){
        return type;
    }

    public static <T> PropertyKey<T> of(String name, Class<T> type){
        return new PropertyKey<>(name, type);
    }
}
