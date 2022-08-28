package cn.xiit.dao;

import cn.xiit.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUserList();

    User getUserById(int id);

    int addUser(User user);

    int editUser(User user);
    int deleteUser(int id);

    int addUser2(Map<String, Object> map);
    List<User> getUserLike(String value);
}
