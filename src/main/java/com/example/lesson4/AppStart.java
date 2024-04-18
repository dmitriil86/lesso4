package com.example.lesson4;

import com.example.lesson4.config.ReaderWriterInterfaceImpl;
import com.example.lesson4.config.SaveInterface;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;



@Component
public class AppStart {

    @Autowired
    private ReaderWriterInterfaceImpl readerInterface;

    @Autowired
    private SaveInterface saveInterface;

    @Value("${file.path.readfolder}")
    private String path;
    public void Start()
    {
        Map<String, List<String>> strings = readerInterface.reader(path);

        saveInterface.saveString(strings);

    }

}
