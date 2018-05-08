package dataReader;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class ReadFromCSVTest {

    private static final String INPUT_FILENAME = "resources\\input\\AverageIncomeInput.csv";

    DataReader dataReader;

    @Before
    public void setUp() throws Exception {
        dataReader = new ReadFromCSV(INPUT_FILENAME);
    }

    @Test
    public void readLinesFromFile() throws IOException {
        List<String> linesFromFile = dataReader.readLinesFromFile();
        assertEquals(21, linesFromFile.size());
    }
}
