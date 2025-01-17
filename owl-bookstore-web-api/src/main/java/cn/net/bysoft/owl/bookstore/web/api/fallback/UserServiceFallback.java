package cn.net.bysoft.owl.bookstore.web.api.fallback;

import org.springframework.stereotype.Component;

import cn.net.bysoft.owl.bookstore.facade.user.entity.User;
import cn.net.bysoft.owl.bookstore.web.api.service.UserService;

@Component
public class UserServiceFallback implements UserService {

	@Override
	public Boolean isExistsByEmail(String email) {
		return false;
	}

	@Override
	public User findById(Long id) {
		return null;
	}

}
