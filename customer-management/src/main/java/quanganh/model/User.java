package quanganh.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class User implements Validator {
    private int id;
    private String number;
    private int age;
    @Size(min = 5, max = 45)
    private String firstname;
    @Size(min = 5, max = 45)
    private String lastname;
    @Email
    private String email;

    public User() {
    }

    public User(int id, String number, int age, @Size(min = 5, max = 45) String firstname, @Size(min = 5, max = 45) String lastname, @Email String email) {
        this.id = id;
        this.number = number;
        this.age = age;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        String number = user.getNumber();
        ValidationUtils.rejectIfEmpty(errors, "number", "number.empty");
        if (number.length()>11 || number.length()<10){
            errors.rejectValue("number", "number.length");
        }
        if (!number.startsWith("0")){
            errors.rejectValue("number", "number.startsWith");
        }
        if (!number.matches("(^$|[0-9]*$)")){
            errors.rejectValue("number", "number.matches");
        }

        int age = user.getAge();
        ValidationUtils.rejectIfEmpty(errors, "age", "age.empty");
        if (age < 18) {
            errors.rejectValue("age", "age.size");
        }
    }
}