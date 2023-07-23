package com.customer.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClassB {
    @Autowired
    private ClassC c;
    public void getHL(){
        c.hello();
    }

}
