package cn.net.bysoft.owl.bookstore.web.api.fallback;

import org.springframework.stereotype.Component;

import cn.net.bysoft.owl.bookstore.web.api.service.UserService;
import feign.hystrix.FallbackFactory;

@Component
public class UserServiceFallbackFactory implements FallbackFactory<UserService> {

	@Override
	public UserService create(Throwable cause) {
		return new UserService() {
			@Override
			public Boolean isExistsByEmail(String email) {
				System.out.println(cause.getMessage());
				return false;
			}
		};
	}

}
