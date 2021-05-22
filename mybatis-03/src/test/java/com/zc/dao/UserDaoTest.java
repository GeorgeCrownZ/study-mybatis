package com.zc.dao;

import com.zc.pojo.User;
import com.zc.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {
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
}
