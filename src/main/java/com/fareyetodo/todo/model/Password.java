package com.fareyetodo.todo.model;

public class Password {
    private String password;
    private String mySecurePassword;

    public Password(String password) {
        String myPassword = password;
        String salt = Encryption.getSalt(30);
        String mySecurePassword = Encryption.generateSecurePassword(myPassword, salt);

        this.mySecurePassword = mySecurePassword;

        System.out.println(mySecurePassword);
        System.out.println(salt);
    }

    public String getMySecurePassword() {
        return mySecurePassword;
    }

}
