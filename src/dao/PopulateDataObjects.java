package dao;

import dataObjects.PerCapitaIncomeBean;
import utils.Constants;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PopulateDataObjects {

    public Set<PerCapitaIncomeBean> populateDataObjects(List<String> linesFromFile) {
        String columns[];
        Set<PerCapitaIncomeBean> dataSet = new HashSet<>();
        PerCapitaIncomeBean perCapitaIncomeBean;
        for(String line : linesFromFile) {
            perCapitaIncomeBean = new PerCapitaIncomeBean();
            columns = line.split(Constants.DELIMETER);
            perCapitaIncomeBean.setCity(columns[0].toUpperCase());
            perCapitaIncomeBean.setCountry(columns[1].toUpperCase());
            perCapitaIncomeBean.setGender(columns[2].toUpperCase());
            perCapitaIncomeBean.setCurrency(columns[3].toUpperCase());
            perCapitaIncomeBean.setAvgIncome(Double.parseDouble(columns[4]));
            dataSet.add(perCapitaIncomeBean);
        }
        return dataSet;
    }
}
