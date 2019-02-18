package win.doyto.cloud.cors;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * CorsFilter
 *
 * @author f0rb
 * @date 2018-05-10
 */
@Slf4j
@Order(1)
@WebFilter(urlPatterns = "/*", filterName = "doytoCorsFilter")
public class CorsFilter extends OncePerRequestFilter {

    @Value("${doyto.allowed.origin:doyto.win}")
    private String crossOrigin;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException,IOException {

        if (CorsUtils.isCorsRequest(request)) {
            String requestOrigin = request.getHeader(HttpHeaders.ORIGIN);
            if (requestOrigin.endsWith(crossOrigin)) {
                response.setHeader("Access-Control-Allow-Origin", requestOrigin);
                response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, PATCH, OPTIONS, DELETE");
                response.setHeader("Access-Control-Allow-Credentials", "true");
                response.setHeader("Access-Control-Max-Age", "3600");
                response.setHeader("Access-Control-Allow-Headers",
                                   "Accept, Cache-Control, Content-Type, Content-Encoding, Content-Language, Content-Location, Content-disposition, Expires, Last-Modified, Set-Cookie, client-id, client-secret, x-auth-token");
                logger.debug("doFilterInternal: matches origin => " + requestOrigin);
                if (CorsUtils.isPreFlightRequest(request)) {
                    return;
                }
            }
        }

        filterChain.doFilter(request, response);
    }

}
