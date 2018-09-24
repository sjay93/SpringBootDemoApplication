package com.yash.userloginregister.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * The type User.
 */
@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Email(message = "Please provide a valid Email")
    @NotEmpty(message = "Please provide an email")
    private String email;

    @Column(name = "user_name")
    @NotEmpty(message = "Please provide an Username")
    private String userName;

    @Length(min = 5, message = "Your password must have at least 5 characters")
    @NotEmpty(message = "Please provide your password")
    private String password;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    private UserDetail userDetail;

    /**
     * Instantiates a new User.
     */
    public User() {

    }

    /**
     * Instantiates a new User.
     *
     * @param email    the email
     * @param userName the user name
     * @param password the password
     */
    public User(String email, String userName, String password) {
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets user detail.
     *
     * @return the user detail
     */
    public UserDetail getUserDetail() {
        return userDetail;
    }

    /**
     * Sets user detail.
     *
     * @param userDetail the user detail
     */
    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }
}
