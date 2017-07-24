package cn.net.bysoft.owl.bookstore.web.console.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.net.bysoft.owl.bookstore.facade.user.entity.User;
import cn.net.bysoft.owl.bookstore.web.console.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users/{email}/", method = RequestMethod.GET)
    public Boolean isExists(@PathVariable String email) {
        return userService.isExistsByEmail(email);
    }
    
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public User findById(@PathVariable Long id) {
		return userService.findById(id);
	}

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public Boolean signUp(@RequestBody User user) {
        return userService.signUp(user);
    }

}
