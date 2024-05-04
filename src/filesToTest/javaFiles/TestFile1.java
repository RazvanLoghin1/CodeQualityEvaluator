package filesToTest.javaFiles;

public class TestFile1 {
    public void simpleMethod() {
        int i = 0;
        while (i < 5) {
            System.out.println(i);
            i++;
        }
    }

    private static int calculateSum(int a, int b) {
        return a + b;
    }

    protected void ComplexMethod() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println(i * j);
            }
        }
    }
}

