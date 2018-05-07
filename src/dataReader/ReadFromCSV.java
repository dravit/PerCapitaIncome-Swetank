package dataReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>This class is used to read data from input CSV file.</p>
 * <p>It implements interface Data Reader, which will be implemented for all types of readers (e.g : CSV, Excel ..)</p>
 *
 */
public class ReadFromCSV implements DataReader {

    private static final String FILENAME = "resources\\input\\PerCapitaIncomeInput.csv";

    @Override
    public List<String> readLinesFromFile() throws IOException {
        BufferedReader br;
        String line;
        List<String> listOfLines = new ArrayList<>();

        br = new BufferedReader(new FileReader(FILENAME));
        br.readLine();
        while ((line = br.readLine()) != null) {
            listOfLines.add(line);
        }

        return listOfLines;
    }
}
