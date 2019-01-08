package com.example.dynamicdatasource.dao;

import com.example.dynamicdatasource.domain.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * SysUserMapper
 *
 * @author pangenshan
 * @version 1.0
 * @date 2019/1/8 9:26
 */
@Mapper
public interface SysUserMapper {
    /**
     * 通过id查找信息
     *
     * @param id id
     * @return SysUser
     */
    @Select("select id,name from sys_user where id=#{id}")
    SysUser findById(@Param("id") long id);
}