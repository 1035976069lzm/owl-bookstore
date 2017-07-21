package cn.net.bysoft.owl.bookstore.web.console.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import cn.net.bysoft.owl.bookstore.facade.user.entity.User;

@Service
public class UserService {

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "getAllFallback")
	public Boolean isExistsByEmail(String email) {
		UriComponents uriComponents = UriComponentsBuilder.fromUriString("http://SERVICE-USER/users/{email}/").build()
				.expand(email).encode();
		URI uri = uriComponents.toUri();
		return restTemplate.getForObject(uri, Boolean.class);
	}

	public Boolean signUp(User user) {
		UriComponents uriComponents = UriComponentsBuilder.fromUriString("http://SERVICE-USER/users").build().encode();
		URI uri = uriComponents.toUri();
		return restTemplate.postForObject(uri, user, Boolean.class);
	}

	protected Boolean getAllFallback(String email, Throwable e) {
		return false;
	}

}