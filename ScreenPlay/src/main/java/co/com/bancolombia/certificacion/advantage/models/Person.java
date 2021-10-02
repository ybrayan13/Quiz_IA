package co.com.bancolombia.certificacion.advantage.models;

public class Person {
    private String firstName, lastName, email, month, day, year, password, confirmpassword;

    public Person(String firstName, String lastName, String email, String month, String day, String year, String password, String confirmpassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.month = month;
        this.day = day;
        this.year = year;
        this.password = password;
        this.confirmpassword = confirmpassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getMonth() {
        return month;
    }

    public String getDay() {
        return day;
    }

    public String getYear() {
        return year;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }
}
