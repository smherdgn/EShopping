package com.indbilisim.customer;

import com.indbilisim.base.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by alikumru on 11.07.2017.
 */
@Table(name = "Customer_Table")
@Entity
public class Customer extends BaseEntity {


    @Size(max = 30)
    @NotNull
    private String name;

    @Size(max = 30)
    @NotNull
    private String surname;

    @Size(max = 30)
    @NotNull
    private String mail;

    @Size(max = 10)
    private String phone;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @NotNull
    @Size(max = 15)
    private String passwordConfirm;


    private Role role;

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return "Customer [name=" + name + ", surname=" + surname
                + ", mail="+mail+", ]";
    }
}