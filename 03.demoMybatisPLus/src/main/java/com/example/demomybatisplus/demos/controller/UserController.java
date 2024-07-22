package com.example.demomybatisplus.demos.controller;

/**
 * @className: UserController
 * @author: Scarlet
 * @date: 2024/7/19
 **/

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demomybatisplus.demos.dal.LambdaQueryWrapperX;
import com.example.demomybatisplus.demos.dal.User;
import com.example.demomybatisplus.demos.mapper.UserMapper;
import com.example.demomybatisplus.demos.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Api(tags = "用户管理")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/add")
    @ApiOperation(value = "添加用户", notes = "添加一个新用户")
    public boolean add(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "删除用户", notes = "根据用户ID删除用户")
    public boolean delete(@PathVariable Long id) {
        return userService.removeById(id);
    }

    @PutMapping("/update")
    @ApiOperation(value = "更新用户信息", notes = "根据用户ID更新用户信息")
    public boolean update(@RequestBody User user) {
        return userService.updateById(user);
    }

    @GetMapping("/list")
    @ApiOperation(value = "获取用户列表", notes = "返回所有用户的列表")
    public List<User> list() {
        return userService.list();
    }

    @GetMapping("/page")
    @ApiOperation(value = "分页查询", notes = "分页查询")
    public Page<User> page(@RequestParam int current, @RequestParam int size) {
        Page<User> page = new Page<>(current, size);
        return userService.page(page);
    }
    @GetMapping("/findByName")
    @ApiOperation(value = "根据用户姓名查找用户", notes = "根据用户姓名查找用户")
    public List<User> findByName(@RequestParam String name) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", name);
        return userService.list(queryWrapper);
    }

    @GetMapping("/findByAge")
    @ApiOperation(value = "根据用户年龄查找用户", notes = "根据用户年龄查找用户")
    public List<User> findByAge(@RequestParam int age) {
        return userMapper.selectByAge(age);
    }

    @GetMapping("/pageWithConditions")
    @ApiOperation(value = "分页条件查询", notes = "根据条件进行分页查询")
    public Page<User> pageWithConditions(@RequestParam int current, @RequestParam int size,
                                         @RequestParam(required = false) String name,
                                         @RequestParam(required = false) Integer age,
                                         @RequestParam(required = false) String email) {
        LambdaQueryWrapperX<User> queryWrapper = new LambdaQueryWrapperX<>();
        queryWrapper.likeIfPresent(User::getName, name)
                .eqIfPresent(User::getAge, age)
                .likeIfPresent(User::getEmail, email);
        Page<User> page = new Page<>(current, size);
        return userService.page(page, queryWrapper);
    }

}
