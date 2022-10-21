package com.fareyetodo.todo.model;

public class Password {
    private String password;
    private String mySecurePassword;

    public Password(String password) {
        String myPassword = password;
        String salt = Encryption.getSalt(30);
        String mySecurePassword = Encryption.generateSecurePassword(myPassword, salt);

        this.mySecurePassword = mySecurePassword;

    }

    public String getMySecurePassword() {
        return mySecurePassword;
    }

}
