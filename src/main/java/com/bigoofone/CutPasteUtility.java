package com.bigoofone;

import org.apache.commons.cli.*;

import java.util.Arrays;

public class CutPasteUtility {

  public static void main(String[] args) {

    Options options = new Options();
    options.addOption("s", "source", true, "Source Folder")
        .addOption("d", "destination", true, "Destination Folder")
        .addOption("f", "File", true, "Path of file containing file Names to copy/cut")
        .addOption("cp", "Copy Operation", false, "cp for copy Operation")
        .addOption("mv", "Move Operation", false, "mv for move Operation");

    CommandLineParser parser = new DefaultParser();

    try {
      //parse the options passed as command line arguments
      CommandLine cmd = parser.parse(options, args);
      if (cmd.getOptions().length < 2) {
        System.out.println("Insufficient Arguments");
        printHelp(options);
        return;
      }
      String source = cmd.getOptionValue("s");
      String destination = cmd.getOptionValue("d");
      String file = cmd.getOptionValue("f");
      String operationName;
      operationName = getOperationName(cmd);
      CutCopyOperations.perform(source, destination, operationName, file);
    } catch (ParseException e) {
      System.out.println(
          "ERROR: Unable to parse command-line arguments "
              + Arrays.toString(args) + " due to: "
              + e);
    }
  }

  private static void printHelp(Options options) {
    HelpFormatter formatter = new HelpFormatter();
    formatter.printHelp("java -jar CutPasteUtility.jar", options);
  }

  private static String getOperationName(CommandLine cmd) {
    assert !(cmd.hasOption("cp") && cmd.hasOption("mv")) :
        "Please choose only 1 option out of \"cp\" and \"mv\"";
    if (cmd.hasOption("cp")) {
      return "cp";
    } else if (cmd.hasOption("mv")) {
      return "mv";
    }
    throw new IllegalArgumentException("Please choose one operation out of \"cp\" and \"mv\"");
  }

}
