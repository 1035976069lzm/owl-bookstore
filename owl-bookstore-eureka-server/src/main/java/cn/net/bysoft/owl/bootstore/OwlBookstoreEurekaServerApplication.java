package cn.net.bysoft.owl.bootstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * <ul>
 * <li>使用<em>@EnableEurekaServer</em>来修饰主类；</li>
 * </ul>
 * 
 * @author xuepeng
 */
@SpringBootApplication
@EnableEurekaServer
public class OwlBookstoreEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OwlBookstoreEurekaServerApplication.class, args);
    }
    
}
