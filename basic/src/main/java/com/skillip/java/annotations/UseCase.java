//: annotations/UseCase.java
package com.skillip.java.annotations; /* Added by Eclipse.py */
import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UseCase {
  public int id();
  public String description() default "no description";
} ///:~
