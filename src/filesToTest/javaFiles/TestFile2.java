package filesToTest.javaFiles;

public class TestFile2 {
    public void fetchData() {
        if (true) {
            System.out.println("Data fetched");
        }
    }

    private void printData() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Data: " + i);
        }
    }

    public static void veryComplexMethod() {
        int count = 0;
        while (count < 3) {
            for (int i = 0; i < 5; i++) {
                if (i % 2 == 0) {
                    System.out.println("Even");
                } else {
                    System.out.println("Odd");
                }
            }
            count++;
        }
    }
}
