package com.bigoofone;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

class Move extends Operation {

  @Override
  void perform(Path source, Path target) {
    try {
      Files.move(source, target);
      System.out.println("File Renamed and Moved Successfully\n");
    } catch (IOException e) {
      System.out.println("Exception occurred while moving file\n");
    }
  }
}
