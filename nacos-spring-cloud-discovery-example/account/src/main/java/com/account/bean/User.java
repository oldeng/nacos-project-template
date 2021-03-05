package com.account.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor    
public class User {

    private int id;
    private String name;
    private Balance balance;


}
