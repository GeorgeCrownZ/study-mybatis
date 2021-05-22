package com.zc.dao;

import com.zc.pojo.User;
import com.zc.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {

    static Logger logger = Logger.getLogger(UserDaoTest.class);

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
    public void testLog4j() {
        logger.info("info：进入了testLog4j");
        logger.debug("debug：进入了testLog4j");
        logger.error("error：进入了testLog4j");
    }

    @Test
    public void getUserByLimit() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("startIndex",0);
        map.put("pageSize",2);
        List<User> userList = userMapper.getUserByLimit(map);

        for(User user : userList) {
            logger.info(user);
        }
    }

    @Test
    public void getUserByRowBounds() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // RowBounds 实现
        RowBounds rowBounds = new RowBounds(1, 2);

        //通过Java代码层面实现分页
        List<User> userList = sqlSession.selectList("com.zc.dao.UserMapper.getUserByRowBounds",null,rowBounds);

        for(User user : userList) {
            logger.info(user);
        }

        sqlSession.close();
    }
}
