package win.doyto.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * CloudConfigApp
 *
 * @author f0rb on 2016-12-20.
 */
//@Configuration
//@EnableAutoConfiguration
@EnableDiscoveryClient
@EnableConfigServer
@SpringBootApplication
public class CloudConfigApp {
    public static void main(String[] args) {
        SpringApplication.run(CloudConfigApp.class, args);
    }
}
