package ru.noorsoft.javaeducation.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "firstName")
    private String firstName;

    @NotNull
    @Column(name = "lastName")
    private String lastName;

    @NotNull
    @Column(name = "PhoneNumber")
    private String phoneNumber;

    @NotNull
    @Column(name = "Email")
    private String email;

    protected User(){

    }
    public User(String firstName, String lastName, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%d, firstName='%s', lastName='%s', phoneNumber='%s', email='%s']",
                id, firstName, lastName, phoneNumber, email);
    }
}
