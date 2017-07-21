package cn.net.bysoft.owl.bookstore.service.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = { "cn.net.bysoft.owl.bookstore.service.user.dao.impl" })
public class OwlBookstoreServiceUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(OwlBookstoreServiceUserApplication.class, args);
    }

}
