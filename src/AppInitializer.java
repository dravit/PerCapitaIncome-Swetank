import dao.PopulateDataObjects;
import dataObjects.PerCapitaIncomeBean;
import dataReader.DataReader;
import dataReader.ReadFromCSV;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AppInitializer {

    private static final Logger LOGGER = Logger.getLogger(AppInitializer.class.getName());

    public static void main(String[] args) {
        DataReader dataReader = new ReadFromCSV();
        List<String> linesFromFile = null;
        try {
            linesFromFile = dataReader.readLinesFromFile();
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error while reading data from Input Source" , e);
        }

        if(linesFromFile != null && linesFromFile.size() > 0) {
            Set<PerCapitaIncomeBean> perCapitaIncomeBeans = new PopulateDataObjects().populateDataObjects(linesFromFile);

            System.out.println(perCapitaIncomeBeans);
        }

    }
}
