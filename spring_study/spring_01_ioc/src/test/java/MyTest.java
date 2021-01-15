import com.kai.dao.UserDaoImpl;
import com.kai.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    @Test
    public void test01(){

        //用户实际调用业务层,Dao层不需要接触
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDao(new UserDaoImpl());
        userService.getUser();
    }

    @Test
    public void test02(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserServiceImpl userServiceimpl = (UserServiceImpl) context.getBean("userServiceimpl");
        userServiceimpl.getUser();

    }
}
