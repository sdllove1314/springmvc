import com.sdl.service.UserService;
import com.sdl.service.impl.UserServiceImpl;

import javax.annotation.Resource;

public class Test {
    @Resource
    UserService a = null;
    @org.junit.jupiter.api.Test
    public void testmy(){
        a.findAll(1001);
    }
}
