package core;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Props {

    private final Map<String, String> map = new ConcurrentHashMap<>();

    public void put(String key, String value){
        Objects.requireNonNull(key);
        map.put(key, value);
    }

    public String get(String key){
        return map.get(key);
    }

    public Map<String, String> asMap(){
        return Collections.unmodifiableMap(map);
    }

}
