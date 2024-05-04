package filesToTest.javaFiles;

import java.util.EnumSet;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ComplexMethods3 {

    public <U, V> void multiTaskProcessor(ConcurrentHashMap<U, Queue<V>> taskMap, U taskId) {
        Queue<V> queue = taskMap.getOrDefault(taskId, new ConcurrentLinkedQueue<>());
    }


    @SafeVarargs
    public final <E extends Enum<E>> void processEnums(E first, E... rest) {
        EnumSet<E> set = EnumSet.of(first, rest);
        System.out.println("Processing enums: " + set);
    }

    public <A, B, C> Triple<A, B, C> createTriple(A a, B b, C c) {
        return new Triple<>(a, b, c);
    }

    static class Triple<X, Y, Z> {
        private X first;
        private Y second;
        private Z third;

        public Triple(X first, Y second, Z third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }
}

