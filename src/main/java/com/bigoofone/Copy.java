package com.bigoofone;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

class Copy extends Operation {
  @Override
  void perform(Path source, Path target) {
    try {
      Files.copy(source, target, REPLACE_EXISTING);
      System.out.println("File Copied Successfully\n");
    } catch (IOException e) {
      System.out.println("Exception occurred while copying file\n");
    }
  }
}
