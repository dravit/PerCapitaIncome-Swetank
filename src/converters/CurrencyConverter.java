package converters;

import dataObjects.AverageIncomeBean;

import java.util.List;

public class CurrencyConverter {

    public static void covertIncomeToUSD(AverageIncomeBean averageIncomeBean) {
        switch (averageIncomeBean.getCurrency()) {
            case INR:
                averageIncomeBean.setAvgIncome(averageIncomeBean.getAvgIncome() / 67.25);
                break;
            case USD:
                break;
            case HKD:
                averageIncomeBean.setAvgIncome(averageIncomeBean.getAvgIncome() / 7.85);
                break;
            case SGP:
                averageIncomeBean.setAvgIncome(averageIncomeBean.getAvgIncome() / 1.34);
                break;
            case GBP:
                averageIncomeBean.setAvgIncome(averageIncomeBean.getAvgIncome() / 0.84);
                break;
        }
    }
}
