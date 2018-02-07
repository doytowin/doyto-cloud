package win.doyto.cloud;


import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * CloudRegistryApp
 *
 * @author f0rb on 2016-12-20.
 */
@EnableZuulProxy
//@EnableSidecar
@SpringCloudApplication
public class CloudGatewayApp {
    public static void main(String[] args) {
        SpringApplication.run(CloudGatewayApp.class, args);
    }

    @Bean
    public LogFilter logFilter() {
        return new LogFilter();
    }

    //@Override
    //protected void configure(HttpSecurity httpSecurity) throws Exception {
    //    httpSecurity.addFilterBefore(corsFilter(), ChannelProcessingFilter.class);
    //}
}
