package cn.net.bysoft.owl.bookstore.web.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.net.bysoft.owl.bookstore.facade.user.entity.User;
import cn.net.bysoft.owl.bookstore.web.api.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/users/{email}/", method = RequestMethod.GET)
	public Boolean isExistsByEmail(@PathVariable String email) {
		return userService.isExistsByEmail(email);
	}
	
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public User findById(@PathVariable Long id) {
		System.out.println("feign");
		return userService.findById(id);
	}

}
