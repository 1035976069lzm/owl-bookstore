package cn.net.bysoft.owl.bookstore.web.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class OwlBookstoreWebZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(OwlBookstoreWebZuulApplication.class, args);
	}
}
