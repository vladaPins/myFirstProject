package edu.homelab.task6.utils;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Map;

public class ReflectionUtils {

    public static String getClassName(Object object) {
        Class clazz = object.getClass();
        String className = clazz.getName();
        return ("\"" + "className" + "\"" + ": " + "\"" + className + "\"" + "\n");
    }

    public static String getObjectFields(Object object) throws IllegalAccessException {
        StringBuilder fieldName = new StringBuilder();
        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Object value = field.get(object);
            fieldName.append("\"").append(field.getName()).append("\"").append(": ");
            if (value != null) {
                // Если поле является строкой, используем String.valueOf()
                if (field.getType().equals(String.class)) {
                    fieldName.append("\"").append(value).append("\"");
                } else {
                    fieldName.append(value);
                }
            } else {
                fieldName.append("null");
            }
            fieldName.append("\n");
        }
        return fieldName.toString();
    }


    public static void updateFieldIfExists(Object obj, Map<String, Object> fieldsAndValues) throws NoSuchFieldException, IllegalAccessException {
        Class<?> clazz = obj.getClass();
        for (Map.Entry<String, Object> entry : fieldsAndValues.entrySet()) {

            String fieldName = entry.getKey();
            if (!fieldName.equals("className")) {
                Object newValue = entry.getValue();
                Field field = clazz.getDeclaredField(fieldName);

                field.setAccessible(true);
                Class<?> fieldType = field.getType();
                if (fieldType.isInstance(newValue)) {
                    field.set(obj,newValue);
                }


            }
        }
    }


    public static String showClassMethods(Object object) {
        String nameMethods = "";
        Class clazz = object.getClass();
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            method.setAccessible(true);
            nameMethods += "Method: " + method.getName() + "\n";
        }
        return nameMethods;
    }

    public static void createNewFieldsAndValues(Object
                                                        object, ArrayList<String> fieldNames, ArrayList<Object> fieldValues) throws
            IllegalAccessException, NoSuchFieldException {
        Class clazz = object.getClass();
        for (String name : fieldNames) {
            Field newField = clazz.getDeclaredField(name);
            newField.setAccessible(true);
            for (Object value : fieldValues) {
                newField.set(object, value);
            }
        }
    }

    public static Object createNewObject(String className) {
        Object deserializedObject = null;
        try {
            Class<?> myClass = Class.forName(className);
            MethodHandles.Lookup lookup = MethodHandles.lookup();
            MethodHandle constructor = lookup.findConstructor(myClass, MethodType.methodType(void.class));
            deserializedObject = constructor.invoke();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return deserializedObject;
    }
}

