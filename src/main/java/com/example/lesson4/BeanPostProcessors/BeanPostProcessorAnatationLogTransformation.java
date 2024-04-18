package com.example.lesson4.BeanPostProcessors;

import com.example.lesson4.annotations.LogTransformation;
import com.example.lesson4.config.CheckerInterface;
import com.example.lesson4.config.Utils;
import com.example.lesson4.proxy.ProxyAddInfoChecker;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class BeanPostProcessorAnatationLogTransformation implements BeanPostProcessor {

   public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

      if (bean.getClass().isAnnotationPresent(LogTransformation.class))
      {
          CheckerInterface proxyAddInfoChecker = Utils.newObject(bean,new ProxyAddInfoChecker((CheckerInterface)bean));
          return proxyAddInfoChecker;
      }


        return bean;
    }


    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }


}
