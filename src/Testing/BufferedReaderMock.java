package Testing;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BufferedReaderMock {
    private InputStream inputStream;

    public BufferedReaderMock(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public BufferedReader getBufferedReader() {
        return new BufferedReader(new InputStreamReader(inputStream));
    }
}
