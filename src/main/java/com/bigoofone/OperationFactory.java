package com.bigoofone;

public class OperationFactory {

  static Operation getOperation(String opName) {
    if (opName.equals("mv")) {
      return new Move();
    } else if (opName.equals("cp")) {
      return new Copy();
    }
    throw new IllegalArgumentException("Unknown Operation Type" + opName);
  }


}
