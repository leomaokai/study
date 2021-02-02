package com.kai;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kai.mapper.UserMapper;
import com.kai.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class MybatisPlusApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void test01(){

        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    void testInsert(){
        User user = new User();
        user.setName("hahaha");
        user.setAge(10);
        userMapper.insert(user);
        test01();
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setName("kai777");
        user.setAge(10);
        user.setId(6L);
        userMapper.updateById(user);
    }

    @Test
    public void testVersion(){

        // 乐观锁需要先查询得到此时的oldVersion
        // 更新时会判断version是否和oldVersion相等,只有相等才能更新成功
        // 更新成功version会加1

        // SELECT id,name,age,version FROM user WHERE id=?
        // UPDATE user SET name=?, age=? WHERE id=? AND version=?
        User user1 = userMapper.selectById(7); // version=1
        user1.setName("kai88888");
        user1.setEmail("1111@qq.com");

        User user2=userMapper.selectById(7); // version=1
        user2.setName("leo88888");
        // 执行成功,version+1
        userMapper.updateById(user2); // version=2

        // 执行失败
        userMapper.updateById(user1); // 2!=1 更新失败
    }

    @Test
    public void testSelect(){
        System.out.println("---------------");
        System.out.println("根据id查询一个用户");
        User user1 = userMapper.selectById(1);
        System.out.println(user1);
        System.out.println("---------------");
        System.out.println("根据ids批量查询用户");
        List<User> userList1 = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        userList1.forEach(System.out::println);
        System.out.println("---------------");
        System.out.println("查询全部用户");
        List<User> userList2 = userMapper.selectList(null);
        userList2.forEach(System.out::println);
        System.out.println("---------------");
        System.out.println("根据map条件查询");
        Map<String,Object> map=new HashMap<>();
        map.put("name","hahaha");
        List<User> userList3 = userMapper.selectByMap(map);
        userList3.forEach(System.out::println);
        System.out.println("---------------");
    }

    @Test
    public void testPage(){
        // 参数:当前页,页面大小
        Page<User> userPage = new Page<>(2,3);
        // 查询
        userMapper.selectPage(userPage, null);
        // 从userPage中得到结果
        List<User> records = userPage.getRecords();
        records.forEach(System.out::println);
    }

    @Test
    public void testLogicDelete(){
        // 逻辑删除
        userMapper.deleteById(14);
        // 执行的sql: UPDATE user SET deleted=1 WHERE id=? AND deleted=0
        // 查询已经逻辑删除的用户
        userMapper.selectById(14); // 没有查到
        // SELECT id,deleted FROM user WHERE id=? AND deleted=0
    }
}
