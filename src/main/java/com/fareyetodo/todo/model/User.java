package com.fareyetodo.todo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter
public class User {
    private String firstName;
    private String lastName;

    private String email;

    private Boolean verified, created, modified;

    private String password, mySecurePassword;

    public User()
    {
        Password userPassword = new Password("mypassword123");
        this.password = userPassword.getMySecurePassword();
        this.verified = Boolean.FALSE;
        this.mySecurePassword = userPassword.getMySecurePassword();
    }


    private Boolean active;
    private String role;



}
