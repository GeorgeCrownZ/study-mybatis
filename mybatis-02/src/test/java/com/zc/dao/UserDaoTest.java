package com.zc.dao;

import com.zc.pojo.User;
import com.zc.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {

    @Test
    public void test() {

        //  第一步：获得 SqlSession 对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try{
            //  方式一：getMapper
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = userMapper.getUserList();
            for(User user:userList){
                System.out.println(user);
            }

            //  方式二：不推荐使用
            //List<User> userList = sqlSession.selectList("com.zc.dao.UserDao.getUserList");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void getUserById() {

        //  第一步：获得 SqlSession 对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try{
            //  方式一：getMapper
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.getUserById(1);
            if(user != null) {
                System.out.println(user);
            }

            //  方式二：不推荐使用
            //List<User> userList = sqlSession.selectList("com.zc.dao.UserDao.getUserList");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void addUser() {

        //  第一步：获得 SqlSession 对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try{
            //  方式一：getMapper
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = new User(4,"哈哈","123123");
            userMapper.addUser(user);
            sqlSession.commit();

            //  方式二：不推荐使用
            //List<User> userList = sqlSession.selectList("com.zc.dao.UserDao.getUserList");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void updateUserById() {

        //  第一步：获得 SqlSession 对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try{
            //  方式一：getMapper
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = new User(4,"呵呵","321321");
            userMapper.updateUserById(user);
            sqlSession.commit();

            //  方式二：不推荐使用
            //List<User> userList = sqlSession.selectList("com.zc.dao.UserDao.getUserList");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void deleteUserById() {

        //  第一步：获得 SqlSession 对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try{
            //  方式一：getMapper
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.deleteUserById(4);
            sqlSession.commit();

            //  方式二：不推荐使用
            //List<User> userList = sqlSession.selectList("com.zc.dao.UserDao.getUserList");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }
}
