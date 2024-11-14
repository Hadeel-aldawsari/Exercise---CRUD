package com.example.exercisebankcrud.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer{
    private int ID;
    private String Username;
    private double balance;
}
