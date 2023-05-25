package com.example.bean;

import com.example.annotation.B;
import com.example.annotation.Di;
import com.example.service.UserService;

import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class AnnotationAppContext implements AppContext{
    public static final String rootPath = "/Users/colin/workspace/spring6-learn/custom-ioc/target/classes/";
    private Map<Class, Object> beanMap = new HashMap<>();

    @Override
    public Object getBean(Class clazz) {
        return beanMap.get(clazz);
    }

    public AnnotationAppContext(String basePackage)  {

        try {
            String packagePath = basePackage.replaceAll("\\.", "/");
            Enumeration<URL> resources = Thread.currentThread().getContextClassLoader().getResources(packagePath);
            while (resources.hasMoreElements()){
                URL url = resources.nextElement();
                String filePath = URLDecoder.decode(url.getFile(), "utf-8");
                loadBean(new File(filePath));
            }

            loadDi();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void loadDi() {
        beanMap.forEach((key, value) -> {
            Field[] fields = value.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.getAnnotation(Di.class) != null) {
                    field.setAccessible(true);
                    try {
                        field.set(value, beanMap.get(field.getType()));
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
    }

    private void loadBean(File file) throws Exception {
        if (file.isDirectory()){
            File[] childFiles = file.listFiles();

            if (childFiles == null || childFiles.length == 0) {
                return;
            }

            for (File childFile : childFiles) {
                loadBean(childFile);
            }
        }
        else {
            String pathWithClass = file.getAbsolutePath().substring(rootPath.length());
            if (pathWithClass.contains(".class")){
                String fullName = pathWithClass.replaceAll("/", ".").replace(".class", "");

                Class<?> clazz = Class.forName(fullName);
                if (!clazz.isInterface()) {
                    if (clazz.getAnnotation(B.class) != null) {
                        Object instance = clazz.getConstructor().newInstance();

                        if (clazz.getInterfaces().length>0){
                            beanMap.put(clazz.getInterfaces()[0], instance);
                        }
                        else {
                            beanMap.put(clazz, instance);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args)  {
        AppContext appContext = new AnnotationAppContext("com.example");

        UserService service = (UserService)appContext.getBean(UserService.class);

        System.out.println(service);
        service.add();
    }
}
