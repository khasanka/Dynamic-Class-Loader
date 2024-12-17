package com.example.DynamicClassLoader.Servce;

import com.example.DynamicClassLoader.Util.DynamicClassLoaderUtil;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@Service
public class LoaderService {



    public void loadClass(final String path, final String className) throws IOException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<?> clazz = DynamicClassLoaderUtil.loadClass(path, className);

        Object instance = clazz.getDeclaredConstructor().newInstance();


        System.out.println( clazz.getMethod("whoAmI").invoke(instance) );



    }


}
