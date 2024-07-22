package com.example.demomybatisplus.demos.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demomybatisplus.demos.dal.User;
import com.example.demomybatisplus.demos.mapper.UserMapper;
import com.example.demomybatisplus.demos.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @className: UserServiceImpl
 * @author: Scarlet
 * @date: 2024/7/19
 **/

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
