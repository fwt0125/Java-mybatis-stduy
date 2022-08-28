package cn.xiit.dao;

import cn.xiit.pojo.User;
import cn.xiit.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class UserMapperTest {


    private SqlSession sqlSession = MybatisUtils.getSqlSession();
    private UserMapper userMapper = sqlSession.getMapper(UserMapper.class);


    @Test
    public void test(){
        User userById = userMapper.getUserById(1);
        System.out.println(userById);

        List<User> userList = userMapper.getUserList();

        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void add(){
        int fff = userMapper.addUser(new User(2, "fff", "456"));
        if (fff > 0) {
            System.out.println("插入成功");
        }
        sqlSession.commit();
    }

    @Test
    public void addMap(){
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("id", 2);
        stringObjectHashMap.put("username", "小小");
        stringObjectHashMap.put("password", "123444");

        int fff = userMapper.addUser2(stringObjectHashMap);
        if (fff > 0) {
            System.out.println("插入Map成功");
        }
        sqlSession.commit();
    }


    @Test
    public void edit(){
        int fff = userMapper.editUser(new User(2, "我是小方", "789"));
        if (fff > 0) {
            System.out.println("插入成功");
        }
        sqlSession.commit();
    }


    @Test
    public void delete(){
        int fff = userMapper.deleteUser(2);
        if (fff > 0) {
            System.out.println("插入成功");
        }
        sqlSession.commit();
    }

    @Test
    public void like(){
        List<User> userList = userMapper.getUserLike("%小%");
        for (User user : userList) {
            System.out.println(user);
        }

    }
}
