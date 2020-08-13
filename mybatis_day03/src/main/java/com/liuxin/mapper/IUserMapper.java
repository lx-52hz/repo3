package com.liuxin.mapper;

import com.liuxin.domain.User;
import com.liuxin.vo.RoleVo;
import com.liuxin.vo.UserVo;

import java.util.List;

public interface IUserMapper {

    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();


    /**
     * 根据条件查询
     * @param user
     * @return
     */
    List<User> findUserByCondition(User user);

    List<UserVo> findAllUserAndAccount();

    /**
     * 通过用户低查询数据
     * @param uid
     * @return
     */
    UserVo findUserByUid(Integer uid);

    /**
     * 一对多的关系
     * 查询所有用户及其对应的角色信息
     * @return
     */
    List<UserVo> findUserAndRole();




}
