package filesToTest.javaFiles;

public class TestFile3 {
    static void countToTen() {
        int i = 1;
        do {
            System.out.println(i);
            i++;
        } while (i <= 10);
    }

    public void simpleLoop() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Looping: " + i);
        }
    }

    public void multipleConditions() {
        if (true) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
