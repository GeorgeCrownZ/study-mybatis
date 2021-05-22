import com.zc.pojo.User;
import com.zc.dao.UserMapper;
import com.zc.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {

    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.queryUserById(1);
        System.out.println(user);

        //  User user1 = new User(2,"ddd222","222111333");
        sqlSession.clearCache();    //手动清理缓存

        System.out.println("-------------------------------------");

        User user2 = mapper.queryUserById(1);
        System.out.println(user2);

        sqlSession.close();
    }

    @Test
    public void testCache() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SqlSession sqlSession2 = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUserById(1);
        System.out.println(user);
        sqlSession.close();

        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        User user2 = mapper2.queryUserById(1);
        System.out.println(user2);

        System.out.println(user == user2);

        sqlSession2.close();
    }
}
