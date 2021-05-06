//: annotations/ExtractInterface.java
// APT-based annotation processing.
package com.skillip.java.annotations;
import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface ExtractInterface {
  String value();
}
