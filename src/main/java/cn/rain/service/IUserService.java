package cn.rain.service;

import cn.rain.entity.User;

/**
 * description: 用户服务
 * @author 任伟
 * @date 2018/5/31 11:17
 */
public interface IUserService {
    User findUserByName(String userName);
}
