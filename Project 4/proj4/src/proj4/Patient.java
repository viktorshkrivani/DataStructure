package proj4;

// Viktor Shkrivani
// CIS 2353
// Fall 2023
// Prof. John P. Baugh

public class Patient {
    private String firstName;
    private String lastName;
    private String triageCode;

    public Patient(String firstName, String lastName, String triageCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.triageCode = triageCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getTriageCode(){
        return triageCode;
    }

    public String toString(){
        return  firstName + " " + lastName;
    }
}
