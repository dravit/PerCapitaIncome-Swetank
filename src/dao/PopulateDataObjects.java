package dao;

import converters.CurrencyConverter;
import dataObjects.AverageIncomeBean;
import dataObjects.PerCapitaIncomeBean;
import utils.Constants;
import utils.CurrencyEnums;
import utils.GenderEnum;

import java.util.*;

public class PopulateDataObjects {

    private PopulateDataObjects() {
        if(PopulateDataObjects.getInstance() != null) {
            throw new InstantiationError("Creating of this Singleton Class object is not allowed");
        }
    }

    private static class PopulateDataObjectsHelper {
        private static final PopulateDataObjects _instance = new PopulateDataObjects();
    }

    public static PopulateDataObjects getInstance() {
        return PopulateDataObjectsHelper._instance;
    }

    /**
     * <p>This method will perform following tasks on the input list : </p>
     * <b>Task 1 : Create and convert {@link AverageIncomeBean}</b>
     * <ul>
     *     <li>First it will split data in each line based on ','</li>
     *     <li>Create {@link AverageIncomeBean} for each line.</li>
     *     <li>Convert averageIncome to USD value using {@link CurrencyConverter}</li>
     *     <li>Group beans based on Country / City _ Gender _ Currency</li>
     *     <li>Put that grouped list in Map</li>
     * </ul>
     * <b>Task 2 : Calculate {@link PerCapitaIncomeBean} from {@link AverageIncomeBean}</b>
     * @param linesFromFile List of lines that are read from file.
     * @return
     */
    public List<PerCapitaIncomeBean> getPerCapitaIncomes(List<String> linesFromFile) {
        Map<String, List<AverageIncomeBean>> averageIncomeObjects = populateAverageIncomeObjects(linesFromFile);
        return populatePerCapitaIncomeObjects(averageIncomeObjects);
    }

    private Map<String, List<AverageIncomeBean>> populateAverageIncomeObjects(List<String> linesFromFile) {
        String columns[];
        Map<String, List<AverageIncomeBean>> dataMap = new HashMap<>();
        AverageIncomeBean averageIncomeBean;
        String key;
        for(String line : linesFromFile) {
            averageIncomeBean = new AverageIncomeBean();
            columns = line.split(Constants.DELIMITER);
            averageIncomeBean.setCity(columns[0]);
            averageIncomeBean.setCountry(columns[1]);
            averageIncomeBean.setGender(GenderEnum.valueOf(columns[2].toUpperCase().trim()));
            averageIncomeBean.setCurrency(CurrencyEnums.valueOf(columns[3].toUpperCase().trim()));
            averageIncomeBean.setAvgIncome(Double.parseDouble(columns[4]));
            CurrencyConverter.covertIncomeToUSD(averageIncomeBean);

            key = (averageIncomeBean.getCountry().isEmpty() ? averageIncomeBean.getCity() : averageIncomeBean.getCountry())
                    + Constants.KEY_SEPARATOR + averageIncomeBean.getGender()
                    + Constants.KEY_SEPARATOR + averageIncomeBean.getCurrency();
            if(dataMap.containsKey(key)) {
                dataMap.get(key).add(averageIncomeBean);
            } else {
                List<AverageIncomeBean> list = new ArrayList<>();
                list.add(averageIncomeBean);
                dataMap.put(key, list);
            }
        }
        return dataMap;
    }

    private List<PerCapitaIncomeBean> populatePerCapitaIncomeObjects(Map<String, List<AverageIncomeBean>> dataMap) {
        List<PerCapitaIncomeBean> perCapitaIncomeList = new ArrayList<>();
        PerCapitaIncomeBean perCapitaIncomeBean;
        for(Map.Entry<String, List<AverageIncomeBean>> entry : dataMap.entrySet()) {
            perCapitaIncomeBean = new PerCapitaIncomeBean();
            double incomeSum = 0.0;
            for(AverageIncomeBean averageIncomeBean : entry.getValue()) {
                incomeSum = incomeSum + averageIncomeBean.getAvgIncome();
            }
            double perCapitaIncome =  incomeSum / entry.getValue().size();
            String [] keys = entry.getKey().split(Constants.KEY_SEPARATOR);
            perCapitaIncomeBean.setCity_Country(keys[0]);
            perCapitaIncomeBean.setGender(GenderEnum.valueOf(keys[1]));
            perCapitaIncomeBean.setPerCapitaIncome(Math.floor(perCapitaIncome * 100) / 100);
            perCapitaIncomeList.add(perCapitaIncomeBean);
        }
        return perCapitaIncomeList;
    }
}
