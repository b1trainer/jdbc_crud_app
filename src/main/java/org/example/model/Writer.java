package org.example.model;

public class Writer {
    private Long id;
    private String firstName;
    private String lastName;

    public Writer() {
    }

    public Writer(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return String.format("""
                ===============
                Writer id: %d
                First name: %s
                Last name: %s
                ===============
                """, id, firstName, lastName);
    }
}
