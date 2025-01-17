package cn.net.bysoft.owl.bookstore.service.user.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.net.bysoft.owl.bookstore.facade.user.entity.User;
import cn.net.bysoft.owl.bookstore.facade.user.service.UserFacade;
import cn.net.bysoft.owl.bookstore.service.user.biz.UserBiz;

@RestController
public class UserFacadeImpl implements UserFacade {

    @Autowired
    private UserBiz userBiz;

    @RequestMapping(value = "/users/{email}/", method = RequestMethod.GET)
    @Override
    public Boolean isExistsByEmail(@PathVariable String email) {
        return userBiz.isExistsByEmail(email);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    @Override
    public Boolean signUp(@RequestBody User user) {
        return userBiz.signUp(user);
    }

    @RequestMapping(value = "/users/{id}")
	@Override
	public User findById(@PathVariable Long id) {
		return userBiz.findById(id);
	}
    
    

}
