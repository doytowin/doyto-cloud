package win.doyto.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * CloudGatewayApp
 *
 * @author f0rb on 2016-12-20.
 */
@EnableZuulProxy
@SpringCloudApplication
@ServletComponentScan
public class CloudGatewayApp {
    public static void main(String[] args) {
        SpringApplication.run(CloudGatewayApp.class, args);
    }
}
