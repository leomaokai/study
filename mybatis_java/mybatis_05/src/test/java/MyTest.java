import com.kai.mapper.BlogMapper;
import com.kai.pojo.Blog;
import com.kai.utils.IDUtils;
import com.kai.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

public class MyTest {
    
    @Test
    public void test01(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IDUtils.getID());
        blog.setTitle("Mybatis hello");
        blog.setAuthor("kai");
        blog.setCreateTime(new Date());
        blog.setViews(100);

        mapper.addBlog(blog);

        blog.setId(IDUtils.getID());
        blog.setTitle("Spring hello");
        mapper.addBlog(blog);
        blog.setId(IDUtils.getID());
        blog.setTitle("C++ hello");
        mapper.addBlog(blog);
        blog.setId(IDUtils.getID());
        blog.setTitle("Java hello");
        mapper.addBlog(blog);
        sqlSession.close();
    }

    @Test
    public void test02(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap hashMap = new HashMap();
        //hashMap.put("title","Java hello");
        hashMap.put("author","kai");
        List<Blog> blogs = mapper.listIfBlogs(hashMap);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void test03(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap hashMap = new HashMap();
        //hashMap.put("title","Java hello");
        hashMap.put("author","kai");
        hashMap.put("views",100);
        List<Blog> blogs = mapper.listChooseBlogs(hashMap);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void test04(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap hashMap = new HashMap();
        hashMap.put("id","f2e42c665f14434f9bbc285c938f5a98");
        hashMap.put("title","Linux hello");
        hashMap.put("author","leo2");
        mapper.updateBlog(hashMap);

        sqlSession.close();
    }

    @Test
    public void test05(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap hashMap = new HashMap();
        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        hashMap.put("ids",ids);
        List<Blog> blogs = mapper.listForeachBlogs(hashMap);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }
}
