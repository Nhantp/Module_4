package form.model;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @NotBlank
    @Size(min = 5, max = 45)
    private String firstName;
    @NotBlank
    @Size(min = 5, max = 45)
    private String lastName;
    @Pattern(regexp = "^((09)|(03))|(08)[0-9]{7}$",message = "Phone number must be in the correct format 0xxxxxxxxx.")
    private String phoneNumber;
    @Min(18)
    private int age;

    public User(int id, String firstName, String lastName, String phoneNumber, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
