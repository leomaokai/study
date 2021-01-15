import com.kai.config.MyConfig;
import com.kai.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyTest {

    @Test
    public void test01(){
        //如果完全使用了配置类方式去做,可以通过AnnotationConfig来获取容器
        ApplicationContext context= new AnnotationConfigApplicationContext(MyConfig.class);
        User getUser = context.getBean("testconfig", User.class);
        System.out.println(getUser);
    }
}
