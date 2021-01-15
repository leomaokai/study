import com.kai.service.UserServiceImpl;
import com.kai.service.UserServiceInterface;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //动态代理代理的是接口
        UserServiceInterface userService = context.getBean("userService", UserServiceInterface.class);
        userService.add();
        userService.delete();
    }

    @Test
    public void test02(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //动态代理代理的是接口
        UserServiceInterface userService = context.getBean("userService", UserServiceInterface.class);
        userService.add();
        userService.delete();
    }
}
