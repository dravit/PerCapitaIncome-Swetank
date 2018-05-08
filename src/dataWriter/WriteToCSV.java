package dataWriter;

import dataObjects.PerCapitaIncomeBean;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static utils.Constants.*;

public class WriteToCSV implements DataWriter {

    private String filename;

    public WriteToCSV(String fileName) {
        this.filename = fileName;
    }

    /**
     *
     * @param dataList : List containing the lines that are to be Written on File.
     * @throws IOException
     */
    @Override
    public void writeToFile(List<?> dataList) throws IOException {
        PrintWriter pw = new PrintWriter(new File(filename));
        StringBuilder sb = new StringBuilder();
        sb.append(CITY_COUNTRY).append(DELIMITER);
        sb.append(GENDER).append(DELIMITER);
        sb.append(PERCAPITAINCOME).append("\n");

        for(PerCapitaIncomeBean perCapitaIncomeBean : (List<PerCapitaIncomeBean>) dataList) {
            sb.append(perCapitaIncomeBean.getCity_Country()).append(DELIMITER);
            sb.append(perCapitaIncomeBean.getGender()).append(DELIMITER);
            sb.append(perCapitaIncomeBean.getPerCapitaIncome()).append("\n");
        }

        pw.write(sb.toString());
        pw.close();
        System.out.println("Process Completed !!");
    }
}
