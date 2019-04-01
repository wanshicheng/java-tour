package com.skillip.lambda;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/*
 *
 */
public class DemoTest {
  private static List<Person> persons = new ArrayList<Person>();


  static {
      persons.add(new Person("aa", 1, 21, 2000));
      persons.add(new Person("bb", 0, 15, 2000));
      persons.add(new Person("cc", 1, 41, 10000));
      persons.add(new Person("dd", 0, 20, 8000));
      persons.add(new Person("ee", 1, 29, 9000));
  }

  //
  @Test
  public void test1() {
      List<Person> results = new ArrayList<Person>();
      for(Person p : persons) {
          if(p.getAge() > 20) {
              results.add(p);
          }
      }

      for(Person p : results) {
          System.out.println(p.toString());
      }
  }

}
