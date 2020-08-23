package com.bigoofone;

import java.nio.file.Path;

abstract class Operation {

  abstract void perform(Path source, Path target);
}
