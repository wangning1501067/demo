package com.test.demo.event.test4;

import lombok.Data;

@Data
public class UserTest {
    String username;
    String pass;

    /*public UserTest(Object source, String username, String pass) {
        super(source);
        this.username = username;
        this.pass = pass;
        System.out.println("username="+username+"=pass="+pass);
    }*/

    public String toString(){
        return "username="+username+"=pass="+pass;
    }
}
