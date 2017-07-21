package cn.net.bysoft.owl.bookstore.facade.user.service;

import cn.net.bysoft.owl.bookstore.facade.user.entity.User;

public interface UserFacade {

	Boolean isExistsByEmail(String email);

	Boolean signUp(User user);

}
