package com.example.lesson4;

import com.example.lesson4.config.CheckerInterface;
import com.example.lesson4.config.ReaderWriterInterface;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestPropertySource(locations="classpath:application.properties")
class Lesson4ApplicationTests {

    @Autowired
    List<CheckerInterface> checkerInterface;

    @Autowired
    ReaderWriterInterface readerWriterInterface;

    @Test
    void testCheckers() {

        String testString = "test tester testerich testerovich 2024-02-02 eee";
        String expected = "test Tester Testerich Testerovich 2024-02-02 other:eee";
        String[] str = testString.split(" ");

        for (CheckerInterface item : checkerInterface)
        {
            str = item.check(str);
        }

        assertEquals(expected,String.join(" ",str));

    }

    @Value("${file.path.readfolder}")
    private  String logName;

    @Test
    @SneakyThrows
    void testReader()
    {
        String testString = "test tester testerich testerovich 2024-02-02 eee";

        FileWriter writer = new FileWriter("./testRead/TestLogsWriterReader.txt");
        writer.write(testString+"\n");
        writer.close();

        Map<String, List<String>> info = readerWriterInterface.reader("./testRead/");

        List<String> temp = info.get("TestLogsWriterReader.txt");
        assertEquals(testString,temp.get(0));
    }

    @Test
    @SneakyThrows
    void testWriter()
    {
        String testString = "test tester testerich testerovich 2024-02-02 eee";

        readerWriterInterface.write(testString);

        Map<String, List<String>> info = readerWriterInterface.reader("./testRead/");

        List<String> temp = info.get("TestLogsWriterReader.txt");
        assertEquals(testString,temp.get(0));
    }

}
