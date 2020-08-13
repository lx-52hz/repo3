package com.liuxin.mapper;

import com.liuxin.vo.RoleVo;

import java.util.List;

public interface IRoleMapper {

    List<RoleVo> findRoleAndUser();
}
