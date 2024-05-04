package filesToTest.javaFiles;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public abstract class ComplexMethods2 {

    @Deprecated
    public synchronized <K, V extends Number> HashMap<K, V> convertListToMap(List<K> keys, List<V> values) {
        HashMap<K, V> map = new HashMap<>();
        for (int i = 0; i < keys.size(); i++) {
            map.put(keys.get(i), values.get(i));
        }
        return map;
    }

}

