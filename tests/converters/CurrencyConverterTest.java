package converters;

import dataObjects.AverageIncomeBean;
import org.junit.Before;
import org.junit.Test;
import utils.CurrencyEnums;

import static org.junit.Assert.*;

public class CurrencyConverterTest {

    private AverageIncomeBean averageIncomeBean;

    @Before
    public void setUp() throws Exception {
        averageIncomeBean = new AverageIncomeBean();
    }

    @Test
    public void covertIncomeINRToUSD() {
        averageIncomeBean.setCurrency(CurrencyEnums.INR);
        averageIncomeBean.setAvgIncome(520);
        CurrencyConverter.covertIncomeToUSD(averageIncomeBean);
        assertEquals(7.73, Math.floor(averageIncomeBean.getAvgIncome() * 100) / 100, 0.001);
    }

    @Test
    public void covertIncomeGBPToUSD() {
        averageIncomeBean.setCurrency(CurrencyEnums.GBP);
        averageIncomeBean.setAvgIncome(520);
        CurrencyConverter.covertIncomeToUSD(averageIncomeBean);
        assertEquals(619.04, Math.floor(averageIncomeBean.getAvgIncome() * 100) / 100, 0.001);
    }

    @Test
    public void covertIncomeHKDToUSD() {
        averageIncomeBean.setCurrency(CurrencyEnums.HKD);
        averageIncomeBean.setAvgIncome(520);
        CurrencyConverter.covertIncomeToUSD(averageIncomeBean);
        assertEquals(66.24, Math.floor(averageIncomeBean.getAvgIncome() * 100) / 100, 0.001);
    }

    @Test
    public void covertIncomeSGPToUSD() {
        averageIncomeBean.setCurrency(CurrencyEnums.SGP);
        averageIncomeBean.setAvgIncome(520);
        CurrencyConverter.covertIncomeToUSD(averageIncomeBean);
        assertEquals(388.05, Math.floor(averageIncomeBean.getAvgIncome() * 100) / 100, 0.001);
    }

    @Test
    public void covertIncomeUSDToUSD() {
        averageIncomeBean.setCurrency(CurrencyEnums.USD);
        averageIncomeBean.setAvgIncome(520);
        CurrencyConverter.covertIncomeToUSD(averageIncomeBean);
        assertEquals(520.0, Math.floor(averageIncomeBean.getAvgIncome() * 100) / 100, 0.001);
    }
}
