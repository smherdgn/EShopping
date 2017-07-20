package com.indbilsim.ecommerce.Customer;

import com.indbilisim.base.BaseEntity;
import com.indbilsim.ecommerce.Address.Address;
import com.indbilsim.ecommerce.Order.Order;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author ibrahimsengul
 *         Created by ibrahimm on 10.7.2017.
 */
@Entity
public class Customer extends BaseEntity {


    @NotNull
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private Order order;

    @NotNull
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private Address address;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @Email
    @NotNull
    private String email;

    private String gender;

    private int[] phone;

    private Date birthDate;

    @NotNull
    private String userRole;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int[] getPhone() {
        return phone;
    }

    public void setPhone(int[] phone) {
        this.phone = phone;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
