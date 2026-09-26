package com.app.ecom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class dbrequest {
    @Autowired
    DB db;
    String getdata(){
        return db.getdata();
    }

}
