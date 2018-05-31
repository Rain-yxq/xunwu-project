package cn.rain.entity;

import cn.rain.ApplicationTests;
import cn.rain.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * description:
 *
 * @author 任伟
 * @date 2018/5/30 15:02
 */
public class UserRepositoryTest extends ApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindOne(){
        User user = userRepository.findOne(1L);
        Assert.assertEquals("wali", user.getName());
    }
}
