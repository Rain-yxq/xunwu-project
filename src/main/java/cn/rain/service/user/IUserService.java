package cn.rain.service.user;

import cn.rain.base.ServiceResult;
import cn.rain.entity.User;
import cn.rain.web.dto.UserDTO;

/**
 * description: 用户服务
 * @author 任伟
 * @date 2018/5/31 11:17
 */
public interface IUserService {
    User findUserByName(String userName);

    ServiceResult<UserDTO> findById(Long adminId);
}
