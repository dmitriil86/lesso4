package com.example.lesson4.config;

import java.util.List;
import java.util.Map;

public interface ReaderWriterInterface {

    Map<String, List<String>> reader(String path);

    void write (String string);
}
