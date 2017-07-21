package cn.net.bysoft.owl.bookstore.service.user.biz;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.net.bysoft.owl.bookstore.facade.user.entity.User;
import cn.net.bysoft.owl.bookstore.facade.user.exception.EmailAlreadyExistsException;
import cn.net.bysoft.owl.bookstore.service.user.dao.UserDao;

@Component("userBiz")
public class UserBiz {

	@Autowired
	private UserDao userDao;

	public Boolean isExistsByEmail(String email) {
		Map<String, Object> param = new HashMap<>();
		param.put("email", email);
		long result = userDao.countByParam(param);
		if (result == 0) {
			throw new EmailAlreadyExistsException("邮箱已存在");
		}
		return true;
	}

	public Boolean signUp(User user) {
		long result = userDao.insert(user);
		if (result > 0) {
			return true;
		}
		return false;
	}

}
