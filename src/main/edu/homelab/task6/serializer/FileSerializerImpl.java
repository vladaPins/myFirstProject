package edu.homelab.task6.serializer;

import edu.homelab.task6.utils.ReflectionUtils;

import java.io.*;

public class FileSerializerImpl implements FileSerializer {

  @Override
  public String serialize(Object object) throws IllegalAccessException {
    if (object == null) {
      return null;
    }
    String view = "";
    String className = ReflectionUtils.getClassName(object);
    String objectFields = ReflectionUtils.getObjectFields(object);

    view += className + objectFields;
    return view;
  }
}
