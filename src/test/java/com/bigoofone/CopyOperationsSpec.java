package com.bigoofone;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class CopyOperationsSpec {

  @BeforeClass
  public static void set() {
    CommonSpec.setup(CommonSpec.sourceDirForCopyOperation);
  }

  @AfterClass
  public static void clean() {
    CommonSpec.cleanUp(CommonSpec.sourceDirForCopyOperation);
  }

  //test to check copy operation when source folder value is given and the input file has relative paths of file to move
  @Test
  public void testWithSourceFolderAndRelativeFileNames() {
    String[] args = {Constants.COPY_OPERATION_ARG,
        "-s", CommonSpec.sourceDirForCopyOperation,
        "-d", CommonSpec.destinationDir,
        "-f", CommonSpec.inputFile
    };
    CommonSpec.writeRelativePathNames(CommonSpec.sourceDirForCopyOperation);
    CutPasteUtility.main(args);
    assert CommonSpec.exists();
  }

  @Test
  public void testWithSourceFolderAndAbsoluteFileNames() {
    String[] args = {Constants.COPY_OPERATION_ARG,
        "-s", CommonSpec.sourceDirForCopyOperation,
        "-d", CommonSpec.destinationDir,
        "-f", CommonSpec.inputFile
    };
    CommonSpec.writeAbsolutePathNames(CommonSpec.sourceDirForCopyOperation);
    CutPasteUtility.main(args);
    assert CommonSpec.exists();
  }

  @Test
  public void testWithoutSourceFolderAndAbsoluteFileNames() {
    String[] args = {Constants.COPY_OPERATION_ARG,
        "-d", CommonSpec.destinationDir,
        "-f", CommonSpec.inputFile
    };
    CommonSpec.writeAbsolutePathNames(CommonSpec.sourceDirForCopyOperation);
    CutPasteUtility.main(args);
    assert CommonSpec.exists();
  }
}
