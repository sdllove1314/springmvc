import com.sdl.dao.UserDao;
import com.sdl.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.Resource;

/**
 * test
 */
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserTest {
    @Resource
    private UserDao userDao;
    @Test
    public void testF(){
        User user  = userDao.findAll(1001);
        System.out.println(user);
    }
}
