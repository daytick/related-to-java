package com.daytick.mybatisplus.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.daytick.mybatisplus.mapper.auto.UserMapper;
import com.daytick.mybatisplus.model.auto.User;
import com.daytick.mybatisplus.service.IUserService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author ly
 * @since 2021-01-04
 */
@RestController
public class UserController {

    private final IUserService userService;
    private final UserMapper userMapper;

    public UserController(IUserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        return userService.getById(id);
    }

    @GetMapping("/users")
    public Object getUsers(HttpServletRequest request) {
        int pageNo = Integer.parseInt(request.getParameter("pageNo"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        IPage<User> page = new Page<>(pageNo, pageSize);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.gt("age", 20);
        return userService.page(page, wrapper);
    }

    @Transactional(rollbackFor = Exception.class)
    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        userService.removeById(id);
        return "成功删除用户！";
    }

}
