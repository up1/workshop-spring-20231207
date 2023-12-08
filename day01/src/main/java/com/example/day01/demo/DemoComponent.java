package com.example.day01.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Component
public class DemoComponent {

    @Autowired
    private MyService service2;

    void todo() {
        try{
            System.out.println(1/0);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    void db(){
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        try(Connection conn = DriverManager.getConnection("")) {

        } catch (Exception e) {

        } finally {

        }
    }

}
