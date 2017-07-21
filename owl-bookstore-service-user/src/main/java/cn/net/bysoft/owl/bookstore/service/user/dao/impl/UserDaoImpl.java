package cn.net.bysoft.owl.bookstore.service.user.dao.impl;

import org.springframework.stereotype.Component;

import cn.net.bysoft.owl.bookstore.common.core.dao.BaseDaoImpl;
import cn.net.bysoft.owl.bookstore.facade.user.entity.User;
import cn.net.bysoft.owl.bookstore.service.user.dao.UserDao;

@Component("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

}
