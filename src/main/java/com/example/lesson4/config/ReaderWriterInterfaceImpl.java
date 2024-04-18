package com.example.lesson4.config;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.util.*;

@Service
public class ReaderWriterInterfaceImpl implements ReaderWriterInterface {

    @Value("${file.path.logfile}")
    private  String logName;
    @Override
    @SneakyThrows
    public Map<String, List<String>> reader(String path) {

        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        Map<String, List<String>> tempMap = new HashMap<>();


        for (File file : listOfFiles) {

            List<String>  temp = new ArrayList<>();

            if (file.isFile()) {
                Scanner scanner = new Scanner(file);

                while (scanner.hasNextLine()) {
                    temp.add(scanner.nextLine());
                }

                tempMap.put(file.getName(),temp);
                scanner.close();
            }
        }
        return tempMap;
    }

    @SneakyThrows
    @Override
    public void write(String string) {

        FileWriter writer = new FileWriter(logName,true);
        writer.write(string);
        writer.close();

    }
}
