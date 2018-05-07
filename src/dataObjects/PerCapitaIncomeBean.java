package dataObjects;

public class PerCapitaIncomeBean {

    private String city;
    private String country;
    private String gender;
    private String currency;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
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

        StringBuilder sb = new StringBuilder();
        sb.append("City : ").append(getCity());
        sb.append(", Country : ").append(getCountry());
        sb.append(", Gender : ").append(getGender());
        sb.append(", Currency : ").append(getCurrency());
        sb.append(", Average Income : ").append(getAvgIncome());

        return sb.toString();
    }
}
