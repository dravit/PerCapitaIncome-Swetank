package dataObjects;

import utils.GenderEnum;

import java.util.Objects;

public class PerCapitaIncomeBean implements Comparable<PerCapitaIncomeBean> {

    private String city_Country;

    private GenderEnum gender;

    private double perCapitaIncome;

    public String getCity_Country() {
        return city_Country;
    }

    public void setCity_Country(String city_Country) {
        this.city_Country = city_Country;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public double getPerCapitaIncome() {
        return perCapitaIncome;
    }

    public void setPerCapitaIncome(double perCapitaIncome) {
        this.perCapitaIncome = perCapitaIncome;
    }

    @Override
    public String toString() {
        return "PerCapitaIncomeBean{" +
                "city_Country='" + city_Country + '\'' +
                ", gender='" + gender + '\'' +
                ", perCapitaIncome=" + perCapitaIncome +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PerCapitaIncomeBean)) return false;
        PerCapitaIncomeBean that = (PerCapitaIncomeBean) o;
        return Double.compare(that.getPerCapitaIncome(), getPerCapitaIncome()) == 0 &&
                Objects.equals(getCity_Country(), that.getCity_Country()) &&
                getGender() == that.getGender();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity_Country(), getGender(), getPerCapitaIncome());
    }

    @Override
    public int compareTo(PerCapitaIncomeBean o) {
        if(this.getCity_Country().compareTo(o.getCity_Country()) < 0) return -1;
        if(this.getCity_Country().compareTo(o.getCity_Country()) == 0 && this.getGender().toString().compareTo(o.getGender().toString()) < 0) return -1;
        if(this.getCity_Country().compareTo(o.getCity_Country()) == 0 && this.getGender().toString().compareTo(o.getGender().toString()) == 0 && this.getPerCapitaIncome() < o.getPerCapitaIncome()) return -1;
        return 0;
    }
}
