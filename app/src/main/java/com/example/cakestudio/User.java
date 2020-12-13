package com.example.cakestudio;

public class User {
    public String name ,email,phone;

    public User(){

    }

    public User(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone =phone ;
    }





    public String getname() {
            return name;
    }

    public String getemail() {
        return email;
    }
}
