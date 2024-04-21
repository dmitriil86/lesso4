package com.example.lesson4.config;

import com.example.lesson4.annotations.LogTransformation;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@Order(1)
@LogTransformation("./CheckerLogs")
public class CheckeFioImpl implements CheckerInterface {
    @Override
    public String[] check(String[] str) {

        str[1] = StringUtils.capitalize(str[1]);
        str[2] = StringUtils.capitalize(str[2]);
        str[3] = StringUtils.capitalize(str[3]);

        return str;
    }
}
