package com.bigoofone;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Contains Utility Methods Common to all tests
 */
class CommonSpec {
  private static String resourcesPath = "src/test/resources";
  static String sourceDirForCopyOperation = resourcesPath + "/CopyOperation";
  static String sourceDirForCutOperation = resourcesPath + "/CutOperation";
  static String destinationDir = resourcesPath + "/destination";
  static String inputFile = resourcesPath + "/inputFile.txt";

  static void setup(String dir) {
    createDir(destinationDir);
    createDir(dir);
    createFiles(dir);
  }

  static void cleanUp(String dir) {

    File file = new File(destinationDir);
    System.out.println(deleteDirectory(file));
    file = new File(dir);
    System.out.println(deleteDirectory(file));
    file = new File(inputFile);
    System.out.println(deleteDirectory(file));
  }

  private static boolean deleteDirectory(File directoryToBeDeleted) {
    File[] allContents = directoryToBeDeleted.listFiles();
    if (allContents != null) {
      for (File file : allContents) {
        deleteDirectory(file);
      }
    }
    return directoryToBeDeleted.delete();
  }

  private static void createFiles(String dirPath) {
    for (File file : getFileNamesForOperation(dirPath)) {
      try {
        file.createNewFile();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  private static List<File> getFileNamesForOperation(String dirPath) {
    List<File> files = new ArrayList<File>();
    for (int i = 0; i < 3; i++) {
      files.add(new File(dirPath + "/file" + i + ".txt"));
    }
    return files;
  }

  static void writeRelativePathNames(String dir) {
    List<String> fileNamesForOperation = new ArrayList<>();
    getFileNamesForOperation(dir).forEach(f ->
        fileNamesForOperation.add(f.getName())
    );
    writeToFile(String.join("\n", fileNamesForOperation));
  }

  static void writeAbsolutePathNames(String dir) {
    List<String> fileNamesForOperation = new ArrayList<>();
    getFileNamesForOperation(dir).forEach(f ->
        fileNamesForOperation.add(f.getAbsolutePath())
    );
    writeToFile(String.join("\n", fileNamesForOperation));
  }

  private static void writeToFile(String text) {
    try {
      FileWriter myWriter = new FileWriter(inputFile);
      myWriter.write(text);
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  private static void createDir(String dir) {
    File f = new File(dir);
    f.mkdirs();
  }

  static boolean exists() {
    for (int i = 0; i < 3; i++) {
      File file = new File(destinationDir + "/file" + i + ".txt");
      assert file.exists() : file + " File does not exist";
    }
    return true;
  }
}
