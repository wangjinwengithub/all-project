package com.daka.core.dao;

import com.daka.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Delete("delete from t_user where id=#{id}")
    int deleteByPrimaryKey(@Param("id") Integer id);

    @Insert("insert into t_user (name,age) value (#{name},#{age})")
    int insert(@Param("name") String name,@Param("age") Integer age);

    @Select("select * from t_user where id=#{id}")
    User selectByPrimaryKey(@Param("id") Integer id);

}