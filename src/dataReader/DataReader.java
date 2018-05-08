package dataReader;

import java.io.IOException;
import java.util.List;

public interface DataReader {

    /**
     * <p>This method is used to read data from Input file.</p>
     * @return List of lines from File.
     * @throws IOException
     */
    List<String> readLinesFromFile() throws IOException;
}
