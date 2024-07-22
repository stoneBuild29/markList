package com.example.demomybatisplus.demos.mapper;

/**
 * @className: UserMapper
 * @author: Scarlet
 * @date: 2024/7/19
 **/
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demomybatisplus.demos.dal.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("SELECT * FROM user WHERE age > #{age}")
    List<User> selectByAge(@Param("age") int age);
}
