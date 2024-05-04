package filesToTest.javaFiles;

import jdk.jfr.Name;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ComplexMethods1 {

    public static <T extends Comparable<T>> void sortList(List<T> list) {
        Collections.sort(list);
    }

    protected final synchronized Map<String, List<Integer>> aggregateData(String key, List<Integer> values) {
        return Map.of(key, values);
    }

    private void processData(String data, int... values) {
        System.out.println(data + Arrays.toString(values));
    }
}

