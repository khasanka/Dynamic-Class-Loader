package com.example.DynamicClassLoader.Controller;


import com.example.DynamicClassLoader.Servce.LoaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@RestController
public class ClassLoadController {

    @Autowired
    private LoaderService loaderService;

    @Value("${app.load.path}")
    private String classPath;

    @GetMapping("/loadClass/{className}")
    public ResponseEntity loadClass(@PathVariable String className) throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String outMsg = HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();
        System.out.println("===============> " + classPath+className);

        if(loaderService.loadClass(classPath, className) ){
            outMsg = HttpStatus.CREATED.getReasonPhrase();
        }

        return new ResponseEntity<String>(outMsg, HttpStatus.OK);
    }

}
