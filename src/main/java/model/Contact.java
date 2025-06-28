package model;

import java.io.Serializable;
import java.util.Objects;

public class Contact implements Serializable {
    private String firstName;
    private String lastName;
    private String email;

    public Contact(String firstName, String lastName, String email) {
        this.firstName = firstName.trim();
        this.lastName = lastName.trim();
        this.email = email.trim().toLowerCase(); // standardize
    }

    public String getEmail() {
        return email;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return getFullName() + " <" + email + ">";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Contact)) return false;
        Contact other = (Contact) obj;
        return email.equalsIgnoreCase(other.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email.toLowerCase());
    }
}
