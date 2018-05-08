import dao.PopulateDataObjects;
import dataObjects.PerCapitaIncomeBean;
import dataReader.DataReader;
import dataReader.ReadFromCSV;
import dataWriter.DataWriter;
import dataWriter.WriteToCSV;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AppInitializer {

    private static final Logger LOGGER = Logger.getLogger(AppInitializer.class.getName());

    private static final String INPUT_FILENAME = "resources\\input\\AverageIncomeInput.csv";
    private static final String OUTPUT_FILENAME = "resources\\output\\PerCapitaIncomeOutput.csv";

    public static void main(String[] args) {

        //Reading Data from CSV
        DataReader dataReader = new ReadFromCSV(INPUT_FILENAME);
        List<String> linesFromFile = null;
        try {
            linesFromFile = dataReader.readLinesFromFile();
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error while reading data from Input Source." , e);
        }

        //Doing calculations and preparing PerCapitaData
        List<PerCapitaIncomeBean> perCapitaIncomeList = null;
        if(linesFromFile != null && linesFromFile.size() > 0) {
            PopulateDataObjects populateDataObjects = PopulateDataObjects.getInstance();
            perCapitaIncomeList = populateDataObjects.getPerCapitaIncomes(linesFromFile);
            Collections.sort(perCapitaIncomeList);
        }

        //Writing Data from CSV
        if(perCapitaIncomeList != null) {
            DataWriter dataWriter = new WriteToCSV(OUTPUT_FILENAME);
            try {
                dataWriter.writeToFile(perCapitaIncomeList);
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, "Error while writing data to Output File." , e);
            }
        }
    }
}
