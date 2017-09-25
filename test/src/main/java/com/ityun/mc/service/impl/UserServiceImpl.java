package com.ityun.mc.service.impl;

import com.ityun.mc.dao.UserMapper;
import com.ityun.mc.model.User;
import com.ityun.mc.service.UserService;
import com.ityun.mc.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2017/09/25.
 */
@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {
    @Resource
    private UserMapper userMapper;

}
