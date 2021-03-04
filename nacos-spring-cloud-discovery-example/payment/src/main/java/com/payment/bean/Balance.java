package com.payment.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor    
public class Balance {

    private int id;
    private int diamond;
    private int ticket;
    private String message;
 
    public Balance(int id, int diamond, int ticket) {
        this(id, diamond, ticket, "OK");
    }
    // public Balance(int id, int diamond, int ticket, String message) {
    //     this.id = id;
    //     this.diamond = diamond;
    //     this.ticket = ticket;
    //     this.message = message;
    // }

}
