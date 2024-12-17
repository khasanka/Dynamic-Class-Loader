package com.example.DynamicClassLoader.Util;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;

public class DynamicClassLoaderUtil {

    public static Class<?> loadClass(String filePath, String className) throws IOException {

        URL[] urls = new URL[]{new URL("file:" + filePath)};

        try (URLClassLoader urlClassLoader = new URLClassLoader(urls, DynamicClassLoaderUtil.class.getClassLoader())) {
            return urlClassLoader.loadClass(className);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
