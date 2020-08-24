package com.bigoofone;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class CutOperationSpec {

  @BeforeClass
  public static void set() {
    CommonSpec.setup(CommonSpec.sourceDirForCutOperation);
  }

  @AfterClass
  public static void clean() {
    CommonSpec.cleanUp(CommonSpec.sourceDirForCutOperation);
  }

  //test to check copy operation when source folder value is given and the input file has relative paths of file to move
  @Test
  public void testWithSourceFolderAndRelativeFileNames() {
    String[] args = {Constants.CUT_OPERATION_ARG,
        "-s", CommonSpec.sourceDirForCutOperation,
        "-d", CommonSpec.destinationDir,
        "-f", CommonSpec.inputFile
    };
    CommonSpec.writeRelativePathNames(CommonSpec.sourceDirForCutOperation);
    CutPasteUtility.main(args);
    assert CommonSpec.exists();
  }

  @Test
  public void testWithSourceFolderAndAbsoluteFileNames() {
    String[] args = {Constants.CUT_OPERATION_ARG,
        "-s", CommonSpec.sourceDirForCutOperation,
        "-d", CommonSpec.destinationDir,
        "-f", CommonSpec.inputFile
    };
    CommonSpec.writeAbsolutePathNames(CommonSpec.sourceDirForCutOperation);
    CutPasteUtility.main(args);
    assert CommonSpec.exists();
  }

  @Test
  public void testWithoutSourceFolderAndAbsoluteFileNames() {
    String[] args = {Constants.CUT_OPERATION_ARG,
        "-d", CommonSpec.destinationDir,
        "-f", CommonSpec.inputFile
    };
    CommonSpec.writeAbsolutePathNames(CommonSpec.sourceDirForCutOperation);
    CutPasteUtility.main(args);
    assert CommonSpec.exists();
  }
}

