package cn.net.bysoft.owl.bookstore.facade.user.entity;

import cn.net.bysoft.owl.bookstore.common.entity.BaseEntity;

public class User extends BaseEntity {

	private static final long serialVersionUID = 2197323023308317434L;
	private String email;
    private String mobile;
    private String password;
    private UserDetail detail;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserDetail getDetail() {
        return detail;
    }

    public void setDetail(UserDetail detail) {
        this.detail = detail;
    }

}
