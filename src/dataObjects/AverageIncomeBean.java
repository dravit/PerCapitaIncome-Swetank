package dataObjects;

import utils.CurrencyEnums;
import utils.GenderEnum;

import java.util.Objects;

public class AverageIncomeBean {

    private String city;
    private String country;
    private GenderEnum gender;
    private CurrencyEnums currency;
    private double avgIncome;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public CurrencyEnums getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyEnums currency) {
        this.currency = currency;
    }

    public double getAvgIncome() {
        return avgIncome;
    }

    public void setAvgIncome(double avgIncome) {
        this.avgIncome = avgIncome;
    }

    @Override
    public String toString() {
        return "AverageIncomeBean{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", gender=" + gender +
                ", currency=" + currency +
                ", avgIncome=" + avgIncome +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AverageIncomeBean)) return false;
        AverageIncomeBean that = (AverageIncomeBean) o;
        return Double.compare(that.getAvgIncome(), getAvgIncome()) == 0 &&
                Objects.equals(getCity(), that.getCity()) &&
                Objects.equals(getCountry(), that.getCountry()) &&
                getGender() == that.getGender() &&
                getCurrency() == that.getCurrency();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getCity(), getCountry(), getGender(), getCurrency(), getAvgIncome());
    }
}
