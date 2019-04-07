
import java.util.ArrayList;
import java.util.List;

import com.skillip.lambda.demo.Person;
import com.skillip.lambda.demo.PersonInterface;
import org.junit.Test;

/*
 * 需求1：在Person集合中，需要年龄大于20
 * 需求2：在Person集合中，需要salary大于1800
 * 需求3：在Person集合中，需要性别为0
 */
public class DemoTest {
    private static List<Person> persons = new ArrayList<>();
    static {
        persons.add(new Person("aa", 1, 21, 2000));
        persons.add(new Person("bb", 0, 13, 2300));
        persons.add(new Person("cc", 1, 16, 4000));
        persons.add(new Person("dd", 1, 24, 1500));
        persons.add(new Person("ee", 0, 30, 2800));
        persons.add(new Person("ff", 1, 16, 8000));
        persons.add(new Person("gg", 1, 19, 1700));
    }

    @Test
    public void test6() {

    }
    @Test
    public void test5(){
        persons.stream().filter(x -> x.getSex()==0).forEach(System.out::println);
    }

    // 使用接口实现
    @Test
    public void test4() {
//		List<Person> results = getPersons(new PersonInterface() {
//			@Override
//			public boolean personCpr(Person p) {
//				// 需求1：年龄大于20
////				return p.getAge() > 20;
//
//				//需求2：salary>1800
//				return p.getSalary()>1800;
//			}
//		});
        List<Person> results = getPersons(p -> p.getSalary()>1800);

        for (Person person : results) {
            System.out.println(person);
        }
    }

    public List<Person> getPersons(PersonInterface pi) {
        List<Person> results = new ArrayList<>();
        for (Person p : persons) {
            if (pi.personCpr(p)) {
                results.add(p);
            }
        }
        return results;
    }

    // 需求1：在Person集合中，需要年龄大于20
    @Test
    public void test1() {
        List<Person> results = new ArrayList<>();
        for (Person p : persons) {
            if (p.getAge() > 20) {
                results.add(p);
            }
        }

        for (Person person : results) {
            System.out.println(person);
        }
    }

    // 需求2：在Person集合中，需要salary大于1800
    @Test
    public void test2() {
        List<Person> results = new ArrayList<>();
        for (Person p : persons) {
            if (p.getSalary() > 1800) {
                results.add(p);
            }
        }

        for (Person person : results) {
            System.out.println(person);
        }
    }

    // 需求3：在Person集合中，需要性别为0
    @Test
    public void test3() {
        List<Person> results = new ArrayList<>();
        for (Person p : persons) {
            if (p.getSex() == 0) {
                results.add(p);
            }
        }
        for (Person person : results) {
            System.out.println(person);
        }
    }
}
