package cn.rain.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import cn.rain.entity.Role;

/**
 * 角色数据的DAO
 * Created by 任伟.
 */
public interface RoleRepository extends CrudRepository<Role, Long> {
    List<Role> findRolesByUserId(Long userId);
}
