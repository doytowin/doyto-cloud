package win.doyto.cloud;


import javax.servlet.Filter;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

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
    public SimpleFilter simpleFilter() {
        return new SimpleFilter();
    }

    @Bean
    public Filter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        config.addExposedHeader("x-auth-token");
        config.addExposedHeader("x-total-count");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

    //@Override
    //protected void configure(HttpSecurity httpSecurity) throws Exception {
    //    httpSecurity.addFilterBefore(corsFilter(), ChannelProcessingFilter.class);
    //}
}
