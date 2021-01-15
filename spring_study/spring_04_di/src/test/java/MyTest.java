import com.kai.pojo.Student;
import com.kai.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Student student = (Student) context.getBean("student");
        System.out.println(student.toString());
//        Student(name=kai, address=Address(address=xuzhou),
//              books=[红楼梦, 西游记, 三国演义],
//              hobbys=[code, play, sleep],
//              card={01=school card, 02=bank card},
//              games=[lol, dnf],
//              info={sex=man, id=11111, age=20},
//              wife=null)
    }

    @Test
    public void test02(){
        ApplicationContext context = new ClassPathXmlApplicationContext("userbeans.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user.toString());
        User user2 = context.getBean("user2", User.class);
        System.out.println(user2);
    }

    @Test
    public void test03(){
        ApplicationContext context = new ClassPathXmlApplicationContext("userbeans.xml");
        User user = context.getBean("user", User.class);
        User user2 = context.getBean("user", User.class);
        System.out.println(user==user2);
    }

}
