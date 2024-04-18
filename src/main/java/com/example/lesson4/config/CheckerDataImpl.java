package com.example.lesson4.config;

import com.example.lesson4.annotations.LogTransformation;
import com.example.lesson4.exceptions.DataInStringIsNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(3)
@AllArgsConstructor
@LogTransformation
public class CheckerDataImpl implements CheckerInterface {

    private final ReaderWriterInterface readerWriterInterface;

    @Override

    public String[] check(String[] str) {
        if(str[4].isEmpty() )
        {
            throw new DataInStringIsNull();
        }

        return str;
    }
}
