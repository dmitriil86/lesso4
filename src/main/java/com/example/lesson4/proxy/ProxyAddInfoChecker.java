package com.example.lesson4.proxy;

import com.example.lesson4.annotations.LogTransformation;
import com.example.lesson4.config.CheckerInterface;
import lombok.SneakyThrows;

import java.io.FileWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Arrays;

public class ProxyAddInfoChecker implements InvocationHandler {

    private CheckerInterface checkerInterface;

    public ProxyAddInfoChecker(CheckerInterface checkerInterface)
    {
        this.checkerInterface = checkerInterface;
    }

    @Override
    @SneakyThrows
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
       try {

           String arguments = String.join(" ", (String[]) args[0]);
           String[] o =  (String[]) method.invoke(this.checkerInterface,args);
           String returns = String.join(" ", o);
           String path = this.checkerInterface.getClass().getAnnotation(LogTransformation.class).value();
           String string = LocalDateTime.now()+"  Name class = " + checkerInterface.getClass().getSimpleName() + "  Args = "+ arguments+"  return = "+ returns+'\n';
           FileWriter writer = new FileWriter(path,true);
           writer.write(string);
           writer.close();
           return o;
       }catch (InvocationTargetException ex)
       {
           throw ex.getCause();
       }

    }
}
