package win.doyto.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * CloudRegistryApp
 *
 * @author f0rb on 2016-12-20.
 */
@SpringBootApplication
@EnableEurekaServer
public class CloudRegistryApp {
    public static void main(String[] args) {
        SpringApplication.run(CloudRegistryApp.class, args);
    }
}
