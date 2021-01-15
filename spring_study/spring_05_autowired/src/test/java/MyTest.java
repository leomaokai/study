import com.kai.pojo.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Person person = context.getBean("person", Person.class);
        person.getCat().shout();
        person.getDog().shout();
    }

    @Test
    public void test02(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Person person = context.getBean("person2", Person.class);
        person.getCat().shout();
        person.getDog().shout();
    }

    @Test
    public void test03(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Person person = context.getBean("person3", Person.class);
        person.getCat().shout();
        person.getDog().shout();
    }
}
