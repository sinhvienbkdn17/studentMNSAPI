package vn.tommy.demo.model;

import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private int age;
    private String email;
    private Date birthday;


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public boolean checkValidEntity() {
        boolean isValid = true;

        // check name
        if(StringUtils.isEmpty(this.name)) {
            return false;
        }

        if(this.age == 0) {
            return false;
        }

        // check email
        if(StringUtils.isEmpty(this.email)) {
            return false;
        }

        if(this.birthday == null) {
            return false;
        }

        return isValid;
    }
}
