package com.daytick.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.daytick.mybatisplus.mapper.auto.UserMapper;
import com.daytick.mybatisplus.model.auto.User;
import com.daytick.mybatisplus.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ly
 * @since 2021-01-04
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
