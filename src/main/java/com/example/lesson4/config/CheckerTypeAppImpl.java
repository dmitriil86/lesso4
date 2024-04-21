package com.example.lesson4.config;

import com.example.lesson4.annotations.LogTransformation;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(2)
@LogTransformation("./CheckerLogs")
public class CheckerTypeAppImpl implements CheckerInterface {
    @Override
    public String[] check(String[] str) {

        if (!str[5].equals("web") && !str[5].equals("mobile"))
        {
            str[5] = "other:"+str[5];
        }
        return str;
    }
}
