package com.springmvcstudy.ch3;

public interface UserDao {

    int deleteUser(String id);

    User selectUser(String id);

    int updateUser(User user);

    int insertUser(User user);

    void deleteAll() throws Exception;
}
