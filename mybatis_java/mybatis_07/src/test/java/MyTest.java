import com.kai.mapper.MyuserMapper;
import com.kai.pojo.Myuser;
import com.kai.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {

    @Test
    public void test01(){
        SqlSession sqlSession1 = MybatisUtils.getSqlSession();
        SqlSession sqlSession2 = MybatisUtils.getSqlSession();

        MyuserMapper mapper1 = sqlSession1.getMapper(MyuserMapper.class);
        Myuser userById1 = mapper1.getUserById(1);
        System.out.println(userById1);
        sqlSession1.close();

        System.out.println("======================");

        MyuserMapper mapper2 = sqlSession2.getMapper(MyuserMapper.class);
        Myuser userById2 = mapper2.getUserById(1);
        System.out.println(userById2);
        sqlSession2.close();

    }
}
