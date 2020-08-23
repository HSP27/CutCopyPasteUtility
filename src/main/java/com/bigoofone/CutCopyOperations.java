package com.bigoofone;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class CutCopyOperations {

  static void perform(String source, String destination, String operation, String fileNames) {
    List<String> lines = getLines(fileNames);
    for (String filePath : lines) {
      if (filePath.isEmpty()) {
        continue;
      }
      String sourceFilePath = getSourceFilePath(source, filePath);
      String targetFilePath = destination + File.separator + filePath;
      System.out.println("Processing File : " + sourceFilePath);
      Operation op = OperationFactory.getOperation(operation);
      op.perform(Paths.get(sourceFilePath), Paths.get(targetFilePath));
    }
  }

  private static List<String> getLines(String fileName) {
    List<String> result = null;
    try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
      result = lines.collect(Collectors.toList());
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
    return result;
  }

  private static String getSourceFilePath(String source, String fileName) {
    File file = new File(fileName);
    if (file.isAbsolute() || source == null) {
      return fileName;
    }
    return source + File.separator + fileName;
  }
}
