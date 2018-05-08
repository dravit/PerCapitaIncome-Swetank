package dataWriter;

import java.io.IOException;
import java.util.List;

public interface DataWriter {

    public void writeToFile(List<?> dataList) throws IOException;
}
