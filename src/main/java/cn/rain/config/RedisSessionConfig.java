package cn.rain.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * description: session会话保存
 * 这里的主要作用是：
 * 由于现在我们的session是保存在内存中，因此每次我们程序重启或关闭，都会因为内存的释放导致session失效。
 * 因此为了便于开发时每次重启不用重新登录管理后台，我们使用redis来管理我们的session。
 *
 * @author 任伟
 * @date 2018/6/1 16:21
 */
//@Configuration
//@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 86400)
public class RedisSessionConfig {
    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory){
        return new StringRedisTemplate(factory);
    }
}
