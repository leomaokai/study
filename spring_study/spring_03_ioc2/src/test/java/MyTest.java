import com.kai.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationConfig.xml");
        User user = (User) context.getBean("user5");
        System.out.println(user.toString());
        User user2 = (User) context.getBean("user2");
        System.out.println(user2.toString());
        User user3 = (User) context.getBean("user3");
        System.out.println(user3.toString());
        User user4 = (User) context.getBean("user4");
        System.out.println(user4.toString());

        User user8 = (User) context.getBean("user8");
        System.out.println(user8.toString());
    }
}
