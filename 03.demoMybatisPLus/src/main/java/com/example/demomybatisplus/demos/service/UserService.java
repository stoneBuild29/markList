package com.example.demomybatisplus.demos.service;

/**
 * @className: UserService
 * @author: Scarlet
 * @date: 2024/7/19
 **/
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demomybatisplus.demos.dal.User;
import com.example.demomybatisplus.demos.mapper.UserMapper;
import org.springframework.stereotype.Service;

public interface UserService extends IService<User> {
}
