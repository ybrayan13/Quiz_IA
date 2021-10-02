package co.com.bancolombia.certificacion.advantage.models;

public class Address {
    private String city,zip,country;

    public Address(String city, String zip, String country) {
        this.city = city;
        this.zip = zip;
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public String getZip() {
        return zip;
    }

    public String getCountry() {
        return country;
    }
}
