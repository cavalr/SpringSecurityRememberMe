package com.blog.cavalr.security;

public class UserFromDB {

    private String userName;

    private String password;

    //in case of multiple roles for user, roles will separated by (e.g. ROLE_USER, ROLE_ADMIN)
    //you can move roles to it own table and use list here.
    private String roles;

    public UserFromDB() {
    }

    public UserFromDB(String userName, String password, String roles) {
        this.userName = userName;
        this.password = password;
        this.roles = roles;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
