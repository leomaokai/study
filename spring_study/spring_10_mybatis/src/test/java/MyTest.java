import com.kai.mapper.UserMapper;
import com.kai.mapper.UserMapperImpl;
import com.kai.pojo.User;
import com.kai.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {

    @Test
    public void test01(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.listUser();
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void test02(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-mapper.xml");
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
        for (User user : userMapper.listUser()) {
            System.out.println(user);
        }
    }

    @Test
    public void test03(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-mapper.xml");
        UserMapper userMapper = context.getBean("userMapper2", UserMapper.class);
        for (User user : userMapper.listUser()) {
            System.out.println(user);
        }
    }
}
