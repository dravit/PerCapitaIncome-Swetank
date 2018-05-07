package dataReader;

import java.io.IOException;
import java.util.List;

public interface DataReader {

    public List<String> readLinesFromFile() throws IOException;
}
