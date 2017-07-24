package cn.net.bysoft.owl.bookstore.web.api.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.net.bysoft.owl.bookstore.facade.user.entity.User;
import cn.net.bysoft.owl.bookstore.web.api.fallback.UserServiceFallbackFactory;

@FeignClient(value = "SERVICE-USER", fallbackFactory = UserServiceFallbackFactory.class)
public interface UserService {

	@RequestMapping(value = "/users/{email}/", method = RequestMethod.GET)
	Boolean isExistsByEmail(@PathVariable("email") String email);

	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	User findById(@PathVariable("id") Long id);

}