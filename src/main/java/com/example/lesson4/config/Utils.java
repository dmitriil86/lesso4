package com.example.lesson4.config;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Utils {

    public static <T> T newObject(Object obj, InvocationHandler invocationHandler)
    {
        ClassLoader classLoader = obj.getClass().getClassLoader();

        Class[] interfaces = obj.getClass().getInterfaces();

        T proxy = (T) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);

        return proxy;
    }
}
