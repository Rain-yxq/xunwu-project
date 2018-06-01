package cn.rain.base;

import cn.rain.entity.User;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * description: 从spring security框架中获取已登录的用户及相关信息。
 * @author 任伟
 * @date 2018/6/1 14:50
 */
public class LoginUserUtil {
    public static User load(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof User){
            return (User)principal;
        }
        return null;
    }

    public static Long getLoginUserId(){
        User user = load();
        if (user == null){
            return -1L;
        }
        return user.getId();
    }
}
